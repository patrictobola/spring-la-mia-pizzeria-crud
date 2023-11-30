package org.java.spring.controller;

import java.util.List;

import org.java.spring.db.pojo.Pizza;
import org.java.spring.db.repo.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

	@Autowired
	private PizzaRepository pizzaRepository;

	@GetMapping("/")
	public String homepage(Model model) {
		List<Pizza> result = pizzaRepository.findAll();
		model.addAttribute("pizzas", result);
		return "index";
	}

	@GetMapping("/pizza/{id}")
	public String showPizzaDetails(@PathVariable("id") int id, Model model) {
		Pizza selectedPizza = getPizzaById(id);
		model.addAttribute("pizza", selectedPizza);
		return "pizzaDetails";
	}

	private Pizza getPizzaById(int id) {
		List<Pizza> pizzas = pizzaRepository.findAll();
		return pizzas.stream().filter(pizza -> pizza.getId() == id).findFirst().orElse(null);
	}
}
