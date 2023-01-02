package ir.pt.library.dao;

import ir.pt.library.entity.LibraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepo2 extends JpaRepository<LibraryEntity, Integer> {
}
