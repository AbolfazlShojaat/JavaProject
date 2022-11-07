package ir.pt.library.controller;

import ir.pt.library.model.Book;
import ir.pt.library.model.Category;
import ir.pt.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping(value = "/add")
    public ResponseEntity addBook(@RequestBody Book book) throws Exception {
//        bookService.create(book);
        return ResponseEntity.ok(bookService.create(book));
    }

    @GetMapping(value = "/select")
    public ResponseEntity selectBook() throws Exception {
        return ResponseEntity.ok(bookService.getList());
    }

    @GetMapping(value = "/search")
    public ResponseEntity searchBook() throws Exception {
        Book book = new Book(2, "adabit", 784, new Date(02 / 02 / 1400));
        book.setCategory(new Category(1, "Arabi"));
        return ResponseEntity.ok(book);
    }


    @PutMapping(value = "/update")
    public ResponseEntity updateBook(@RequestBody Book book) throws Exception {
        book.setId(book.getId() + 1);
        return ResponseEntity.ok(book);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity deleteBook(@RequestBody Book book) throws Exception {
        book.setId(book.getId() + 1);
        return ResponseEntity.ok(book);
    }
}

