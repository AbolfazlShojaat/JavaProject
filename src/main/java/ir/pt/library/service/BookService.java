package ir.pt.library.service;

import ir.pt.library.model.BookDTO;

import java.util.List;

public interface BookService {

    BookDTO create(BookDTO book);

    BookDTO update(BookDTO book);

    boolean delete(int id);

    BookDTO get();

    List<BookDTO> getList();
}
