package ir.pt.library.service.Impl;

import ir.pt.library.dao.CategoryRepo;
import ir.pt.library.entity.Category;
import ir.pt.library.mapper.CategoryConverter;
import ir.pt.library.model.CategoryDTO;
import ir.pt.library.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private CategoryConverter converter;

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

//    @Override
//    public List<CategoryDTO> getAllSorting(String field) {
//        return converter.convertToModel((List) categoryRepo.findAll(Sort.by(Sort.Direction.ASC, field)));
//    }

    @Override
    public List<CategoryDTO> getAllWithPaginationAndSorting(Integer pageNumber, Integer pageSize, String field) {
        Page<Category> page = categoryRepo.findAll(PageRequest.of(pageNumber, pageSize).withSort(Sort.by(field)));
        return converter.convertToModel(page.toList());
    }
}
