package pl.mateusz.food;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mateusz.company.FoodCompany;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class FoodService {
    private final FoodRepository repository;

    public List<Food> findAll() {
        return repository.findAll();
    }

    public boolean saveFood(Food food) {
        boolean isNew = !repository.existsById(food.getId());
        repository.save(food);
        return isNew;
    }

    public Optional<Food> findById(UUID id) {
        return repository.findById(id);
    }

    public List<Food> findByFoodCompany(FoodCompany company) {
        return repository.findByFoodCompany(company);
    }

    public boolean deleteFood(UUID foodID) {
        return repository.findById(foodID)
                .map(food -> { repository.delete(food); return true; })
                .orElse(false);
    }

}
