package pl.mateusz.core;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;
@Getter
@ToString
@EqualsAndHashCode(exclude = "id")
@Builder
public class Food implements Comparable<Food>, Serializable {
    private static final long serialVersionUID = 1L;
    private UUID id;
    private final String name;
    private final int price;
    private final int quantity;
    @ToString.Exclude
    private final FoodCompany company;

    @Override
    public int compareTo(Food other) {
        int result = this.name.compareTo(other.name);
        if (result == 0) {
            result = Integer.compare(this.price, other.price);
        }
        return result;
    }
}