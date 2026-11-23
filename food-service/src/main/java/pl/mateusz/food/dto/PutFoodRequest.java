package pl.mateusz.food.dto;

import lombok.*;
import pl.mateusz.company.FoodCompany;
import pl.mateusz.food.Food;

import java.util.UUID;

@Getter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PutFoodRequest {
    private String name;
    private int price;
    private int quantity;

    public static Food from(PutFoodRequest foodRequest, UUID id, FoodCompany foodCompany){
        return Food.builder()
                .id(id)
                .name(foodRequest.getName())
                .price(foodRequest.getPrice())
                .quantity(foodRequest.getQuantity())
                .foodCompany(foodCompany)
                .build();
    }
}
