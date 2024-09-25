package gini.ginidashboardservice.mapper;

import gini.ginidashboardservice.dto.ClientProfileDTO;
import gini.ginidashboardservice.models.ClientProfile;
import gini.ginidashboardservice.utils.JsonConverter;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.Map;

@Mapper
public interface ClientProfileMapper {
    ClientProfile toEntity(ClientProfileDTO dto);

    ClientProfileDTO toDto(ClientProfile entity);

    void updateClientProfileFromDto(ClientProfileDTO dto, @MappingTarget ClientProfile entity);

    default String mapJsonField(Map<String, Object> value) {
        return value != null ? new JsonConverter().convertToJson(value) : null;
    }

    default Map<String, Object> mapToJsonField(String value) {
        return value != null ? new JsonConverter().convertFromJson(value) : null;
    }
}
