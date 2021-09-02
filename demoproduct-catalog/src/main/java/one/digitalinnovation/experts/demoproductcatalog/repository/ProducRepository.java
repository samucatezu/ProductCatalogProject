package one.digitalinnovation.experts.demoproductcatalog.repository;

import one.digitalinnovation.experts.demoproductcatalog.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProducRepository extends CrudRepository<Product, Integer> {
}
