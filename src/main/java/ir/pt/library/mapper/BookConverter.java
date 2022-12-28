package ir.pt.library.mapper;

import ir.pt.library.entity.Book;
import ir.pt.library.entity.Category;
import ir.pt.library.model.BookDTO;
import ir.pt.library.model.CategoryDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookConverter {
    public Book convertToEntity(BookDTO model) {
        Category category = new Category(model.getCategory().getId(), model.getCategory().getName());
        return new Book(model.getId(),model.getName(), model.getShabak(), model.getPrintData(), category, model.getCover() , model.getFile());
    }

    public List<Book> convertToEntity(List<BookDTO> models) {
        List<Book> bookEntities = new ArrayList<>();
        for (BookDTO entityBook : models) {
            bookEntities.add(convertToEntity(entityBook));
        }
        return bookEntities;
    }

    public BookDTO convertToModel(Book entity) {
        Category category = new Category(entity.getCategory().getId(), entity.getCategory().getName());
        return new BookDTO(entity.getId(), entity.getName(), entity.getShabak(),
                entity.getPrintData(), new CategoryDTO(category.getId(), category.getName()) , entity.getCover() , entity.getFile());
    }

    public List<BookDTO> convertToModel(List<Book> entities) {
        List<BookDTO> bookDTOS = new ArrayList<>();
        for (Book entity : entities) {
            bookDTOS.add(convertToModel(entity));
        }
        return bookDTOS;
    }
}
