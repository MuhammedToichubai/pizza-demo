package peaksoft.pizzademo.adapter.out.jdbc;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.pizzademo.application.NotFoundException;
import peaksoft.pizzademo.application.port.PizzaRepo;
import peaksoft.pizzademo.domain.Pizza;
import peaksoft.pizzademo.domain.PizzaId;

import java.util.List;
import java.util.Optional;

@Repository
public class DefaultPizzaRepo implements PizzaRepo {
    private final PizzaJdbcRepo pizzaJdbcRepo;

    public DefaultPizzaRepo(PizzaJdbcRepo pizzaJdbcRepo) {
        this.pizzaJdbcRepo = pizzaJdbcRepo;
    }

    @Override
    public List<Pizza> findAll(int page, int size) {
        return pizzaJdbcRepo.findAll(PageRequest.of(page, size))
                .map(PizzaDbo::toPizza)
                .getContent();
    }

    @Override
    public Pizza save(Pizza newPizza) {
        return pizzaJdbcRepo.save(
                PizzaDbo.fromPizza(newPizza)
        ).toPizza();
    }

    @Override
    public Optional<Pizza> findById(PizzaId pizzaId) {
        return pizzaJdbcRepo.findById(pizzaId.getPizzaId())
                .map(PizzaDbo::toPizza);
    }

    @Override
    @Transactional
    public Pizza updateById(PizzaId pizzaId, Pizza newPizza) {
        PizzaDbo pizzaDbo = pizzaJdbcRepo.findById(pizzaId.getPizzaId())
                .orElseThrow(() -> new NotFoundException(Pizza.class));
        pizzaDbo.updateValues(newPizza);
        return pizzaJdbcRepo.save(pizzaDbo).toPizza();
    }

    @Override
    public void deleteById(PizzaId pizzaId) {
        // todo: check pizzaId
        pizzaJdbcRepo.deleteById(pizzaId.getPizzaId());
    }
}
