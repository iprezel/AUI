package pl.mateusz.core;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import pl.mateusz.company.FoodCompany;
import pl.mateusz.company.FoodCompanyService;
import pl.mateusz.food.FoodService;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataInitializer implements InitializingBean {
    private final FoodService foodService;
    private final FoodCompanyService foodCompanyService;

    @Override
    public void afterPropertiesSet() throws Exception {
        foodCompanyService.saveFoodCompany(FoodCompany.builder()
                .id(UUID.randomUUID())
                .name("Legsad")
                .nip("6912552643")
                .isPolish(true)
                .build());
        foodCompanyService.saveFoodCompany(FoodCompany.builder()
                .id(UUID.randomUUID())
                .name("Sokołów")
                .nip("8230001444")
                .isPolish(false)
                .build());
        foodCompanyService.saveFoodCompany(FoodCompany.builder()
                .id(UUID.randomUUID())
                .name("Ferrero")
                .nip("5220101131")
                .isPolish(false)
                .build());


    }

}
