package pl.mateusz.food;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.mateusz.company.FoodCompany;
import pl.mateusz.company.FoodCompanyService;
import pl.mateusz.company.dto.PutFoodCompanyRequest;
import pl.mateusz.food.dto.GetFoodResponse;
import pl.mateusz.food.dto.GetFoodsResponse;
import pl.mateusz.food.dto.PutFoodRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FoodController {
    private final FoodService foodService;
    private final FoodCompanyService foodCompanyService;
    @GetMapping("/foods")
    public GetFoodsResponse getFoods(){
        List<Food> foodList = foodService.findAll();
        return GetFoodsResponse.from(foodList);
    }

    @GetMapping("/foods/{id}")
    public GetFoodResponse getFood(@PathVariable UUID id) {
        Optional<Food> food = foodService.findById(id);
        if (food.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return GetFoodResponse.from(food.get());
    }

    @GetMapping("/companies/{id}/foods")
    public GetFoodsResponse getFoodCompanyFoods(@PathVariable UUID id) {
        Optional<FoodCompany> foodCompany = foodCompanyService.findById(id);
        if (foodCompany.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        List<Food> foods = foodService.findByFoodCompany(foodCompany.get());
        return GetFoodsResponse.from(foods);
    }

    @PutMapping("/companies/{companyId}/foods/{id}")
    public ResponseEntity<Void> putFood(@PathVariable UUID id, @RequestBody PutFoodRequest request, @PathVariable UUID companyId) {
        Optional<FoodCompany> foodCompany = foodCompanyService.findById(companyId);
        if (foodCompany.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Food food = PutFoodRequest.from(request, id, foodCompany.get());
        boolean isNew = foodService.saveFood(food);
        return ResponseEntity
                .status(isNew ? HttpStatus.CREATED : HttpStatus.OK)
                .build();
    }

    @DeleteMapping("/foods/{id}")
    public ResponseEntity<Void> deleteFood(@PathVariable UUID id) {
        if (foodService.deleteFood(id)) {
            return ResponseEntity.noContent().build();       // 204
        }
        return ResponseEntity.notFound().build();            // 404
    }

}
