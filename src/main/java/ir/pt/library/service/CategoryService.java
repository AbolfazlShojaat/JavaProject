package ir.pt.library.service;

import ir.pt.library.model.CategoryDTO;

import java.util.List;

public interface CategoryService {

    CategoryDTO create(CategoryDTO model);

    CategoryDTO update(CategoryDTO model);

    boolean delete(Integer id);

    CategoryDTO get(Integer id);

    List<CategoryDTO> getAll();
}
