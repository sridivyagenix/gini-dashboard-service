package gini.ginidashboardservice.service;

import gini.ginidashboardservice.dto.ClientProfileDTO;
import gini.ginidashboardservice.models.ClientProfile;
import gini.ginidashboardservice.repositories.ClientProfileRepository;
import lombok.RequiredArgsConstructor;
import gini.ginidashboardservice.mapper.ClientProfileMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientProfileService {
    private final ClientProfileRepository clientProfileRepository;
    private final ClientProfileMapper clientProfileMapper;

    public ClientProfile updateClientProfile(Long clientId, ClientProfileDTO updatedProfileDTO) {
        Optional<ClientProfile> existingProfileOpt = clientProfileRepository.findById(clientId);

        if (existingProfileOpt.isPresent()) {
            ClientProfile existingProfile = existingProfileOpt.get();

            // Use the mapper to update the existing entity with values from the DTO
            clientProfileMapper.updateClientProfileFromDto(updatedProfileDTO, existingProfile);

            return clientProfileRepository.save(existingProfile);
        } else {
            throw new RuntimeException("Client profile with ID " + clientId + " not found.");
        }
    }
    public List<ClientProfile> getAllClientProfiles() {
        return clientProfileRepository.findAll();
    }
}
