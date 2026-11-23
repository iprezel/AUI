package pl.mateusz.food.dto;

import lombok.*;

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
    public static class Food{
        private UUID id;
        private String name;
    }

    private List<Food> foods;
}
