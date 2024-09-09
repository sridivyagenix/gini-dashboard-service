package gini.ginidashboardservice.mapper;

import gini.ginidashboardservice.dto.ClientProfileDTO;
import gini.ginidashboardservice.models.ClientProfile;
import gini.ginidashboardservice.utils.JsonConverter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.Map;

@Mapper(componentModel = "spring")
public interface ClientProfileMapper {

   // @Mapping(source = "profileUpdatedDt", target = "profileUpdatedDt")
    //@Mapping(source = "lastModifiedAt", target = "lastModifiedAt")
    ClientProfile toEntity(ClientProfileDTO dto);

    ClientProfileDTO toDto(ClientProfile entity);

    //@Mapping(source = "profileUpdatedDt", target = "profileUpdatedDt")
    //@Mapping(source = "lastModifiedAt", target = "lastModifiedAt")
    void updateClientProfileFromDto(ClientProfileDTO dto, @MappingTarget ClientProfile entity);

    // Custom mapping for JSON fields
    default String mapJsonField(Map<String, Object> value) {
        return value != null ? JsonConverter.convertToJson(value) : null;
    }

    default Map<String, Object> mapToJsonField(String value) {
        return value != null ? JsonConverter.convertFromJson(value) : null;
    }
}
