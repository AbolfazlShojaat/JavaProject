package ir.pt.library.DAO;

import ir.pt.library.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepo extends CrudRepository<Person, Integer> {
}
