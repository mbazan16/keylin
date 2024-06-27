package com.keylin.clubs.entities;

import java.time.LocalDate;
import com.keylin.clubs.entities.common.Cathegory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Club")
public class Club {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String description;
    
    @Column(name = "created_on")
    private LocalDate createdOn;
    
    private String city;

    @Enumerated(EnumType.STRING)
    private Cathegory cathegory;
    
    // Constructor
    public Club() {
        super();
    }
    
    // Getters and setters
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

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
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

    @Override
    public String toString() {
        return "Club [id=" + id + ", name=" + name + ", description=" + description + ", createdOn=" + createdOn
                + ", city=" + city + ", cathegory=" + cathegory + "]";
    }
}
