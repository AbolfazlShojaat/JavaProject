package ir.pt.library.service;

import ir.pt.library.model.BorrowDTO;

import java.util.List;

public interface BorrowService {

    BorrowDTO create(BorrowDTO model) throws Exception;

    BorrowDTO lendingBooks(BorrowDTO borrowDTO) throws Exception;

    boolean Returnbook(Integer id) throws Exception;

    boolean delete(Integer id);

    List<BorrowDTO> getAllBorrowPerson(Integer id);

    List<BorrowDTO> getAllBorrow();
}
