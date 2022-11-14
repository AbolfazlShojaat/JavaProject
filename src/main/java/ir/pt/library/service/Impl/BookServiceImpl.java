package ir.pt.library.service.Impl;

import ir.pt.library.DAO.BookRepo;
import ir.pt.library.entity.Book;
import ir.pt.library.entity.Category;
import ir.pt.library.mapper.BookConverter;
import ir.pt.library.model.BookDTO;
import ir.pt.library.model.CategoryDTO;
import ir.pt.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepo bookRepo;
    private BookConverter converter = new BookConverter();

    @Override
    public BookDTO create(BookDTO model) {
        Category category = new Category(model.getCategory().getId(), model.getCategory().getName());
        Book entityBook = new Book(model.getName(), model.getShabak(), model.getPrintData(), category);
        bookRepo.save(entityBook);
        BookDTO bookDTO = new BookDTO(entityBook.getId(), entityBook.getName(), entityBook.getShabak(),
                entityBook.getPrintData(), new CategoryDTO(category.getId(), category.getName()));
        return bookDTO;
    }

    @Override
    public BookDTO update(BookDTO model) {
        Category category = new Category(model.getCategory().getId(), model.getCategory().getName());
        Book entityBook = new Book(model.getId(), model.getName(), model.getShabak(), model.getPrintData(), category);
        bookRepo.save(entityBook);
        BookDTO bookDTO = new BookDTO(entityBook.getId(), entityBook.getName(), entityBook.getShabak(),
                entityBook.getPrintData(), new CategoryDTO(category.getId(), category.getName()));
        return bookDTO;
    }

    @Override
    public boolean delete(Integer id) {
        bookRepo.deleteById(id);
        return true;
    }

    @Override
    public BookDTO get(Integer id) {
        Book entityBook = bookRepo.findById(id).get();
        CategoryDTO category = new CategoryDTO(entityBook.getCategory().getId(), entityBook.getCategory().getName());
        BookDTO bookDTO = new BookDTO(entityBook.getId(), entityBook.getName(), entityBook.getShabak(),
                entityBook.getPrintData(), category);
        return bookDTO;
    }

    @Override
    public List<BookDTO> getAll() {
        List<Book> books = (List) bookRepo.findAll();
        List<BookDTO> bookDTOS = new ArrayList<>();
        for (Book entityBook : books) {
            CategoryDTO category = new CategoryDTO(entityBook.getCategory().getId(), entityBook.getCategory().getName());
            BookDTO bookDTO = new BookDTO(entityBook.getId(), entityBook.getName(), entityBook.getShabak(),
                    entityBook.getPrintData(), category);
            bookDTOS.add(bookDTO);
        }
        return bookDTOS;
    }
}
