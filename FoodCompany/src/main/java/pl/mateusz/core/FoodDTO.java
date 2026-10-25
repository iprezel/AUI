package pl.mateusz.core;

import lombok.*;

import java.util.Objects;
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Builder
public class FoodDTO implements Comparable<FoodDTO>{

    private final String name;
    private final int price;
    private final int quantity;
    private final String foodCompany;


    public static FoodDTO fromFood(Food food) {
        return FoodDTO.builder()
                .name(food.getName())
                .price(food.getPrice())
                .quantity(food.getQuantity())
                .foodCompany(food.getCompany() != null ? food.getCompany().getName() : "none")
                .build();
    }

    @Override
    public int compareTo(FoodDTO other) {
        int result = this.name.compareTo(other.name);
        if (result == 0) {
            result = this.foodCompany.compareTo(other.foodCompany);
        }
        return result;
    }

}