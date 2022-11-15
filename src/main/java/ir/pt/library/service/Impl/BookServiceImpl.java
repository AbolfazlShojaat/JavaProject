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

    public Boolean findNameExists(String bookName) {
        if (bookRepo.existsByNameEquals(bookName)) {
            return true;
        }
        return false;
    }

    @Override
    public BookDTO create(BookDTO model) throws Exception {
        if (!this.findNameExists(model.getName())) {
            return converter.convertToModel(bookRepo.save(converter.convertToEntity(model)));
        } else
            throw new Exception("This name exists");
    }

    @Override
    public BookDTO update(BookDTO model) {
        return converter.convertToModel(bookRepo.save(converter.convertToEntity(model)));
    }

    @Override
    public boolean delete(Integer id) {
        bookRepo.deleteById(id);
        return true;
    }

    @Override
    public BookDTO get(Integer id) {
        return converter.convertToModel(bookRepo.findById(id).get());
    }

    @Override
    public List<BookDTO> getAll() {
        return converter.convertToModel((List) bookRepo.findAll());
    }
}
