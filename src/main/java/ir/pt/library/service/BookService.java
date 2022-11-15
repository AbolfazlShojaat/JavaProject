package ir.pt.library.service;

import ir.pt.library.model.BookDTO;

import java.util.List;

public interface BookService {

    Boolean findNameExists(String bookName) throws Exception;

    BookDTO create(BookDTO model) throws Exception;

    BookDTO update(BookDTO model);

    boolean delete(Integer id);

    BookDTO get(Integer id);

    List<BookDTO> getAll();
}
