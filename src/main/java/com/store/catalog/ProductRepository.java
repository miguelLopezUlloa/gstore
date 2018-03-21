package com.store.catalog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.store.entities.Product;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	Product findByName(String name);

	Product findBySku(String sku);

	@Query("select p from Product p where p.name like ?1 or p.sku like ?1 or p.description like ?1")
	List<Product> search(String query);

}
