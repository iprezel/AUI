package pl.mateusz.company;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.mateusz.company.dto.GetFoodCompaniesResponse;
import pl.mateusz.company.dto.GetFoodCompanyResponse;
import pl.mateusz.company.dto.PutFoodCompanyRequest;
import pl.mateusz.food.FoodService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/companies")
@RequiredArgsConstructor
public class FoodCompanyController {
    private final FoodCompanyService service;
    private final FoodService foodService;

    @GetMapping
    public GetFoodCompaniesResponse getFoodCompanies(){
        List<FoodCompany> foodCompanyList = service.findAll();
        return GetFoodCompaniesResponse.from(foodCompanyList);
    }

    @GetMapping("/{id}")
    public GetFoodCompanyResponse getFoodCompany(@PathVariable UUID id) {
        Optional<FoodCompany> company = service.findById(id);
        if (company.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return GetFoodCompanyResponse.from(company.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> putFoodCompany(@PathVariable UUID id, @RequestBody PutFoodCompanyRequest request) {
        FoodCompany company = PutFoodCompanyRequest.from(request, id);
        Optional<FoodCompany> found = service.findByNip(company.getNip());
        if (found.isPresent() && !found.get().getId().equals(id)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build(); //409
        }
        boolean isNew = service.saveFoodCompany(company);
        return ResponseEntity
                .status(isNew ? HttpStatus.CREATED : HttpStatus.OK)
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFoodCompany(@PathVariable UUID id) {
        if (service.deleteFoodCompany(id)) {
            return ResponseEntity.noContent().build();       // 204
        }
        return ResponseEntity.notFound().build();            // 404
    }
}
