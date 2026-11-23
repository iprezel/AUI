package pl.mateusz.company.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import pl.mateusz.company.FoodCompany;

import java.util.UUID;

@Getter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetFoodCompanyResponse {
    private UUID id;
    private String name;
    private String nip;
    @JsonProperty("isPolish")
    private boolean polish;

    public static GetFoodCompanyResponse from(FoodCompany foodCompany) {
        return GetFoodCompanyResponse.builder()
                .id(foodCompany.getId())
                .name(foodCompany.getName())
                .nip(foodCompany.getNip())
                .polish(foodCompany.isPolish())
                .build();
    }
}
