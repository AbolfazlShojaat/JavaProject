package ir.pt.library.controller;

import ir.pt.library.model.BorrowDTO;
import ir.pt.library.model.LibraryDTO;
import ir.pt.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;


    @PostMapping(value = "/add")
    public ResponseEntity addPerson(@RequestBody LibraryDTO model) throws Exception {
        return ResponseEntity.ok().body(libraryService.create(model));
    }

    @PutMapping(value = "/updateReceive/{id}")
    public ResponseEntity updateReceive(@PathVariable Integer id) throws Exception {
        try {
            return ResponseEntity.ok(libraryService.updateWithReceive(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PutMapping(value = "/updateReturn/{id}")
    public ResponseEntity updateReturn(@PathVariable Integer id) throws Exception {
        try {
            return ResponseEntity.ok(libraryService.updateWithReturn(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

//    @PostMapping(value = "/lendingBooks")
//    public ResponseEntity BarrowBook (@RequestBody BorrowDTO borrowDTO) throws Exception{
//        return  ResponseEntity.ok(libraryService.lendingBooks(borrowDTO));
//    }
//
//    @PostMapping(value = "/Returnbooks")
//    public ResponseEntity Returnbook (@RequestBody BorrowDTO borrowDTO) throws Exception{
//        return  ResponseEntity.ok(libraryService.Returnbook(borrowDTO));
//    }

    @GetMapping(value = "/loanable/{idbook}")
    public ResponseEntity loanable(@PathVariable Integer idbook) {
        return ResponseEntity.ok(libraryService.
                loanable(idbook));
    }

    @GetMapping(value = "/check")
    public ResponseEntity checkIsBorrowAble() throws Exception {
        return ResponseEntity.ok(libraryService.checkIsBorrowAble());
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity getAllLibrary() throws Exception {
        return ResponseEntity.ok().body(libraryService.getAll());
    }

    @GetMapping(value = "/checkExistNum/{id}")
    public ResponseEntity checkExistNum(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(libraryService.checkExistNum(id));
    }

}
