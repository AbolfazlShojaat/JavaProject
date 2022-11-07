package ir.pt.library.service;

import ir.pt.library.model.Book;

import java.util.List;

public interface BookService {

    Book create(Book book);

    Book update(Book book);

    boolean delete(int id);

    Book get(int id);

    List<Book> getList();
}
