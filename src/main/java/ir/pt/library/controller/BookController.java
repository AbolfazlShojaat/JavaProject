package ir.pt.library.controller;

import ir.pt.library.model.BookDTO;
import ir.pt.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private BookService bookService;


    @PostMapping(value = "/add")
    public ResponseEntity addBook(@RequestBody BookDTO book) throws Exception {
        return ResponseEntity.ok().body(bookService.create(book));
    }

    @GetMapping(value = "/get")
    public ResponseEntity searchBook(@RequestParam Integer id) throws Exception {
        return ResponseEntity.ok(bookService.get(id));
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity selectBook() throws Exception {
        return ResponseEntity.ok(bookService.getAll());
    }

    @PutMapping(value = "/update")
    public ResponseEntity updateBook(@RequestBody BookDTO book) throws Exception {
        return ResponseEntity.ok(bookService.update(book));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(bookService.delete(id));
    }
}

