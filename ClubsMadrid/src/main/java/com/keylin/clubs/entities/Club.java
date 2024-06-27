package com.keylin.clubs.entities;

import java.time.LocalDate;

import com.keylin.clubs.entities.common.Cathegory;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Club")
public class Club {
	//Attributes
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private LocalDate created_On;
	private String city;
	private Cathegory cathegory;
	
	//Constructor
	public Club() {
		super();
	}
	
	//Getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public LocalDate getCreated_On() {
		return created_On;
	}

	public void setCreated_On(LocalDate created_On) {
		this.created_On = created_On;
	}

	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public Cathegory getCathegory() {
		return cathegory;
	}

	public void setCathegory(Cathegory cathegory) {
		this.cathegory = cathegory;
	}
	
	//ToString


	@Override
	public String toString() {
		return "Club [id=" + id + ", name=" + name + ", description=" + description + ", created_On=" + created_On
				+ ", city=" + city + ", cathegory=" + cathegory + "]";
	}
	
	
	
}
