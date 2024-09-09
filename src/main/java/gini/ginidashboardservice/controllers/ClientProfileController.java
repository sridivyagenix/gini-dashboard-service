package gini.ginidashboardservice.controllers;

import gini.ginidashboardservice.dto.ClientProfileDTO;
import gini.ginidashboardservice.models.ClientProfile;
import gini.ginidashboardservice.service.ClientProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/client-profiles/{clientId}")
    public ResponseEntity<ClientProfile> updateClientProfile(
            @PathVariable Long clientId,
            @RequestBody ClientProfileDTO updatedProfile) {

        ClientProfile updatedClientProfile = clientProfileService.saveClientProfile(clientId, updatedProfile);
        return ResponseEntity.ok(updatedClientProfile);
    }
    @PostMapping("/client-profiles")
    public ResponseEntity<ClientProfile> createClientProfile(
            @RequestBody ClientProfileDTO updatedProfile) {

        ClientProfile updatedClientProfile = clientProfileService.saveClientProfile(null, updatedProfile);
        return ResponseEntity.ok(updatedClientProfile);
    }
}