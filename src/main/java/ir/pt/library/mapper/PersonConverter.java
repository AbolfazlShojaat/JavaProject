package ir.pt.library.mapper;

import ir.pt.library.entity.Person;
import ir.pt.library.model.PersonDTO;
import ir.pt.library.model.PersonModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
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

    public PersonDTO convertToDto(PersonModel personModel) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(personModel.getId());
        personDTO.setFirstName(personModel.getFullName());
        personDTO.setLastName(personModel.getFullName());
        personDTO.setNationalCode(personModel.getNationalCode());
        personDTO.setIdNO(personDTO.getIdNO());
        return personDTO;
    }


//    public PersonDTO convertToModel(PersonModel){
//        PersonDTO dto = new PersonDTO();
//        dto.setId(model.getId());
//        dto.setFirst(model.getFullName());
//        dto.setLast(model.getFullName());
//        dto.setNtcode(model.getNtcode());
//        dto.setPhone(model.getPhone());
//        dto.setIdnumber(dto.getIdnumber());
//        return dto;
//
//    }
}
