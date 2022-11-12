package ir.pt.library.controller;

import ir.pt.library.model.CategoryDTO;
import ir.pt.library.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @PostMapping(value = "/add")
    public ResponseEntity addCategory(@RequestBody CategoryDTO category) throws Exception {
        return ResponseEntity.ok().body(service.create(category));
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity category() throws Exception {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping(value = "/update")
    public ResponseEntity updateCategory(@RequestBody CategoryDTO category) throws Exception {
        return ResponseEntity.ok(service.update(category));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteCategory(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping(value = "/get")
    public ResponseEntity searchCategory(@RequestParam Integer id) throws Exception {
        return ResponseEntity.ok(service.get(id));
    }


}
