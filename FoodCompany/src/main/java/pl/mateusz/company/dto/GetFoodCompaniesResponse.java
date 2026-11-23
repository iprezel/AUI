package pl.mateusz.company.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetFoodCompaniesResponse {
    @Getter
    @ToString
    @EqualsAndHashCode
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class FoodCompany{
        private UUID id;
        private String name;
    }

    private List<FoodCompany> foodCompanies;
}
