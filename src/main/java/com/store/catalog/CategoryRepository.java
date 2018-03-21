package com.store.catalog;

import org.springframework.data.jpa.repository.JpaRepository;
import com.store.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

	Category getByName(String name);

}
