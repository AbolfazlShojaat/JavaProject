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
    private BorrowService service;

    @PostMapping(value = "/add")
    public ResponseEntity addPerson(@RequestBody BorrowDTO borrowDTO) throws Exception {
        return ResponseEntity.ok().body(service.create(borrowDTO));
    }

    @GetMapping(value = "/getAllPerson")
    public ResponseEntity getByPersonId(@RequestParam Integer id) throws Exception {
        return ResponseEntity.ok(service.getAllBorrowPerson(id));
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity getAllBorrow() throws Exception {
        return ResponseEntity.ok(service.getAllBorrow());
    }

//    @GetMapping(value = "/get")
//    public ResponseEntity searchPerson(@RequestParam Integer id) throws Exception {
//        return ResponseEntity.ok(service.personGetBorrow(id));
//    }
}
