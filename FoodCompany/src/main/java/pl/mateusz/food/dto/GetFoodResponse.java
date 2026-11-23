package pl.mateusz.food.dto;
import lombok.*;

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
}
