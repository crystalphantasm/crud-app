package com.bootcamp.crud.model;

import javax.persistence.*;

@Entity // Class where you put column names
@Table(name = "pc") // Table name
public class PC {

    // Puts auto increment onto id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Columns
    private long id;
    private String name;
    private String type;
    private String brand;
    private int price;

    public PC() {
    }

    public PC(long id, String name, String type, String brand, int price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.brand = brand;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

