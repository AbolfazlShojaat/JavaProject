package ir.pt.library.dao;

import ir.pt.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {
    Boolean existsByNameEquals(String name);
}
