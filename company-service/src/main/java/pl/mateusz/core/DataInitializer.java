package pl.mateusz.core;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import pl.mateusz.company.FoodCompany;
import pl.mateusz.company.FoodCompanyService;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataInitializer implements InitializingBean {
    private final FoodCompanyService foodCompanyService;

    @Override
    public void afterPropertiesSet() throws Exception {
        //Legsad
        foodCompanyService.saveFoodCompany(FoodCompany.builder()
                .id(UUID.nameUUIDFromBytes("Legsad".getBytes()))
                .name("Legsad")
                .nip("6912552643")
                .isPolish(true)
                .build());

        //Sokolow
        foodCompanyService.saveFoodCompany(FoodCompany.builder()
                .id(UUID.nameUUIDFromBytes("Sokołów".getBytes()))
                .name("Sokołów")
                .nip("8230001444")
                .isPolish(false)
                .build());

        //Ferrero
        foodCompanyService.saveFoodCompany(FoodCompany.builder()
                .id(UUID.nameUUIDFromBytes("Ferrero".getBytes()))
                .name("Ferrero")
                .nip("5220101131")
                .isPolish(false)
                .build());
    }

}
