package ir.pt.library.Controller;

import ir.pt.library.Model.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    @PostMapping(value = "/add")
    public ResponseEntity addBook(@RequestBody Book book) throws Exception {
        book.setId(book.getId() + 1);
        return ResponseEntity.ok().body(book);
    }

    @GetMapping(value = "/select")
    public ResponseEntity selectBook() throws Exception {
        List<Book> listBook = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Book book = new Book(i + 1, "arabi", "tarikh o adabiat", 192, new Date(01 / 01 / 1400));
            listBook.add(book);
        }
        return ResponseEntity.ok(listBook);
    }

    @GetMapping(value = "/search")
    public ResponseEntity searchBook() throws Exception {
        Book book = new Book(2, "adabit", "tarikh o adabiat", 784, new Date(02 / 02 / 1400));
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

