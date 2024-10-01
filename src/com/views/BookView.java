package com.views;

import com.models.Book;

public class BookView {
    public void display(Book book) {
        System.out.println("Book ID: " + book.id);
        System.out.println("Book Name: " + book.name);
        System.out.println("Book Stock: " + book.stock);
    }
}
