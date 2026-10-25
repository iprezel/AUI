package pl.mateusz.core;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;
@Getter
@ToString
@EqualsAndHashCode(exclude = "id")
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "foods")
public class Food implements Comparable<Food>, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private int price;
    @Column(name = "quantity")
    private int quantity;
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "company")
    private FoodCompany company;

    @Override
    public int compareTo(Food other) {
        int result = this.name.compareTo(other.name);
        if (result == 0) {
            result = Integer.compare(this.price, other.price);
        }
        return result;
    }
}