package gini.ginidashboardservice.service;

import gini.ginidashboardservice.dto.ClientProfileDTO;
import gini.ginidashboardservice.mapper.ClientProfileMapper;
import gini.ginidashboardservice.models.ClientProfile;
import gini.ginidashboardservice.repositories.ClientProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientProfileService {
    private final ClientProfileRepository clientProfileRepository;
    private final ClientProfileMapper clientProfileMapper;

    public ClientProfile saveClientProfile(Long clientId, ClientProfileDTO updatedProfileDTO) {
        if(clientId == null)
        {
            ClientProfile clientProfile = clientProfileMapper.toEntity(updatedProfileDTO);
            clientProfile.setCreatedAt(LocalDateTime.now());
            clientProfile.setLastModifiedAt(LocalDateTime.now());
            clientProfile.setProfileCreatedDt(LocalDateTime.now());
            clientProfile.setProfileUpdatedDt(LocalDateTime.now());
            return clientProfileRepository.save(clientProfile);
        }
        else
        {
            Optional<ClientProfile> existingProfileOpt = clientProfileRepository.findById(clientId);
            if (existingProfileOpt.isPresent()) {
                ClientProfile existingProfile = existingProfileOpt.get();
                clientProfileMapper.updateClientProfileFromDto(updatedProfileDTO, existingProfile);
                existingProfile.setLastModifiedAt(LocalDateTime.now());
                existingProfile.setProfileUpdatedDt(LocalDateTime.now());
                return clientProfileRepository.save(existingProfile);
            } else {
                throw new RuntimeException("Client profile with ID " + clientId + " not found.");            }
        }
    }
    public List<ClientProfile> getAllClientProfiles() {
        return clientProfileRepository.findAll();
    }
}
