package peaksoft.pizzademo.adapter.in.web;


import org.springframework.web.bind.annotation.*;
import peaksoft.pizzademo.adapter.in.web.dto.PizzaDto;
import peaksoft.pizzademo.application.PizzaService;
import peaksoft.pizzademo.domain.Pizza;
import peaksoft.pizzademo.domain.PizzaId;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pizza")
public class PizzaHttpController {
    private final PizzaService pizzaService;

    public PizzaHttpController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public List<Pizza> findAll(@RequestParam int page,
                               @RequestParam int size) {
        return pizzaService.findAll(page, size);
    }

    @PostMapping
    public Pizza save(@RequestBody PizzaDto newPizza) {
        return pizzaService.save(newPizza.toPizza());
    }

    @GetMapping("/{pizzaId}")
    public Pizza findById(@PathVariable Long pizzaId) {
        return pizzaService.findById(PizzaId.of(pizzaId));
    }

    @PutMapping("/{pizzaId}")
    public Pizza updateById(@PathVariable Long pizzaId,
                            @RequestBody PizzaDto newPizza) {

        return pizzaService.updateById(PizzaId.of(pizzaId), newPizza.toPizza());
    }

    @DeleteMapping("/{pizzaId}")
    public void deleteById(@PathVariable Long pizzaId) {
        pizzaService.deleteById(PizzaId.of(pizzaId));
    }
}