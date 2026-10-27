package pl.mateusz.food;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public void deleteFood(UUID foodID){
        repository.findById(foodID).ifPresent(repository::delete);
    }
}
