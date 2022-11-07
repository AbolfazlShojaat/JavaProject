package ir.pt.library.service;

import ir.pt.library.model.Book;
import ir.pt.library.model.Person;

import java.util.List;

public interface PersonService {

    Person create(Person person);

    Person update(Person person);

    boolean delete(int id);

    Person get(int id);

    List<Person> getList();
}
