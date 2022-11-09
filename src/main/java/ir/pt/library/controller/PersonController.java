package ir.pt.library.controller;

import ir.pt.library.model.PersonDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @PostMapping(value = "/add")
    public ResponseEntity addPerson(@RequestBody PersonDTO person) throws Exception {
        person.setId(person.getId() + 1);
        return ResponseEntity.ok().body(person);
    }

    @GetMapping(value = "/search")
    public ResponseEntity person() throws Exception{
        PersonDTO person = new PersonDTO(1, "Abolfazl","Shojaat",21987);
        return ResponseEntity.ok(person);
    }

    @PutMapping(value = "/update")
    public ResponseEntity updatePerson(@RequestBody PersonDTO person) throws Exception {
        person.setId(person.getId() + 1);
        return ResponseEntity.ok(person);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity deletePerson(@RequestBody PersonDTO person) throws Exception {
        person.setId(person.getId() - 1);
        return ResponseEntity.ok(person);
    }
}
