package ir.pt.library.service.Impl;

import ir.pt.library.dao.BookRepo;
import ir.pt.library.entity.Book;
import ir.pt.library.entity.FileBook;
import ir.pt.library.mapper.BookConverter;
import ir.pt.library.mapper.CategoryConverter;
import ir.pt.library.model.BookDTO;
import ir.pt.library.model.ResponseFile;
import ir.pt.library.service.BookService;
import ir.pt.library.service.CategoryService;
import ir.pt.library.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private FileStorageService fileStorageService;
    @Autowired
    private BookConverter converter;
    @Autowired
    private CategoryConverter categoryConverter;

    public Boolean findNameExists(String bookName) {
        if (bookRepo.existsByNameEquals(bookName)) {
            return true;
        }
        return false;
    }

    @Transactional
    @Override
    public BookDTO create(BookDTO model, String id) throws Exception {
        if (!this.findNameExists(model.getName())) {
            FileBook fileBook = fileStorageService.getFile(id);
            ResponseFile responseFile = new ResponseFile(fileBook.getId(), fileBook.getName(), fileBook.getType());
            model.setFileBook(responseFile);
            Book book = bookRepo.save(converter.convertToEntity(model));
//            book.setFileBook(fileBook);
            return converter.convertToModel(book);
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

    @Override
    public List<BookDTO> getAllWithPaginationAndSorting(Integer pageNumber, Integer pageSize, String field) {
        Page<Book> page = bookRepo.findAll(PageRequest.of(pageNumber, pageSize).withSort(Sort.by(field)));
        return converter.convertToModel(page.toList());
    }

    @Override
    public BookDTO uploadCover(MultipartFile bookCover, Integer id) throws IOException {
        BookDTO bookDTO= get(id);
        bookDTO.setCover(bookCover.getBytes());
        Book book = converter.convertToEntity(bookDTO);
        return converter.convertToModel(bookRepo.save(book));
    }
//    @Override
//    public BookDTO uploadFile(MultipartFile fileBook, BookDTO bookDTO) throws IOException {
//        bookDTO.setFile(fileBook.getBytes());
//        return converter.convertToModel(bookRepo.save(
//                Book.builder()
//                        .id(bookDTO.getId())
//                        .name(bookDTO.getName())
//                        .shabak(bookDTO.getShabak())
//                        .printData(bookDTO.getPrintData())
//                        .cover(bookDTO.getCover())
//                        .file(bookDTO.getFile())
//                        .category(categoryConverter.convertToEntity(bookDTO.getCategory()))
//                        .build()));
//    }
}
