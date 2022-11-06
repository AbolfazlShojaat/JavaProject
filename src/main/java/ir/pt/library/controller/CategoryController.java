package ir.pt.library.controller;

import ir.pt.library.model.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "category")
public class CategoryController {

    @PostMapping(value = "/add")
    public ResponseEntity addCategory(@RequestBody Category category) throws Exception {
        category.setId(category.getId() + 1);
        return ResponseEntity.ok().body(category);
    }

    @GetMapping(value = "/select")
    public ResponseEntity category() throws Exception {
        List<Category> listCategory = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Category category = new Category(i + 1, "elahiat");
            listCategory.add(category);
        }
        return ResponseEntity.ok(listCategory);
    }

    @PutMapping(value = "/update")
    public ResponseEntity updateCategory(@RequestBody Category category) throws Exception {
        category.setId(category.getId() + 1);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity deleteCategory(@RequestBody Category category) throws Exception {
        category.setId(category.getId() + 1);
        return ResponseEntity.ok(category);

    }

}
