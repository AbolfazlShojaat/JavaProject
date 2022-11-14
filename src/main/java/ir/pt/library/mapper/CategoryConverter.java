package ir.pt.library.mapper;

import ir.pt.library.entity.Category;
import ir.pt.library.model.CategoryDTO;

import java.util.ArrayList;
import java.util.List;

public class CategoryConverter {
    public Category convertToEntity(CategoryDTO model) {
        return new Category(model.getId(), model.getName());
    }

    public List<Category> convertToEntity(List<CategoryDTO> models) {
        List<Category> categoryEntities = new ArrayList<>();
        for (CategoryDTO model : models) {
            categoryEntities.add(convertToEntity(model));
        }
        return categoryEntities;
    }

    public CategoryDTO convertToModel(Category entity) {
        return new CategoryDTO(entity.getId(), entity.getName());
    }

    public List<CategoryDTO> convertToModel(List<Category> entities) {
        List<CategoryDTO> categoryModels = new ArrayList<>();
        for (Category entity : entities) {
            categoryModels.add(convertToModel(entity));
        }
        return categoryModels;

    }

}
