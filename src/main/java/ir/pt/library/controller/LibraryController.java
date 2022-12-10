package ir.pt.library.controller;

import ir.pt.library.model.LibraryDTO;
import ir.pt.library.model.PersonDTO;
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

    @PutMapping(value = "/updateReceive")
    public ResponseEntity updateReceive(@RequestBody LibraryDTO model) throws Exception {
        return ResponseEntity.ok(libraryService.updateWithReceive(model));
    }

    @PutMapping(value = "/updateReturn")
    public ResponseEntity updateReturn(@RequestBody LibraryDTO model) throws Exception {
        return ResponseEntity.ok(libraryService.updateWithReturn(model));
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
