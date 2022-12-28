package ir.pt.library.dao;

import ir.pt.library.entity.BorrowEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowRepo {

    BorrowEntity create(BorrowEntity entity);

    List<BorrowEntity> getAllBorrowPerson(Integer id);

    List<BorrowEntity> getAllBorrow();

    BorrowEntity get(Integer id);

    Boolean remove(BorrowEntity entity);

    //    LibraryEntity findAllByBook_LibraryEntities(String bookName);
//    List<BorrowEntity> findByPersonId(Integer id);
}
