package pl.mateusz.core;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FoodCompanyRepository extends JpaRepository<FoodCompany, UUID> {
}
