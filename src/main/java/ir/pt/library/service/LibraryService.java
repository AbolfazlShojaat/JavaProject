package ir.pt.library.service;

import ir.pt.library.model.BorrowDTO;
import ir.pt.library.model.LibraryDTO;

import java.util.List;

public interface LibraryService {

    //true & false
    boolean loanable(Integer id);

    //List of trues
    List<LibraryDTO> checkIsBorrowAble() throws Exception;

    LibraryDTO create(LibraryDTO model) throws Exception;

    BorrowDTO lendingBooks(BorrowDTO borrowDTO) throws Exception;

    BorrowDTO Returnbook(BorrowDTO borrowDTO) throws Exception;

    LibraryDTO updateWithReceive(Integer id) throws Exception;

    LibraryDTO updateWithReturn(Integer id) throws Exception;

    boolean delete(Integer id);

    LibraryDTO get(Integer id);

    List<LibraryDTO> getAll();

    Integer checkExistNum(Integer id);
}
