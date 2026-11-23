package pl.mateusz.food.dto;

import lombok.*;
import pl.mateusz.food.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetFoodsResponse {
    @Getter
    @ToString
    @EqualsAndHashCode
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class DTO {//old Food
        private UUID id;
        private String name;
    }

    private List<DTO> foods;

    public static GetFoodsResponse from(List<Food> foods){
        List<DTO> foodList = new ArrayList<>();
        for (Food f : foods) {
            foodList.add(DTO.builder().id(f.getId()).name(f.getName()).build());
        }
        return GetFoodsResponse.builder().foods(foodList).build();
    }
}
