package gini.ginidashboardservice.controllers;

import gini.ginidashboardservice.dto.InterventionResponse;
import gini.ginidashboardservice.dto.PeopleDTO;
import gini.ginidashboardservice.service.InterventionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class InterventionsController {
    private final InterventionService interventionService;

    public InterventionsController(InterventionService interventionService) {
        this.interventionService = interventionService;
    }


    @GetMapping("/interventions")
    public CompletableFuture<ResponseEntity<Page<InterventionResponse>>> getInterventionTypeCounts(
            @RequestHeader("X-Username") Long loggedInEmployeeId,
            @RequestParam Long employeeId,
            @RequestParam int page,
            @RequestParam int size) {
        if (!employeeId.equals(loggedInEmployeeId)) {
            return CompletableFuture.completedFuture(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
        }

        Page<InterventionResponse> interventions = interventionService.getInterventionTypeCountsByEmployeeId(employeeId, PageRequest.of(page, size));
        return CompletableFuture.completedFuture(ResponseEntity.ok(interventions));
    }
    @GetMapping("/critical-conversation")
    public CompletableFuture<ResponseEntity<Page<PeopleDTO>>> getInteractionDetails(@RequestParam Long employeeId, @RequestParam int page,
                                                                                    @RequestParam int size) {
        Page<PeopleDTO> interactionDetails = interventionService.getInteractionsWithAgentNames(employeeId, PageRequest.of(page, size));
        return CompletableFuture.completedFuture(ResponseEntity.ok(interactionDetails));
    }
}