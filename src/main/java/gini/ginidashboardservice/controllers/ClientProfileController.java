package gini.ginidashboardservice.controllers;

import gini.ginidashboardservice.models.ClientProfile;
import gini.ginidashboardservice.service.ClientProfileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientProfileController {

    private final ClientProfileService clientProfileService;

    public ClientProfileController(ClientProfileService clientProfileService) {
        this.clientProfileService = clientProfileService;
    }

    @GetMapping("/client-profiles")
    public List<ClientProfile> getAllClientProfiles() {
        return clientProfileService.getAllClientProfiles();
    }
}