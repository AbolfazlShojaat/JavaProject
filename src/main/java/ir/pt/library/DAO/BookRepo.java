package ir.pt.library.DAO;

import ir.pt.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends JpaRepository<Book, Integer> {
    Boolean existsByNameEquals(String name);
}
