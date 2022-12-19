package ir.pt.library.service;

import ir.pt.library.model.LibraryDTO;

import java.util.List;

public interface LibraryService {

    //true & false
    boolean loanable(Integer id);
    //List of trues
    List<LibraryDTO> checkIsBorrowAble() throws Exception;

    LibraryDTO create(LibraryDTO model) throws Exception;

    LibraryDTO updateWithReceive(LibraryDTO model);

    LibraryDTO updateWithReturn(LibraryDTO model);

    boolean delete(Integer id);

    LibraryDTO get(Integer id);

    List<LibraryDTO> getAll();

    Integer checkExistNum(Integer id);
}
