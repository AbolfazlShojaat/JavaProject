package com.example.demo;

public class Book {
    private int bookNumber;
    private int price;
    private String name;

    public Book(int bookNumber) {
        this.bookNumber = bookNumber;
    }

    public Book(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
