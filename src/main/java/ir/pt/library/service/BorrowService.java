package ir.pt.library.service;

import ir.pt.library.entity.LibraryEntity;
import ir.pt.library.entity.Person;
import ir.pt.library.model.BorrowDTO;

import java.util.List;

public interface BorrowService {

    Boolean findNameExists(String categoryName) throws Exception;

    BorrowDTO create(BorrowDTO model) throws Exception;

    BorrowDTO update(BorrowDTO model);

    boolean delete(Integer id);

    BorrowDTO personGetBorrow(Integer id);

    List<BorrowDTO> getAllBorrowPerson(Person person);

    List<BorrowDTO> getAllBorrow();
}