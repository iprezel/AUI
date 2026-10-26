package pl.mateusz.food;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mateusz.company.FoodCompany;

import java.util.UUID;

@Repository
public interface FoodRepository extends JpaRepository<Food, UUID> {
    Iterable<Food> findByFoodCompany(FoodCompany foodCompany);
}
