package ir.pt.library.mapper;

import ir.pt.library.entity.BorrowEntity;
import ir.pt.library.model.BorrowDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BorrowConverter {
    BorrowEntity convertToEntity(BorrowDTO model);

    List<BorrowEntity> convertToEntites(List<BorrowDTO> models);

    BorrowDTO convertToModel(BorrowEntity entity);

    List<BorrowDTO> convertToModels(List<BorrowEntity> entities);
}
