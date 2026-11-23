package pl.mateusz.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface FoodCompanyRepository extends JpaRepository<FoodCompany, UUID> {
    Optional<FoodCompany> findByNip(String nip);
}
