package peaksoft.pizzademo.adapter.in.web.dto;

import peaksoft.pizzademo.domain.Pizza;

public record PizzaDto(
        String name,
        String description,
        Double price,
        int size
) {

    public Pizza toPizza() {
        Pizza newPizza = new Pizza();
        newPizza.setName(this.name);
        newPizza.setDescription(this.description);
        newPizza.setPrice(this.price);
        newPizza.setSize(this.size);
        return newPizza;
    }
}
