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
//        bookService.create(book);
        return ResponseEntity.ok(bookService.create(book));
    }

//    @PostMapping(value = "/add")
//    public ResponseEntity addBook(@RequestBody Book book) throws Exception {
////        bookService.create(book);
//        return ResponseEntity.ok(bookService.create(book));
//    }

    @GetMapping(value = "/select")
    public ResponseEntity selectBook() throws Exception {
        return ResponseEntity.ok(bookService.getList());
    }

    @GetMapping(value = "/search")
    public ResponseEntity searchBook() throws Exception {
        return ResponseEntity.ok(bookService.get());
    }


    @PutMapping(value = "/update")
    public ResponseEntity updateBook(@RequestBody BookDTO book) throws Exception {
        return ResponseEntity.ok(book);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity deleteBook(@RequestBody BookDTO book) throws Exception {
        return ResponseEntity.ok(bookService.delete(2));
    }
}

