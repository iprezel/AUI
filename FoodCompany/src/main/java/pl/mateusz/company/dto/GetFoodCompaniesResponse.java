package pl.mateusz.company.dto;

import lombok.*;
import pl.mateusz.company.FoodCompany;

import java.util.ArrayList;
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
    public static class DTO { //old FoodCompany
        private UUID id;
        private String name;
    }

    private List<DTO> foodCompanies;

    public static GetFoodCompaniesResponse from(List<FoodCompany> foodCompanies){
        List<DTO> foodCompanyList = new ArrayList<>();
        for (FoodCompany f : foodCompanies) {
            foodCompanyList.add(DTO.builder().id(f.getId()).name(f.getName()).build());
        }
        return GetFoodCompaniesResponse.builder().foodCompanies(foodCompanyList).build();
    }
}
