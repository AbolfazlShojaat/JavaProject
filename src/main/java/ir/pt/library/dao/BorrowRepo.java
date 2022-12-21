package ir.pt.library.dao;

import ir.pt.library.entity.BorrowEntity;
import ir.pt.library.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowRepo{

    BorrowEntity create(BorrowEntity entity);

    List<BorrowEntity> getAllBorrowPerson(Integer id);

    List<BorrowEntity> getAllBorrow();
    //    LibraryEntity findAllByBook_LibraryEntities(String bookName);
//    List<BorrowEntity> findByPersonId(Integer id);

}
