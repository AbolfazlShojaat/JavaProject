package ir.pt.library.service.Impl;

import ir.pt.library.DAO.PersonRepo;
import ir.pt.library.entity.Category;
import ir.pt.library.entity.Person;
import ir.pt.library.model.CategoryDTO;
import ir.pt.library.model.PersonDTO;
import ir.pt.library.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepo personRepo;

    @Override
    public PersonDTO create(PersonDTO person) {
        Person entityPerson = new Person(person.getFirstName(), person.getLastName(), person.getNationalCode());
        personRepo.save(entityPerson);
        PersonDTO personDTO = new PersonDTO(entityPerson.getId(), entityPerson.getFirstName(), entityPerson.getLastName(), entityPerson.getNationalCode());
        return personDTO;
    }

    @Override
    public PersonDTO update(PersonDTO person) {
        Person entityPerson = new Person(person.getId(), person.getFirstName(), person.getLastName(), person.getNationalCode());
        personRepo.save(entityPerson);
        PersonDTO personDTO = new PersonDTO(entityPerson.getId(), entityPerson.getFirstName(), entityPerson.getLastName(), entityPerson.getNationalCode());
        return personDTO;
    }

    @Override
    public boolean delete(Integer id) {
        personRepo.deleteById(id);
        return true;
    }

    @Override
    public PersonDTO get(Integer id) {
        Person entityPerson= personRepo.findById(id).get();
        return new PersonDTO(entityPerson.getId(), entityPerson.getFirstName(), entityPerson.getLastName(), entityPerson.getNationalCode());
    }

    @Override
    public List<PersonDTO> getAll() {
        List<Person> people = (List) personRepo.findAll();
        List<PersonDTO> personDTOS = new ArrayList<>();
        for (Person entityPerson : people){
            personDTOS.add(new PersonDTO(entityPerson.getId(), entityPerson.getFirstName(), entityPerson.getLastName(), entityPerson.getNationalCode()));
        }
        return personDTOS;
    }
}
