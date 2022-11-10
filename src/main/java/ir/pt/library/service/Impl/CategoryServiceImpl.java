package ir.pt.library.service.Impl;

import ir.pt.library.DAO.CategoryRepo;
import ir.pt.library.entity.Category;
import ir.pt.library.model.CategoryDTO;
import ir.pt.library.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public CategoryDTO create(CategoryDTO model) {
        ir.pt.library.entity.Category entityCategory = new ir.pt.library.entity.Category(model.getName());
        categoryRepo.save(entityCategory);
        CategoryDTO categoryModel = new CategoryDTO(entityCategory.getId(), entityCategory.getName());
        return categoryModel;
    }

    @Override
    public CategoryDTO update(CategoryDTO model) {
        Category entitycategory = new Category(model.getId(), model.getName());
        categoryRepo.save(entitycategory);
        CategoryDTO categoryDTO = new CategoryDTO(entitycategory.getId(), entitycategory.getName());
        return categoryDTO;
    }

    @Override
    public boolean delete(Integer id) {
        categoryRepo.deleteById(id);
        return true;
    }

    @Override
    public CategoryDTO get(Integer id) {
        Category entityCategory = categoryRepo.findById(id).get();
        return new CategoryDTO(entityCategory.getId(), entityCategory.getName());
    }

    @Override
    public List<CategoryDTO> getAll() {
        List<Category> categories = (List) categoryRepo.findAll();
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        for (Category entityCategory : categories) {
            categoryDTOS.add(new CategoryDTO(entityCategory.getId(), entityCategory.getName()));
        }
        return categoryDTOS;
    }
}
