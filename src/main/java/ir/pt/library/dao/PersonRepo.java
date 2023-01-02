package ir.pt.library.dao;

import ir.pt.library.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepo {

    Boolean existByNationalCode(String nationalCode);

    List<Person> findByNationalCode(String nationalCode);

    Person create(Person entity);

    Person update(Person entity );

    Boolean remove(Integer id);

    Boolean remove(Person entity);

    Person get(Integer id);

    List<Person> getAll();

    Page<Person> findAll(Pageable pageable);
}
