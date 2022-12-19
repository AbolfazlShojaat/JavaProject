package ir.pt.library.dao;

import ir.pt.library.entity.LibraryEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepo {

    LibraryEntity create(LibraryEntity entity);

    LibraryEntity get(Integer id);

    List<LibraryEntity> isBorrowAble();

    List<LibraryEntity> getAllLibrary();

    Integer checkExistNum(Integer id);

    LibraryEntity updateReceive(LibraryEntity entity);

    LibraryEntity updateReturn(LibraryEntity entity);
}
