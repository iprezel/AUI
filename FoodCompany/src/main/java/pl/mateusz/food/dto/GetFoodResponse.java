package pl.mateusz.food.dto;
import lombok.*;
import pl.mateusz.food.Food;

import java.util.UUID;

@Getter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetFoodResponse {

    @Getter
    @ToString
    @EqualsAndHashCode(exclude = "id")
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class FoodCompany{
        private UUID id;
        private String name;
    }

    private UUID id;
    private String name;
    private int price;
    private int quantity;
    private FoodCompany foodCompany;

    public static GetFoodResponse from(Food food){
        return GetFoodResponse.builder()
                .id(food.getId())
                .name(food.getName())
                .price(food.getPrice())
                .quantity(food.getQuantity())
                .foodCompany(FoodCompany.builder().id(food.getFoodCompany().getId()).name(food.getFoodCompany().getName()).build())
                .build();
    }
}
