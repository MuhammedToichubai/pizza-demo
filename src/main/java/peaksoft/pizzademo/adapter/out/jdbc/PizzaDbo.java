package peaksoft.pizzademo.adapter.out.jdbc;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import peaksoft.pizzademo.domain.Pizza;
import peaksoft.pizzademo.domain.PizzaId;

import java.util.Optional;

@Getter
@Setter
@Table("pizza")
public class PizzaDbo {
    @Id
    private Long id;
    private String name;
    private String description;
    private Double price;
    private int size;

    public static PizzaDbo fromPizza(Pizza pizza) {
        PizzaDbo pizzaDbo = new PizzaDbo();
        if (pizza.getPizzaId() != null) {
            pizzaDbo.setId(pizza.getPizzaId().getPizzaId());
        }
        pizzaDbo.setName(pizza.getName());
        pizzaDbo.setDescription(pizza.getDescription());
        pizzaDbo.setPrice(pizza.getPrice());
        pizzaDbo.setSize(pizza.getSize());
        return pizzaDbo;
    }

    public Pizza toPizza() {
        Pizza pizza = new Pizza();
        pizza.setPizzaId(
                PizzaId.of(this.id)
        );
        pizza.setName(this.name);
        pizza.setDescription(this.description);
        pizza.setPrice(this.price);
        pizza.setSize(this.size);
        return pizza;
    }

    public void updateValues(Pizza pizza) {
        this.name = pizza.getName();
        // todo: continue
    }
}
