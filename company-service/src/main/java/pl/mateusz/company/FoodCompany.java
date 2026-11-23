package pl.mateusz.company;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.*;

@Getter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "companies")
public class FoodCompany implements Serializable, Comparable<FoodCompany> {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    private UUID id;
    @EqualsAndHashCode.Include
    @Column(name = "name")
    private String name;
    @EqualsAndHashCode.Include
    @Column(name = "nip", unique = true)
    private String nip;
    @EqualsAndHashCode.Include
    @Column(name = "is_polish")
    private boolean isPolish;

    @Override
    public int compareTo(FoodCompany o) {
        int result =  this.name.compareTo(o.name);
        if (result == 0) result = this.nip.compareTo(o.nip);
        if (result == 0) result = Boolean.compare(this.isPolish, o.isPolish);
        return result;
    }
}