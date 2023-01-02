package ir.pt.library.dao;

import ir.pt.library.entity.FileBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileBookRepo extends JpaRepository<FileBook, String> {
}
