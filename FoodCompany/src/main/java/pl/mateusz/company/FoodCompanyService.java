package pl.mateusz.company;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodCompanyService {
    private final FoodCompanyRepository repository;

    public List<FoodCompany> findAll(){
        return repository.findAll();
    }

    public boolean saveFoodCompany(FoodCompany foodCompany){
        boolean isNew = repository.existsById(foodCompany.getId());
        repository.save(foodCompany);
        return isNew;
    }
}
