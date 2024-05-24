package peaksoft.pizzademo.application;

import peaksoft.pizzademo.application.port.PizzaRepo;
import peaksoft.pizzademo.domain.Pizza;
import peaksoft.pizzademo.domain.PizzaId;

import java.util.List;

public class DefaultPizzaService implements PizzaService {
    private final PizzaRepo pizzaRepo;

    public DefaultPizzaService(PizzaRepo pizzaRepo) {
        this.pizzaRepo = pizzaRepo;
    }

    @Override
    public List<Pizza> findAll(int page, int size) {
        return pizzaRepo.findAll(page, size);
    }

    @Override
    public Pizza save(Pizza newPizza) {
        return pizzaRepo.save(newPizza);
    }

    @Override
    public Pizza findById(PizzaId pizzaId) {
        return pizzaRepo.findById(pizzaId)
                .orElseThrow(() -> new NotFoundException(Pizza.class));
    }

    @Override
    public Pizza updateById(PizzaId pizzaId,
                            Pizza newPizza) {
        return pizzaRepo.updateById(pizzaId, newPizza);
    }

    @Override
    public void deleteById(PizzaId pizzaId) {
        pizzaRepo.deleteById(pizzaId);
    }
}
