package pl.mateusz.core;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import pl.mateusz.company.FoodCompany;
import pl.mateusz.company.FoodCompanyService;
import pl.mateusz.food.Food;
import pl.mateusz.food.FoodService;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataInitializer implements InitializingBean {
    private final FoodService foodService;
    private final FoodCompanyService foodCompanyService;

    @Override
    public void afterPropertiesSet() throws Exception {
        //Legsad and food products
        foodCompanyService.saveFoodCompany(FoodCompany.builder()
                .id(UUID.nameUUIDFromBytes("Legsad".getBytes()))
                .name("Legsad")
                .nip("6912552643")
                .isPolish(true)
                .build());
        foodService.saveFood(Food.builder()
                .id(UUID.nameUUIDFromBytes("Raspberries".getBytes()))
                .name("Raspberries")
                .price(15)
                .quantity(200)
                .foodCompany(FoodCompany.builder().id(UUID.nameUUIDFromBytes("Legsad".getBytes())).build())
                .build());
        foodService.saveFood(Food.builder()
                .id(UUID.nameUUIDFromBytes("Blueberries".getBytes()))
                .name("Blueberries")
                .price(10)
                .quantity(300)
                .foodCompany(FoodCompany.builder().id(UUID.nameUUIDFromBytes("Legsad".getBytes())).build())
                .build());
        foodService.saveFood(Food.builder()
                .id(UUID.nameUUIDFromBytes("Strawberry".getBytes()))
                .name("Strawberry")
                .price(7)
                .quantity(400)
                .foodCompany(FoodCompany.builder().id(UUID.nameUUIDFromBytes("Legsad".getBytes())).build())
                .build());

        //Sokolow and food products
        foodCompanyService.saveFoodCompany(FoodCompany.builder()
                .id(UUID.nameUUIDFromBytes("Sokołów".getBytes()))
                .name("Sokołów")
                .nip("8230001444")
                .isPolish(false)
                .build());
        foodService.saveFood(Food.builder()
                .id(UUID.nameUUIDFromBytes("Chicken Breast".getBytes()))
                .name("Chicken Breast")
                .price(25)
                .quantity(1000)
                .foodCompany(FoodCompany.builder().id(UUID.nameUUIDFromBytes("Sokołów".getBytes())).build())
                .build());
        foodService.saveFood(Food.builder()
                .id(UUID.nameUUIDFromBytes("Beef Steak".getBytes()))
                .name("Beef Steak")
                .price(50)
                .quantity(1000)
                .foodCompany(FoodCompany.builder().id(UUID.nameUUIDFromBytes("Sokołów".getBytes())).build())
                .build());

        //Ferrero and food products
        foodCompanyService.saveFoodCompany(FoodCompany.builder()
                .id(UUID.nameUUIDFromBytes("Ferrero".getBytes()))
                .name("Ferrero")
                .nip("5220101131")
                .isPolish(false)
                .build());
        foodService.saveFood(Food.builder()
                .id(UUID.nameUUIDFromBytes("Ferrero Rocher".getBytes()))
                .name("Ferrero Rocher")
                .price(25)
                .quantity(150)
                .foodCompany(FoodCompany.builder().id(UUID.nameUUIDFromBytes("Ferrero".getBytes())).build())
                .build());
        foodService.saveFood(Food.builder()
                .id(UUID.nameUUIDFromBytes("Nutella".getBytes()))
                .name("Nutella")
                .price(20)
                .quantity(350)
                .foodCompany(FoodCompany.builder().id(UUID.nameUUIDFromBytes("Ferrero".getBytes())).build())
                .build());
    }

}
