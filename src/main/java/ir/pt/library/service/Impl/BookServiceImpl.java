package ir.pt.library.service.Impl;

import ir.pt.library.DAO.BookRepo;
import ir.pt.library.entity.Book;
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

    @Override
    public BookDTO create(BookDTO model) {
        Book entityBook= new Book(model.getId(),model.getName(), model.getPrintData(), model.getShabak(), model.getCategory());

        return null;
    }

    @Override
    public BookDTO update(BookDTO model) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public BookDTO get(Integer id) {
        return null;
    }

    @Override
    public List<BookDTO> getAll() {
        return null;
    }
}
