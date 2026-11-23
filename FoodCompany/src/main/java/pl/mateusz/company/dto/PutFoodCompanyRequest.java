package pl.mateusz.company.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

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
}
