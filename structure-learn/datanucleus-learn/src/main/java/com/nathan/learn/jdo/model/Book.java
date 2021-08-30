package com.nathan.learn.jdo.model;


public class Book {
    long id;
    long updateTime;
    String author = null;
    String isbn = null;
    String publisher = null;

    public Book(String author, String isbn, String publisher) {
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
    }

    public long getId() {
        return id;
    }
}
