package ir.pt.library.service;

import ir.pt.library.model.BookDTO;
import ir.pt.library.model.ResponseFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BookService {

    Boolean findNameExists(String bookName) throws Exception;

    BookDTO create(BookDTO model, String id) throws Exception;

    BookDTO update(BookDTO model);

    boolean delete(Integer id);

    BookDTO get(Integer id);

    List<BookDTO> getAll();

    BookDTO uploadCover(MultipartFile bookCover, Integer id) throws IOException;

    List<BookDTO> getAllWithPaginationAndSorting(Integer pageNumber, Integer pageSize, String field);

//    BookDTO uploadFile(MultipartFile fileBook, BookDTO bookDTO) throws IOException;
}
