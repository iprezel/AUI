package pl.mateusz.food.dto;

import lombok.*;

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
}
