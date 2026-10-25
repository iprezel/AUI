package pl.mateusz.core;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;


import java.io.Serializable;
import java.util.*;

@Getter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class FoodCompany implements Serializable, Comparable<FoodCompany> {
    private static final long serialVersionUID = 1L;
    @Builder.Default
    private final UUID id = UUID.randomUUID();
    @EqualsAndHashCode.Include
    private final String name;
    @EqualsAndHashCode.Include
    private final String nip;
    @EqualsAndHashCode.Include
    private final boolean isPolish;
    @ToString.Exclude
    @Builder.Default
    private final List<Food> foods = new ArrayList<>();

    public void addFood(Food food) {
        foods.add(food);
    }

    @Override
    public int compareTo(FoodCompany o) {
        return this.name.compareTo(o.name);
    }
}