package com.models;

public class Book {

    public int id;
    public String name;
    public int stock;

    public Book(int id, String name, int stock) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        System.out.println("Testing");
    }

}
