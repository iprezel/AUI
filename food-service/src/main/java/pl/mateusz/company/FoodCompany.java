package pl.mateusz.company;

import jakarta.persistence.*;
import lombok.*;
import pl.mateusz.food.Food;


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
    @EqualsAndHashCode.Include
    @Id
    private UUID id;
    @ToString.Exclude
    @Builder.Default
    @OneToMany(mappedBy = "foodCompany", cascade = CascadeType.REMOVE) // Default is FetchType.LAZY;
    private List<Food> foods = new ArrayList<>();

    public void addFood(Food food) {
        foods.add(food);
    }

    @Override
    public int compareTo(FoodCompany o) {
        return this.id.compareTo(o.id);
    }
}