package ir.pt.library.service;

import ir.pt.library.model.BookDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BookService {

    Boolean findNameExists(String bookName) throws Exception;

    BookDTO create(BookDTO model) throws Exception;

    BookDTO update(BookDTO model);

    boolean delete(Integer id);

    BookDTO get(Integer id);

    List<BookDTO> getAll();

    BookDTO uploadCoverAndFile(MultipartFile bookCover, MultipartFile bookFile, BookDTO bookDTO) throws IOException;

//    BookDTO uploadFile(MultipartFile fileBook, BookDTO bookDTO) throws IOException;
}
