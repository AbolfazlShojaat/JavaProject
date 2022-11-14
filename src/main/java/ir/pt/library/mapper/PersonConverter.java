package ir.pt.library.mapper;

import ir.pt.library.entity.Person;
import ir.pt.library.model.PersonDTO;
import ir.pt.library.model.PersonModel;

import java.util.ArrayList;
import java.util.List;

public class PersonConverter {
    public Person convertToEntity(PersonDTO personDTO) {
        Person entity = new Person();
        entity.setId(personDTO.getId());
        entity.setFirstName(personDTO.getFirstName());
        entity.setLastName(personDTO.getLastName());
        entity.setIdNumber(String.valueOf(personDTO.getIdNO()));
        entity.setNationalCode(personDTO.getNationalCode());
        return entity;
    }

    public List<Person> convertToEntity(List<PersonDTO> personDTOList) {
        List<Person> personList = new ArrayList<>();
        for (PersonDTO personDTO : personDTOList) {
            personList.add(convertToEntity(personDTO));
        }
        return personList;
    }

    public PersonModel convertToModel(Person entity) {
        PersonModel model = new PersonModel();
        model.setId(entity.getId());
        model.setFullName(entity.getFirstName() + " " + entity.getLastName());
        model.setNationalCode(entity.getNationalCode());
        return model;
    }

    public List<PersonModel> convertToModel(List<Person> personList) {
        List<PersonModel> personModelList = new ArrayList<>();
        for (Person entity : personList) {
            personModelList.add(convertToModel(entity));
        }
        return personModelList;
    }
}
