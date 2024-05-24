package peaksoft.pizzademo.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PizzaId {
    private Long pizzaId;

    public PizzaId() {
    }

    public PizzaId(Long pizzaId) {
        this.pizzaId = pizzaId;
    }

    public boolean isSamePizza(PizzaId pizzaId) {
        if (pizzaId == null) return false;
        return this.pizzaId.equals(pizzaId.getPizzaId());
    }

    public static PizzaId of(Long pizzaId) {
        return new PizzaId(pizzaId);
    }
}