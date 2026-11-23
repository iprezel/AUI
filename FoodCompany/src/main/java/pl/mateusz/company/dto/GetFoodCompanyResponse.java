package pl.mateusz.company.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.util.List;
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
}
