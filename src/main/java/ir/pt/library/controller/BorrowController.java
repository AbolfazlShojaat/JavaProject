package ir.pt.library.controller;

import ir.pt.library.model.BorrowDTO;
import ir.pt.library.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/borrow")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @PostMapping(value = "/add")
    public ResponseEntity addPerson(@RequestBody BorrowDTO borrowDTO) throws Exception {
        return ResponseEntity.ok().body(borrowService.create(borrowDTO));
    }

    @PostMapping(value = "/lendingBooks")
    public ResponseEntity BarrowBook (@RequestBody BorrowDTO borrowDTO) throws Exception{
        return  ResponseEntity.ok(borrowService.lendingBooks(borrowDTO));
    }

    @DeleteMapping(value = "/returnbooks/{id}")
    public ResponseEntity Returnbook (@PathVariable Integer id) throws Exception{
        return  ResponseEntity.ok(borrowService.Returnbook(id));
    }

    @GetMapping(value = "/getPersonById")
    public ResponseEntity getByPersonId(@RequestParam Integer id) throws Exception {
        return ResponseEntity.ok(borrowService.getAllBorrowPerson(id));
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity getAllBorrow() throws Exception {
        return ResponseEntity.ok(borrowService.getAllBorrow());
    }

//    @GetMapping(value = "/get")
//    public ResponseEntity searchPerson(@RequestParam Integer id) throws Exception {
//        return ResponseEntity.ok(service.personGetBorrow(id));
//    }
}
