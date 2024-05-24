package peaksoft.pizzademo.adapter.out.jdbc;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PizzaJdbcRepo extends CrudRepository<PizzaDbo, Long>,
        PagingAndSortingRepository<PizzaDbo, Long> {
}
