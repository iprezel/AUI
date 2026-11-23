package pl.mateusz.food;

import jakarta.persistence.*;
import lombok.*;
import pl.mateusz.company.FoodCompany;

import java.io.Serial;
import java.io.Serializable;
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
    @ManyToOne // Default is FetchType.Eager;
    @JoinColumn(name = "food_company")
    private FoodCompany foodCompany;

    @Override
    public int compareTo(Food other) {
        int result = this.name.compareTo(other.name);
        if (result == 0) result = Integer.compare(this.price, other.price);
        if (result == 0) result = Integer.compare(this.quantity, other.quantity);
        if (result == 0) result = this.foodCompany.compareTo(other.foodCompany);
        return result;
    }

}