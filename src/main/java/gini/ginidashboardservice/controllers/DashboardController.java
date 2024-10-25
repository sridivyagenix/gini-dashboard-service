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
    public ResponseEntity<DashboardResponse> getCombinedData(
            @RequestHeader("X-Username") Long loggedInEmployeeId,
            @RequestParam Long employeeId,
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(value = "userType", defaultValue = "employee") String userType) {

        DashboardResponse response = new DashboardResponse();

        // Employee API
        try {
            ResponseEntity<Optional<Employee>> employeeResponse = employeeController.getEmployeeById(loggedInEmployeeId, employeeId);
            response.setEmployeeStatusCode(employeeResponse.getStatusCode());
            response.setEmployee(employeeResponse.getBody());
        } catch (Exception e) {
            response.setEmployeeStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setEmployee(Optional.empty());
        }

        // Meetings API
        try {
            List<Meetings> meetings = employeeController.getDummyData();
            response.setMeetingsStatusCode(HttpStatus.OK);
            response.setMeetings(meetings);
        }   catch (Exception e) {
            response.setMeetingsStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMeetings(Collections.emptyList());
        }

        // Sales API
        try {
            ResponseEntity<SalesDashboardResponse> salesResponse = salesController.getSalesInfo(loggedInEmployeeId, employeeId, userType);
            response.setSalesStatusCode(salesResponse.getStatusCode());
            response.setSalesInfo(salesResponse.getBody());
        } catch (Exception e) {
            response.setSalesStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setSalesInfo(null);
        }

        // People API
        try
        {
            ResponseEntity<List<SalesAgentSummary>> peopleResponse = salesController.getTopSalesAgents(null);
            response.setPeopleStatusCode(peopleResponse.getStatusCode());
            response.setTopSalesAgents(peopleResponse.getBody());
        } catch (Exception e) {
            response.setPeopleStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setTopSalesAgents(Collections.emptyList());
        }

        // Pipeline API
        try {
            ResponseEntity<PipelineDashboardResponse> pipelineResponse = pipelineController.getPipelineInfo(loggedInEmployeeId, employeeId, userType);
            response.setPipelineStatusCode(pipelineResponse.getStatusCode());
            response.setPipelineInfo(pipelineResponse.getBody());
        } catch (Exception e) {
            response.setPipelineStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setPipelineInfo(null);
        }

        // Stages API
        try
        {
            ResponseEntity<List<StageSummary>> stagesResponse = pipelineController.getPoliciesCountAndPremiumSumByStage(loggedInEmployeeId, employeeId);
            response.setStagesStatusCode(stagesResponse.getStatusCode());
            response.setStages(stagesResponse.getBody());
        } catch (Exception e) {
            response.setStagesStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setStages(Collections.emptyList());
        }


        // Policy Retention Risks API
        try
        {
            List<PolicyRetentionRisk> risks = policyRetentionRiskController.getPolicyRetentionRisksOrderedBySurrenderProbability();
            response.setPolicyRetentionRisksStatusCode(HttpStatus.OK);
            response.setPolicyRetentionRisks(risks);
        } catch (Exception e) {
            response.setPolicyRetentionRisksStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setPolicyRetentionRisks(Collections.emptyList());
        }

        // Activities API
        try {
            ResponseEntity<Page<ActivityResponse>> activitiesResponse = activityController.getActivityTypeCounts(loggedInEmployeeId, employeeId, userType, page, size);
            response.setActivitiesStatusCode(activitiesResponse.getStatusCode());
            response.setActivities(activitiesResponse.getBody());
        } catch (Exception e) {
            response.setActivitiesStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setActivities(Page.empty());
        }

        // Interventions API
        try
        {
            ResponseEntity<Page<InterventionResponse>> interventionsResponse = interventionsController.getInterventionTypeCounts(loggedInEmployeeId, employeeId, page, size);
            response.setInterventionsStatusCode(interventionsResponse.getStatusCode());
            response.setInterventions(interventionsResponse.getBody());
        } catch (Exception e) {
            response.setInterventionsStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setInterventions(Page.empty());
        }

        // Interaction Details API
        try {
            ResponseEntity<Page<PeopleDTO>> interactionDetailsResponse = interventionsController.getInteractionDetails(employeeId, page, size);
            response.setInteractionDetailsStatusCode(interactionDetailsResponse.getStatusCode());
            response.setInteractionDetails(interactionDetailsResponse.getBody());
        } catch (Exception e) {
            response.setInteractionDetailsStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setInteractionDetails(Page.empty());
        }

        return ResponseEntity.ok(response);
    }
}
