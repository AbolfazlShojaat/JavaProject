package ir.pt.library.dao;

import ir.pt.library.entity.BorrowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowRepo2 extends JpaRepository<BorrowEntity, Integer> {
}
