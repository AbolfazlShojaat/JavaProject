package ir.pt.library.service;

import ir.pt.library.model.PersonDTO;

import java.util.List;

public interface PersonService {

    PersonDTO create(PersonDTO person);

    PersonDTO update(PersonDTO person);

    boolean delete(int id);

    PersonDTO get(int id);

    List<PersonDTO> getList();
}
