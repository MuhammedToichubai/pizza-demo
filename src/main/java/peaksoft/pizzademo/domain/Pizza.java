package peaksoft.pizzademo.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Pizza {
    private PizzaId pizzaId;
    private String name;
    private String description;
    private Double price;
    private int size;

    public void setValuesTo(Pizza pizza) {
        if (pizza == null) return;
        pizza.setName(this.name);
        pizza.setDescription(this.description);
        pizza.setPrice(this.price);
        pizza.setSize(this.size);
    }
}
