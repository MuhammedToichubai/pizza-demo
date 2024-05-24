package peaksoft.pizzademo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import peaksoft.pizzademo.application.DefaultPizzaService;
import peaksoft.pizzademo.application.PizzaService;
import peaksoft.pizzademo.application.port.PizzaRepo;

@Configuration
public class AppConfig {

    @Bean
    PizzaService pizzaService(PizzaRepo pizzaRepo) {
        return new DefaultPizzaService(pizzaRepo);
    }
}
