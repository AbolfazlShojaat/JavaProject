package ir.pt.library.mapper;

import ir.pt.library.entity.LibraryEntity;
import ir.pt.library.model.LibraryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LibraryConverter {
    //@Mapping(source = "name",target = "firstname")
    LibraryEntity convertToEntity(LibraryDTO model);

    List<LibraryEntity> convertToEntites(List<LibraryDTO> models);

    LibraryDTO convertToModel(LibraryEntity entity);

    List<LibraryDTO> convertToModels(List<LibraryEntity> entities);
}
