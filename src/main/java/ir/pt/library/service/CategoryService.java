package ir.pt.library.service;

import ir.pt.library.entity.Category;
import ir.pt.library.model.CategoryDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {

    Boolean findNameExists(String categoryName) throws Exception;

    CategoryDTO create(CategoryDTO model) throws Exception;

    CategoryDTO update(CategoryDTO model);

    boolean delete(Integer id);

    CategoryDTO get(Integer id);

    List<CategoryDTO> getAll();

//    List<CategoryDTO> getAllSorting(String field);

    List<CategoryDTO> getAllWithPaginationAndSorting(Integer pageNumber, Integer pageSize, String field);
}
