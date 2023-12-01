package org.java.spring.db.repo;

import java.util.List;

import org.java.spring.db.pojo.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Integer>{
	List<Pizza> findByNameContainingIgnoreCase(String searchTerm);
}
