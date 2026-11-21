package pl.mateusz.company;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FoodCompanyService {
    private final FoodCompanyRepository repository;

    public List<FoodCompany> findAll(){
        return repository.findAll();
    }

    public boolean saveFoodCompany(FoodCompany foodCompany){
        boolean isNew = !repository.existsById(foodCompany.getId());
        repository.save(foodCompany);
        return isNew;
    }

    public Optional<FoodCompany> findById(UUID id) {
        return repository.findById(id);
    }
}
