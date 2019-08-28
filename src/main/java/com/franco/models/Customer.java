package com.franco.models;

public class Customer {
    String name;
    int userId;

    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
//        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Name: "+name+ " Id: "+userId;
    }
}

