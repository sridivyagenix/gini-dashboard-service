package gini.ginidashboardservice.controllers;

import gini.ginidashboardservice.dto.*;
import gini.ginidashboardservice.models.Employee;
import gini.ginidashboardservice.models.PolicyRetentionRisk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@RestController
public class DashboardController {

    @Autowired
    EmployeeController employeeController;
    @Autowired
    ActivityController activityController;
    @Autowired
    InterventionsController interventionsController;
    @Autowired
    PipelineController pipelineController;
    @Autowired
    PolicyRetentionRiskController policyRetentionRiskController;
    @Autowired
    SalesAgentController salesAgentController;
    @Autowired
    SalesController salesController;

    @GetMapping("/combined-data")
    public CompletableFuture<ResponseEntity<DashboardResponse>> getCombinedData(
            @RequestHeader("X-Username") Long loggedInEmployeeId,
            @RequestParam Long employeeId,
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(value = "userType", defaultValue = "employee") String userType) {

        DashboardResponse response = new DashboardResponse();

        // Employee API
        CompletableFuture<Void> employeeFuture = employeeController.getEmployeeById(loggedInEmployeeId, employeeId)
                .thenAccept(employeeResponse -> {
                    response.setEmployeeStatusCode(employeeResponse.getStatusCode());
                    response.setEmployee(employeeResponse.getBody());
                })
                .exceptionally(e -> {
                    response.setEmployeeStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
                    response.setEmployee(Optional.empty());
                    return null;
                });

        // Meetings API
        CompletableFuture<Void> meetingsFuture = CompletableFuture.supplyAsync(() -> employeeController.getDummyData())
                .thenAccept(meetings -> {
                    response.setMeetingsStatusCode(HttpStatus.OK);
                    response.setMeetings(meetings);
                })
                .exceptionally(e -> {
                    response.setMeetingsStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
                    response.setMeetings(Collections.emptyList());
                    return null;
                });

        // Sales API
        CompletableFuture<Void> salesFuture = salesController.getSalesInfo(loggedInEmployeeId, employeeId, userType)
                .thenAccept(salesResponse -> {
                    response.setSalesStatusCode(salesResponse.getStatusCode());
                    response.setSalesInfo(salesResponse.getBody());
                })
                .exceptionally(e -> {
                    response.setSalesStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
                    response.setSalesInfo(null);
                    return null;
                });

        // People API
        CompletableFuture<Void> peopleFuture = salesController.getTopSalesAgents(null)
                .thenAccept(peopleResponse -> {
                    response.setPeopleStatusCode(peopleResponse.getStatusCode());
                    response.setTopSalesAgents(peopleResponse.getBody());
                })
                .exceptionally(e -> {
                    response.setPeopleStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
                    response.setTopSalesAgents(Collections.emptyList());
                    return null;
                });

        // Pipeline API
        CompletableFuture<Void> pipelineFuture = pipelineController.getPipelineInfo(loggedInEmployeeId, employeeId, userType)
                .thenAccept(pipelineResponse -> {
                    response.setPipelineStatusCode(pipelineResponse.getStatusCode());
                    response.setPipelineInfo((PipelineDashboardResponse) pipelineResponse.getBody());
                })
                .exceptionally(e -> {
                    response.setPipelineStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
                    response.setPipelineInfo(null);
                    return null;
                });

        // Stages API
        CompletableFuture<Void> stagesFuture = pipelineController.getPoliciesCountAndPremiumSumByStage(loggedInEmployeeId, employeeId)
                .thenAccept(stagesResponse -> {
                    response.setStagesStatusCode(stagesResponse.getStatusCode());
                    response.setStages(stagesResponse.getBody());
                })
                .exceptionally(e -> {
                    response.setStagesStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
                    response.setStages(Collections.emptyList());
                    return null;
                });

        // Policy Retention Risks API
        CompletableFuture<Void> risksFuture = policyRetentionRiskController.getPolicyRetentionRisksOrderedBySurrenderProbability()
                .thenAccept(risks -> {
                    response.setPolicyRetentionRisksStatusCode(HttpStatus.OK);
                    response.setPolicyRetentionRisks(risks);
                })
                .exceptionally(e -> {
                    response.setPolicyRetentionRisksStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
                    response.setPolicyRetentionRisks(Collections.emptyList());
                    return null;
                });

        // Activities API
        CompletableFuture<Void> activitiesFuture = activityController.getActivityTypeCounts(loggedInEmployeeId, employeeId, userType, page, size)
                .thenAccept(activitiesResponse -> {
                    response.setActivitiesStatusCode(activitiesResponse.getStatusCode());
                    response.setActivities(activitiesResponse.getBody());
                })
                .exceptionally(e -> {
                    response.setActivitiesStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
                    response.setActivities(Page.empty());
                    return null;
                });

        // Interventions API
        CompletableFuture<Void> interventionsFuture = interventionsController.getInterventionTypeCounts(loggedInEmployeeId, employeeId, page, size)
                .thenAccept(interventionsResponse -> {
                    response.setInterventionsStatusCode(interventionsResponse.getStatusCode());
                    response.setInterventions(interventionsResponse.getBody());
                })
                .exceptionally(e -> {
                    response.setInterventionsStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
                    response.setInterventions(Page.empty());
                    return null;
                });

        // Interaction Details API
        CompletableFuture<Void> interactionDetailsFuture = interventionsController.getInteractionDetails(employeeId, page, size)
                .thenAccept(interactionDetailsResponse -> {
                    response.setInteractionDetailsStatusCode(interactionDetailsResponse.getStatusCode());
                    response.setInteractionDetails(interactionDetailsResponse.getBody());
                })
                .exceptionally(e -> {
                    response.setInteractionDetailsStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
                    response.setInteractionDetails(Page.empty());
                    return null;
                });

        // Combine all futures
        return CompletableFuture.allOf(
                employeeFuture,
                meetingsFuture,
                salesFuture,
                peopleFuture,
                pipelineFuture,
                stagesFuture,
                risksFuture,
                activitiesFuture,
                interventionsFuture,
                interactionDetailsFuture
        ).thenApply(v -> ResponseEntity.ok(response));
    }
}
