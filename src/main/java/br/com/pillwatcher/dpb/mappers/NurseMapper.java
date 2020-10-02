package br.com.pillwatcher.dpb.mappers;

import br.com.pillwatcher.dpb.entities.Nurse;
import io.swagger.model.NurseDTOForCreate;
import io.swagger.model.NurseDTOForResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NurseMapper {

    @Mapping(target = "user.document", source = "document")
    @Mapping(target = "user.imageUrl", source = "imageUrl")
    @Mapping(target = "user.name", source = "name")
    Nurse dtoToEntity(final NurseDTOForCreate nurseDTOForCreate);

    @Mapping(target = "document", source = "user.document")
    @Mapping(target = "imageUrl", source = "user.imageUrl")
    @Mapping(target = "name", source = "user.name")
    NurseDTOForResponse entityToDto(final Nurse nurse);

}
