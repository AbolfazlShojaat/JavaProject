package ir.pt.library.dao;

import ir.pt.library.entity.FileBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepo extends JpaRepository<FileBook, String> {
}
