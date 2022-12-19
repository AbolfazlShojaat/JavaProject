package ir.pt.library.service.Impl;

import ir.pt.library.dao.BookRepo;
import ir.pt.library.dao.LibraryRepo;
import ir.pt.library.entity.LibraryEntity;
import ir.pt.library.mapper.LibraryConverter;
import ir.pt.library.model.LibraryDTO;
import ir.pt.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {


    @Autowired
    private LibraryRepo libraryRepo;
    @Autowired
    private LibraryConverter converter;
    @Autowired
    private BookRepo bookRepo;

    @Override
    public boolean loanable(Integer id) {
        LibraryEntity libraryEntity = libraryRepo.get(id);
        if (libraryEntity.getIsBorrowAble() == true & libraryEntity.getExistNum() > 0) {
            return true;
        } else{
            return false;
        }
    }

    @Override
    public List<LibraryDTO> checkIsBorrowAble() {
        return converter.convertToModels(libraryRepo.isBorrowAble());
    }

    @Transactional
    @Override
    public LibraryDTO create(LibraryDTO model) throws Exception {
        LibraryEntity entity = converter.convertToEntity(model);
        entity.setBook(bookRepo.getById(model.getBook().getId()));
        return converter.convertToModel(libraryRepo.create(entity));
    }

//    @Override
//    public LibraryDTO checkIBA(LibraryDTO model) throws Exception {
//        if (this.checkIsBorrowAble == ) {
//            throw new Exception("True BorrowAble");
//        } else
//            throw new Exception("False BorrowAble");
//    }

//    @Override
//    public LibraryDTO create(LibraryDTO model) throws Exception {
//        return converter.convertToModel(repo.save(converter.convertToEntity(model)));
//    }


    @Transactional
    @Override
    public LibraryDTO updateWithReceive(LibraryDTO model) {
        LibraryEntity entity = libraryRepo.updateReceive(converter.convertToEntity(model));
        return converter.convertToModel(entity);
    }

    @Transactional
    @Override
    public LibraryDTO updateWithReturn(LibraryDTO model) {
        LibraryEntity entity = libraryRepo.updateReturn(converter.convertToEntity(model));
        return converter.convertToModel(entity);
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public LibraryDTO get(Integer id) {
        return null;
    }

    @Override
    public List<LibraryDTO> getAll() {
        return converter.convertToModels((List) libraryRepo.getAllLibrary());

    }

    @Override
    public Integer checkExistNum(Integer id) {
        return libraryRepo.checkExistNum(id);
    }
}
