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
public class PutFoodCompanyRequest {
    private String name;
    private String nip;
    @JsonProperty("isPolish")
    private boolean polish;

    public static FoodCompany from(PutFoodCompanyRequest foodCompanyRequest, UUID id){
        return FoodCompany.builder()
                .id(id)
                .name(foodCompanyRequest.getName())
                .nip(foodCompanyRequest.getNip())
                .isPolish(foodCompanyRequest.isPolish())
                .build();
    }
}
