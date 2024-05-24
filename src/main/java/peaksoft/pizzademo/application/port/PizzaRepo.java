package peaksoft.pizzademo.application.port;

import peaksoft.pizzademo.domain.Pizza;
import peaksoft.pizzademo.domain.PizzaId;

import java.util.List;
import java.util.Optional;

public interface PizzaRepo {

    List<Pizza> findAll(int page, int size);

    Pizza save(Pizza newPizza);

    Optional<Pizza> findById(PizzaId pizzaId);

    Pizza updateById(PizzaId pizzaId, Pizza newPizza);

    void deleteById(PizzaId pizzaId);
}
