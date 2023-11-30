package org.java.spring;

import org.java.spring.db.pojo.Pizza;
import org.java.spring.db.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner{
	
	private static final String IMG_URL = "https://picsum.photos/200/300";
	
	@Autowired
	private PizzaService pizzaService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		pizzaService.save(new Pizza("Margherita", "Pomodoro, mozzarella", IMG_URL, 9.90f));
		pizzaService.save(new Pizza("Diavola", "Pomodoro, mozzarella, salami", IMG_URL, 9.90f));
		pizzaService.save(new Pizza("Verdure", "Mozzarella, verdure (ma dai?)", IMG_URL, 9.90f));
		pizzaService.save(new Pizza("Insalata di pollo", "Non ci crederai mai.... INSALATA DI POLLO!", IMG_URL, 9.90f));
		pizzaService.save(new Pizza("Pizza X", "Pomodoro, mozzarella e altri ingredienti segreti", IMG_URL, 9.90f));
		pizzaService.save(new Pizza("Napoli", "Pomodoro, Alici, Prezzemolo", IMG_URL, 9.90f));
	}
}
