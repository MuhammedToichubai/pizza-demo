package peaksoft.pizzademo.application;

import peaksoft.pizzademo.domain.Pizza;
import peaksoft.pizzademo.domain.PizzaId;

import java.util.List;

public interface PizzaService {

    List<Pizza> findAll(int page, int size);

    Pizza save(Pizza newPizza);

    Pizza findById(PizzaId pizzaId);

    Pizza updateById(PizzaId pizzaId, Pizza newPizza);

    void deleteById(PizzaId pizzaId);
}
