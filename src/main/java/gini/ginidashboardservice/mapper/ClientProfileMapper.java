package gini.ginidashboardservice.mapper;

import gini.ginidashboardservice.dto.ClientProfileDTO;
import gini.ginidashboardservice.models.ClientProfile;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ClientProfileMapper {

    // Map DTO to Entity (for new entities)
    ClientProfile toEntity(ClientProfileDTO dto);

    // Map Entity to DTO (for responses)
    ClientProfileDTO toDto(ClientProfile entity);

    // Update an existing entity with values from DTO
    void updateClientProfileFromDto(ClientProfileDTO dto, @MappingTarget ClientProfile entity);
}