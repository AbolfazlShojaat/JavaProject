package ir.pt.library.controller;

import ir.pt.library.model.PersonDTO;
import ir.pt.library.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping(value = "/add")
    public ResponseEntity addPerson(@RequestBody PersonDTO person) throws Exception {
        return ResponseEntity.ok().body(personService.create(person));
    }

    @GetMapping(value = "/getByNationalCode/{code}")
    public ResponseEntity person(@PathVariable String code) throws Exception {
        return ResponseEntity.ok(personService.findByNationalCode(code));
    }

    @GetMapping(value = "/get")
    public ResponseEntity person(@RequestParam Integer id) throws Exception {
        return ResponseEntity.ok(personService.get(id));
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity people() throws Exception {
        return ResponseEntity.ok(personService.getAll());
    }

    @PutMapping(value = "/update")
    public ResponseEntity updatePerson(@RequestBody PersonDTO person) throws Exception {
        return ResponseEntity.ok(personService.update(person));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deletePerson(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(personService.delete(id));
    }
}
