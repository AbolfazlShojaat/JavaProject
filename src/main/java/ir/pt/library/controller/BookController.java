package ir.pt.library.controller;

import ir.pt.library.model.BookDTO;
import ir.pt.library.service.BookService;
import ir.pt.library.service.DownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private DownloadService downloadService;


    @PostMapping(value = "/add/{id}")
    public ResponseEntity addBook(@RequestBody BookDTO book, @PathVariable String id) throws Exception {
        try {
            return ResponseEntity.ok().body(bookService.create(book, id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping(value = "/get")
    public ResponseEntity searchBook(@RequestParam Integer id) throws Exception {
        return ResponseEntity.ok(bookService.get(id));
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity selectBook() throws Exception {
        return ResponseEntity.ok(bookService.getAll());
    }

    @GetMapping(value = "/getAWPAS/{pageNum}/{pageSize}/{field}")
    public ResponseEntity getAllWithPagination(@PathVariable Integer pageNum, @PathVariable Integer pageSize, @PathVariable String field) throws Exception {
        return ResponseEntity.ok(bookService.getAllWithPaginationAndSorting(pageNum, pageSize, field));
    }

    @PutMapping(value = "/update")
    public ResponseEntity updateBook(@RequestBody BookDTO book) throws Exception {
        return ResponseEntity.ok(bookService.update(book));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(bookService.delete(id));
    }
//    @PostMapping(value = "/upload")
//    public ResponseEntity uploadBook(@RequestParam("file") MultipartFile file) throws IOException {
//        return ResponseEntity.ok().body(file.getBytes());
//    }

    @PostMapping("/uploadCover/{id}")
    public ResponseEntity uploadCover(@RequestPart MultipartFile cover, @PathVariable Integer id) throws IOException {
        return ResponseEntity.ok().body(this.bookService.uploadCover(cover , id));
    }
//
//    @PostMapping("/uploadFile")
//    public ResponseEntity uploadFile(@RequestPart MultipartFile file, @RequestPart BookDTO book) throws IOException {
//        return ResponseEntity.ok().body(this.bookService.uploadFile(file, book));
//    }

//    @GetMapping("/downloadFile")
//    public ResponseEntity getFile(@RequestParam Integer id) {
//        return ResponseEntity.ok().body(this.downloadService.downloadFile(id));
//    }
}