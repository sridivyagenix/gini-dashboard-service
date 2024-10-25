package gini.ginidashboardservice.dto;

import gini.ginidashboardservice.models.Employee;
import gini.ginidashboardservice.models.PolicyRetentionRisk;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatusCode;

import java.util.List;
import java.util.Optional;

@Data
public class DashboardResponse {
    private HttpStatusCode employeeStatusCode;
    private Optional<Employee> employee;

    private HttpStatusCode meetingsStatusCode;
    private List<Meetings> meetings;

    private HttpStatusCode salesStatusCode;
    private SalesDashboardResponse salesInfo;

    private HttpStatusCode peopleStatusCode;
    private List<SalesAgentSummary> topSalesAgents;

    private HttpStatusCode pipelineStatusCode;
    private PipelineDashboardResponse pipelineInfo;

    private HttpStatusCode stagesStatusCode;
    private List<StageSummary> stages;

    private HttpStatusCode policyRetentionRisksStatusCode;
    private List<PolicyRetentionRisk> policyRetentionRisks;

    private HttpStatusCode activitiesStatusCode;
    private Page<ActivityResponse> activities;

    private HttpStatusCode interventionsStatusCode;
    private Page<InterventionResponse> interventions;

    private HttpStatusCode interactionDetailsStatusCode;
    private Page<PeopleDTO> interactionDetails;
}
