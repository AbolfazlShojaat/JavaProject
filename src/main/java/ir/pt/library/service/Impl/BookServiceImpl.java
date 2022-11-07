package ir.pt.library.service.Impl;

import ir.pt.library.model.Book;
import ir.pt.library.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Override
    public Book create(Book book) {
        book.setId(book.getId() + 10);
        return book;
    }

    @Override
    public Book update(Book book) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Book get(int id) {
        return null;
    }

    @Override
    public List<Book> getList() {

        List<Book> listBook = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Book book = new Book(i + 1, "arabi", 192, new Date(01 / 01 / 1400));
            listBook.add(book);
        }
        return listBook;
    }
}
