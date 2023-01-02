package ir.pt.library.service;

import ir.pt.library.model.PersonDTO;
import ir.pt.library.model.PersonModel;

import java.util.List;

public interface PersonService {
    Boolean existByCode(String code);

    List<PersonModel> findByNationalCode(String code);

    PersonModel create(PersonDTO person) throws Exception;

    PersonModel update(PersonDTO person);

    boolean delete(Integer id);

    boolean deleteById(Integer id);

    PersonModel get(Integer id);

    List<PersonModel> getAll();

    List<PersonModel> getAllWithPaginationAndSorting(Integer pageNumber, Integer pageSize, String field);
}
