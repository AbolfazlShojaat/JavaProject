package ir.pt.library.dao;

import ir.pt.library.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {

//    Page<Book> findAll(Pageable pageable);

    Boolean existsByNameEquals(String name);
}
