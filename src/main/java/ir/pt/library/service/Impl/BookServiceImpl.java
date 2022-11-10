package ir.pt.library.service.Impl;

import ir.pt.library.model.BookDTO;
import ir.pt.library.model.CategoryDTO;
import ir.pt.library.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

//    @Autowired
//    private BookRepo bookRepo;
//
//    @Override
//    public Book save(Book model) {
//        ir.pt.library.entity.Book book
//        return null;
//    }

    @Override
    public BookDTO create(BookDTO book) {
        book.setId(book.getId() + 10);
        return book;
    }



    @Override
    public BookDTO update(BookDTO book) {
        book.setId(book.getId() + 1);
        return book;
    }

    @Override
    public boolean delete(int id) {
        BookDTO book= new BookDTO(2, "adabit", 784, new Date(02 / 02 / 1400));
//        book.setId(id + 3);
        return false;

    }

    @Override
    public BookDTO get() {
        BookDTO book = new BookDTO(2, "adabit", 784, new Date(02 / 02 / 1400));
        book.setCategory(new CategoryDTO(1, "Arabi"));
        return book;
    }

    @Override
    public List<BookDTO> getList() {

        List<BookDTO> listBook = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            BookDTO book = new BookDTO(i + 1, "arabi", 192, new Date(01 / 01 / 1400));
            listBook.add(book);
        }
        return listBook;
    }
}
