package ir.pt.library.service.Impl;

import ir.pt.library.dao.BookRepo;
import ir.pt.library.dao.BorrowRepo;
import ir.pt.library.dao.PersonRepo;
import ir.pt.library.entity.BorrowEntity;
import ir.pt.library.mapper.BorrowConverter;
import ir.pt.library.mapper.PersonConverter;
import ir.pt.library.model.BorrowDTO;
import ir.pt.library.model.LibraryDTO;
import ir.pt.library.model.PersonDTO;
import ir.pt.library.model.PersonModel;
import ir.pt.library.service.BorrowService;
import ir.pt.library.service.LibraryService;
import ir.pt.library.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
    private PersonService personService;
    @Autowired
    private PersonConverter personConverter;
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private LibraryService libraryService;

    @Transactional
    @Override
    public BorrowDTO create(BorrowDTO model) throws Exception {
        BorrowEntity entity = converter.convertToEntity(model);
        entity.setPerson(personRepo.get(model.getPerson().getId()));
        entity.setBook(bookRepo.getById(model.getBook().getId()));
        return converter.convertToModel(borrowRepo.create(entity));
    }

    @Transactional
    @Override
    public BorrowDTO lendingBooks(BorrowDTO borrowDTO) throws Exception {
        if (!this.libraryService.loanable(borrowDTO.getBook().getId()))
            //بررسی قابل قرض دادن بودن کتاب
            throw new Exception("This book cannot be borrowed");

        else {
            //قرض دادن کتاب
            LibraryDTO libraryDTO = libraryService.updateWithReceive(borrowDTO.getBook().getId());
            PersonModel personModel = personService.get(borrowDTO.getPerson().getId());
            PersonDTO personDTO = personConverter.convertToDto(personModel);
            borrowDTO.setBook(libraryDTO.getBook());
            borrowDTO.setPerson(personDTO);
            borrowDTO.setReceiveDate(new Date());
            borrowDTO.setRejDate(new Date());
            BorrowDTO dto = create(borrowDTO);
        }
        return borrowDTO;
    }

    @Transactional
    @Override
    public boolean Returnbook(Integer id) throws Exception {
        //قرض دادن کتاب
        BorrowEntity entity = borrowRepo.get(id);
        BorrowDTO borrow = converter.convertToModel(entity);
        libraryService.updateWithReturn(borrow.getBook().getId());
        return borrowRepo.remove(borrowRepo.get(id));
    }

    @Override
    public boolean delete(Integer id) {
        return borrowRepo.remove(borrowRepo.get(id));
    }

    @Transactional
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
