package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    @GetMapping
    public ResponseEntity book() throws Exception {
        List<Book> listBook = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Book book = new Book(i + 10);
            book.setName("عربی");
            book.setPrice(75000);
            listBook.add(book);
        }
        return ResponseEntity.ok(listBook);
    }

    @PostMapping
    public ResponseEntity book1() throws Exception {
        List<Book> listBook = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Book book = new Book(i + 10);
            book.setName("تاریخ");
            book.setPrice(150000);
            listBook.add(book);
        }
        return ResponseEntity.ok(listBook);
    }
    @PutMapping
    public ResponseEntity book2() throws Exception {
        List<Book> listBook = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Book book = new Book(i + 10);
            book.setName("ریاضی");
            book.setPrice(75000);
            listBook.add(book);
        }
        return ResponseEntity.ok(listBook);
    }
    @DeleteMapping
    public ResponseEntity book3() throws Exception {
        List<Book> listBook = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Book book = new Book(i + 10);
            book.setName("قرآن");
            book.setPrice(75000);
            listBook.add(book);
        }
        return ResponseEntity.ok(listBook);
    }
}

