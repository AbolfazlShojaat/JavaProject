package ir.pt.library.controller;

import ir.pt.library.model.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @PostMapping(value = "/add")
    public ResponseEntity addPerson(@RequestBody Person person) throws Exception {
        person.setId(person.getId() + 1);
        return ResponseEntity.ok().body(person);
    }

    @GetMapping(value = "/search")
    public ResponseEntity person() throws Exception{
        Person person = new Person(1, "Abolfazl","Shojaat",21987);
        return ResponseEntity.ok(person);
    }

    @PutMapping(value = "/update")
    public ResponseEntity updatePerson(@RequestBody Person person) throws Exception {
        person.setId(person.getId() + 1);
        return ResponseEntity.ok(person);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity deletePerson(@RequestBody Person person) throws Exception {
        person.setId(person.getId() - 1);
        return ResponseEntity.ok(person);
    }
}
