package ir.pt.library.service.Impl;

import ir.pt.library.DAO.PersonRepo;
import ir.pt.library.entity.Person;
import ir.pt.library.mapper.PersonConverter;
import ir.pt.library.model.PersonDTO;
import ir.pt.library.model.PersonModel;
import ir.pt.library.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepo personRepo;
    private PersonConverter converter = new PersonConverter();

    @Override
    public List<PersonModel> findByNationalCode(String code) {
        return converter.convertToModel(personRepo.findByNationalCode(code));
    }

    @Override
    public Boolean existByCode(String code) {
        return personRepo.existByNationalCode(code);
    }

    @Transactional
    @Override
    public PersonModel create(PersonDTO person) throws Exception {
        Person entity = personRepo.create(converter.convertToEntity(person));
        return converter.convertToModel(entity);
    }

    @Transactional
    @Override
    public PersonModel update(PersonDTO person) {
        Person entity= personRepo.update(converter.convertToEntity(person));
        return converter.convertToModel(entity);
    }

    @Transactional
    @Override
    public boolean deleteById(Integer id) {

        return personRepo.remove(id);
    }

    @Transactional
    @Override
    public boolean delete(Integer id) {

        return personRepo.remove(personRepo.get(id));
    }

    @Override
    public PersonModel get(Integer id) {
        Person entity= personRepo.get(id);
        return converter.convertToModel(entity);
    }

    @Override
    public List<PersonModel> getAll() {
        return converter.convertToModel(personRepo.getAll());
    }
}
