package org.java.spring.db.pojo;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "pizza")
public class Pizza {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 32, nullable = false)
	@Length(min = 3, max = 50, message = "Il nome della pizza deve essere compreso tra i 3 e i 50 caratteri")
	@NotBlank(message = "Il nome non può essere vuoto")
	private String name;
	
	private String description;
	private String photo;
	
	@Column(nullable = false)
	@NotNull(message = "Il prezzo non può essere nullo")
    @Positive(message = "Il prezzo deve essere maggiore di 0")
	private Float price;
	
	public Pizza() {}
	public Pizza(String name, String description, String photo, float price) {
		setName(name);
		setDescription(description);
		setPhoto(photo);
		setPrice(price);
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Override
	public String toString() {

		return "[" + getId() + "] " + getName() + " - " + getDescription() + " (" + getPhoto() + ")" + " (" + getPrice()
				+ ")";
	}

}
