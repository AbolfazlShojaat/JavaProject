package ir.pt.library.service;

import ir.pt.library.model.Category;

import java.util.List;

public interface CategoryService {

    Category create(Category category);

    Category update(Category category);

    boolean delete(int id);

    Category get(int id);

    List<Category> getList();
}
