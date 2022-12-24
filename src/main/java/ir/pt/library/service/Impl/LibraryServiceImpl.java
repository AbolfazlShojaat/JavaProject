package ir.pt.library.service.Impl;

import ir.pt.library.dao.BookRepo;
import ir.pt.library.dao.LibraryRepo;
import ir.pt.library.entity.LibraryEntity;
import ir.pt.library.mapper.LibraryConverter;
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
public class LibraryServiceImpl implements LibraryService {


    @Autowired
    private LibraryRepo libraryRepo;
    @Autowired
    private LibraryConverter converter;
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private PersonService personService;
    @Autowired
    private PersonConverter personConverter;
    @Autowired
    private BorrowService borrowService;

    // چک میکند که کتاب قابل قرض دادن است و این نوع کتاب را در کتاب خانه داریم یا نه
    @Override
    public boolean loanable(Integer id) {
        LibraryEntity libraryEntity = libraryRepo.get(id);
        if (libraryEntity.getIsBorrowAble() == true & libraryEntity.getExistNum() > 0) {
            return true;
        } else {
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
    public LibraryDTO updateWithReceive(Integer id) throws Exception {
        return converter.convertToModel(libraryRepo.updateReceive(id));
    }

    @Transactional
    @Override
    public LibraryDTO updateWithReturn(Integer id) throws Exception {
        return converter.convertToModel(libraryRepo.updateReturn(id));
    }

    @Transactional
    @Override
    public BorrowDTO lendingBooks(BorrowDTO borrowDTO) throws Exception {
        if (!this.loanable(borrowDTO.getBook().getId()))
            //بررسی قابل قرض دادن بودن کتاب
            throw new Exception("This book cannot be borrowed");
        else {
            //قرض دادن کتاب
            LibraryDTO libraryDTO = updateWithReceive(borrowDTO.getBook().getId());
            PersonModel personModel = personService.get(borrowDTO.getPerson().getId());
            PersonDTO personDTO = personConverter.convertToDto(personModel);
            borrowDTO.setBook(libraryDTO.getBook());
            borrowDTO.setPerson(personDTO);
            borrowDTO.setReceiveDate(new Date());
            borrowDTO.setRejDate(new Date());
            BorrowDTO dto = borrowService.create(borrowDTO);

        }

        return borrowDTO;
    }

    @Transactional
    @Override
    public BorrowDTO Returnbook(BorrowDTO borrowDTO) throws Exception {
        if (!this.loanable(borrowDTO.getBook().getId()))
            //بررسی قابل قرض دادن بودن کتاب
            throw new Exception("This book cannot be borrowed");
        else {
            //قرض دادن کتاب
            LibraryDTO libraryDTO = updateWithReturn(borrowDTO.getBook().getId());
            PersonModel personModel = personService.get(borrowDTO.getPerson().getId());
            PersonDTO personDTO = personConverter.convertToDto(personModel);
            borrowDTO.setBook(libraryDTO.getBook());
            borrowDTO.setPerson(personDTO);
            borrowDTO.setRejDate(new Date());
            BorrowDTO dto = borrowService.create(borrowDTO);
        }

        return borrowDTO;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public LibraryDTO get(Integer id) {
        return null;
    }

    @Transactional
    @Override
    public List<LibraryDTO> getAll() {
        return converter.convertToModels((List) libraryRepo.getAllLibrary());
    }

    @Override
    public Integer checkExistNum(Integer id) {
        return libraryRepo.checkExistNum(id);
    }
}
