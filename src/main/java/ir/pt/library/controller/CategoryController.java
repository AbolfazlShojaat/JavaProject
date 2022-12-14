package ir.pt.library.controller;

import ir.pt.library.model.CategoryDTO;
import ir.pt.library.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @PostMapping(value = "/add")
    public ResponseEntity addCategory(@RequestBody @Valid CategoryDTO category) throws Exception {
        try {
            return ResponseEntity.ok().body(service.create(category));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PutMapping(value = "/update")
    public ResponseEntity updateCategory(@RequestBody CategoryDTO category) throws Exception {
        return ResponseEntity.ok(service.update(category));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteCategory(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity searchCategory(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(service.get(id));
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity category() throws Exception {
        return ResponseEntity.ok(service.getAll());
    }

//    @GetMapping(value = "/getAllWithSorting/{field}")
//    public ResponseEntity getAllWithSorting(@PathVariable String field) throws Exception {
//        return ResponseEntity.ok(service.getAllSorting(field));
//    }

    @GetMapping(value = "/getAWPAS/{pageNum}/{pageSize}/{field}")
    public ResponseEntity getAllWithPagination(@PathVariable Integer pageNum, @PathVariable Integer pageSize, @PathVariable String field) throws Exception {
        return ResponseEntity.ok(service.getAllWithPaginationAndSorting(pageNum, pageSize, field));
    }
}
