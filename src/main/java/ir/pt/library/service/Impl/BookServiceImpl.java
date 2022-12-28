package ir.pt.library.service.Impl;

import ir.pt.library.dao.BookRepo;
import ir.pt.library.entity.Book;
import ir.pt.library.mapper.BookConverter;
import ir.pt.library.mapper.CategoryConverter;
import ir.pt.library.model.BookDTO;
import ir.pt.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public BookDTO uploadCoverAndFile(MultipartFile bookCover, MultipartFile bookFile, BookDTO bookDTO) throws IOException {
        bookDTO.setCover(bookCover.getBytes());
        bookDTO.setFile(bookFile.getBytes());
        return converter.convertToModel(bookRepo.save(
                Book.builder()
                        .id(bookDTO.getId())
                        .name(bookDTO.getName())
                        .shabak(bookDTO.getShabak())
                        .printData(bookDTO.getPrintData())
                        .cover(bookDTO.getCover())
                        .file(bookDTO.getFile())
                        .category(categoryConverter.convertToEntity(bookDTO.getCategory()))
                        .build()));
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
