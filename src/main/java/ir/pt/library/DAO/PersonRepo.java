package ir.pt.library.DAO;

import ir.pt.library.entity.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepo {

    Boolean existByNationalCode(String nationalCode);

    List<Person> findByNationalCode(String nationalCode);

    Person create(Person entity);

    Person update(Person entity );

    Boolean remove(Integer id);

    Boolean remove(Person entity);

    Person get(Integer id);

    List<Person> getAll();
}
