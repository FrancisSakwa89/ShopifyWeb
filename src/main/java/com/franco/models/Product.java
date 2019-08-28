package com.franco.models;

public class Product {
    String name;
    int id;
    String description;


    public Product() {
    }

    public Product(String name, String description) {
        this.name = name;
//        this.id = id;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {

        return "Name: "+name+" "+"Id: "+id+" "+"Description: "+description;
    }
}
