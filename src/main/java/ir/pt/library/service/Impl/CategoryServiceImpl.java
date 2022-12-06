package ir.pt.library.service.Impl;

import ir.pt.library.dao.CategoryRepo;
import ir.pt.library.mapper.CategoryConverter;
import ir.pt.library.model.CategoryDTO;
import ir.pt.library.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;
    private CategoryConverter converter = new CategoryConverter();

    public Boolean findNameExists(String categoryName) {
        if (categoryRepo.existsByNameEquals(categoryName)) {
            return true;
        }
        return false;
    }

    @Override
    public CategoryDTO create(CategoryDTO model) throws Exception {
        if (!this.findNameExists(model.getName())) {
            return converter.convertToModel(categoryRepo.save(converter.convertToEntity(model)));
        } else
            throw new Exception("This name exists");
    }


    @Override
    public CategoryDTO update(CategoryDTO model) {
        return converter.convertToModel(categoryRepo.save(converter.convertToEntity(model)));
    }

    @Override
    public boolean delete(Integer id) {
        categoryRepo.deleteById(id);
        return true;
    }

    @Override
    public CategoryDTO get(Integer id) {
        return converter.convertToModel(categoryRepo.findById(id).get());
    }

    @Override
    public List<CategoryDTO> getAll() {
        return converter.convertToModel((List) categoryRepo.findAll());
    }
}
