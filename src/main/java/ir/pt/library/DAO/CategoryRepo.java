package ir.pt.library.DAO;

import ir.pt.library.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
   Boolean existsByName(String name);
   Boolean existsByNameEquals(String name);
   List<Category> findByName(String name);
}
