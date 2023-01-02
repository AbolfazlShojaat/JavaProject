package ir.pt.library.dao;

import ir.pt.library.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo2 extends JpaRepository<Person, Integer> {
}
