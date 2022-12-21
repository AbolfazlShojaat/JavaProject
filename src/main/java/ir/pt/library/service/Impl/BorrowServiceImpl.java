package ir.pt.library.service.Impl;

import ir.pt.library.dao.BookRepo;
import ir.pt.library.dao.BorrowRepo;
import ir.pt.library.dao.LibraryRepo;
import ir.pt.library.dao.PersonRepo;
import ir.pt.library.entity.BorrowEntity;
import ir.pt.library.entity.Person;
import ir.pt.library.mapper.BorrowConverter;
import ir.pt.library.model.BorrowDTO;
import ir.pt.library.model.LibraryDTO;
import ir.pt.library.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    private BorrowRepo borrowRepo;
    @Autowired
    private BorrowConverter converter;
    @Autowired
    private PersonRepo personRepo;
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private LibraryRepo libraryRepo;

    @Override
    public Boolean findNameExists(String categoryName) throws Exception {
//        LibraryDTO libraryDTO = new LibraryDTO();
//        if (!this.libraryRepo.isBorrowAble() == true)
        return true;
    }

    @Transactional
    @Override
    public Boolean lendingBooks(BorrowDTO model) throws Exception {
        return null;
    }

    @Transactional
    @Override
    public BorrowDTO create(BorrowDTO model) throws Exception {
        BorrowEntity entity= converter.convertToEntity(model);
        entity.setPerson(personRepo.get(model.getPerson().getId()));
        entity.setBook(bookRepo.getById(model.getBook().getId()));
        return converter.convertToModel(borrowRepo.create(entity));
    }

    @Override
    public BorrowDTO update(BorrowDTO model) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public BorrowDTO personGetBorrow(Integer id) {
        return null;
    }

    @Override
    public List<BorrowDTO> getAllBorrowPerson(Integer id) {
        List<BorrowEntity> entities = borrowRepo.getAllBorrowPerson(id);
        return converter.convertToModels(entities);

    }

    @Override
    public List<BorrowDTO> getAllBorrow() {
        return converter.convertToModels((List) borrowRepo.getAllBorrow());

    }
}
