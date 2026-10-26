package pl.mateusz.core;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
