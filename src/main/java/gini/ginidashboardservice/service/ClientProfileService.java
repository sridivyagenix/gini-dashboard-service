package gini.ginidashboardservice.service;

import gini.ginidashboardservice.models.ClientProfile;
import gini.ginidashboardservice.repositories.ClientProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientProfileService {
    private final ClientProfileRepository clientProfileRepository;

    public ClientProfileService(ClientProfileRepository clientProfileRepository) {
        this.clientProfileRepository = clientProfileRepository;
    }
    public List<ClientProfile> getAllClientProfiles() {
        return clientProfileRepository.findAll();
    }
}
