package ir.pt.library.controller;

import ir.pt.library.model.PersonDTO;
import ir.pt.library.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(value = "/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping(value = "/add")
    public ResponseEntity addPerson(@RequestBody @Valid PersonDTO person) throws Exception {
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

    @GetMapping(value = "/getByName")
    public ResponseEntity getByName(@RequestParam String pName) throws Exception {
        return ResponseEntity.ok(personService.getByName(pName));
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity people() throws Exception {
        return ResponseEntity.ok(personService.getAll());
    }

    @GetMapping(value = "/getAWPAS/{pageNum}/{pageSize}/{field}")
    public ResponseEntity getAllWithPagination(@PathVariable Integer pageNum, @PathVariable Integer pageSize, @PathVariable String field) throws Exception {
        return ResponseEntity.ok(personService.getAllWithPaginationAndSorting(pageNum, pageSize, field));
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
