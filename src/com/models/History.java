package com.models;


public class History {

    Book book;
    String operationType;
    public String date;

    History(Book book, String operationType, String date) {
        this.book = book;
        this.operationType = operationType;
        this.date = date;
    }

    public void display() {
        System.out.println("Book ID: " + book.id);
        System.out.println("Book Name: " + book.name);
        System.out.println("Book Stock: " + book.stock);
        System.out.println("Operation Type: " + operationType);
        System.out.println("Date: " + date);
    }

    public static History logReturnBook(Book book, String date) {
        return new History(book, "Return a book", date);
    }

    public static History logGetBook(Book book, String date) {
        return new History(book, "Get a book", date);
    }

    public static History reportMissing(Book book, String date) {
        return new History(book, "Report missing", date);
    }

    static History logStockUpdate(Book book, String date) {
        return new History(book, "Update stock", date);
    }

    static History log(String description, String date) {
        return new History(null, description, date);
    }

}
