package ir.pt.library.dao;

import ir.pt.library.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Integer> {
   Boolean existsByName(String name);
   Boolean existsByNameEquals(String name);
   List<Category> findByName(String name);
}
