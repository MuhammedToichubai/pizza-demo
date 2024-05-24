package peaksoft.pizzademo.application;

import peaksoft.pizzademo.application.port.PizzaRepo;
import peaksoft.pizzademo.domain.Pizza;
import peaksoft.pizzademo.domain.PizzaId;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryPizzaRepo implements PizzaRepo {

    private final List<Pizza> pizzaList = new ArrayList<>();

    @Override
    public List<Pizza> findAll(int page, int size) {
        return this.pizzaList;
    }

    @Override
    public Pizza save(Pizza newPizza) {
        this.pizzaList.add(newPizza);
        return newPizza;
    }

    @Override
    public Optional<Pizza> findById(PizzaId pizzaId) {
        return pizzaList.stream()
                .filter(p -> p.getPizzaId().isSamePizza(pizzaId))
                .findFirst();
    }

    @Override
    public Pizza updateById(PizzaId pizzaId, Pizza newPizza) {
        Pizza pizza = findById(pizzaId).orElseThrow(() -> new NotFoundException(Pizza.class));
        newPizza.setValuesTo(pizza);
        return pizza;
    }

    @Override
    public void deleteById(PizzaId pizzaId) {
        pizzaList.removeIf(pizza -> pizza.getPizzaId().isSamePizza(pizzaId));
    }
}
