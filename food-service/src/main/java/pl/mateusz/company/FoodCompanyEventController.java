package pl.mateusz.company;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/companies")
@RequiredArgsConstructor
public class FoodCompanyEventController {
    private final FoodCompanyService service;

    @PutMapping("/{id}")
    public ResponseEntity<Void> putFoodCompany(@PathVariable UUID id) {
        FoodCompany company = FoodCompany.builder().id(id).build();
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
