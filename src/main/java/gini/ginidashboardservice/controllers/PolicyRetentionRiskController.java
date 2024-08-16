package gini.ginidashboardservice.controllers;

import gini.ginidashboardservice.models.PolicyRetentionRisk;
import gini.ginidashboardservice.service.PolicyRetentionRiskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PolicyRetentionRiskController {

    private final PolicyRetentionRiskService policyRetentionRiskService;

    public PolicyRetentionRiskController(PolicyRetentionRiskService policyRetentionRiskService) {
        this.policyRetentionRiskService = policyRetentionRiskService;
    }

    @GetMapping("/policy-retention-risks")
    public List<PolicyRetentionRisk> getPolicyRetentionRisksOrderedBySurrenderProbability() {
        return policyRetentionRiskService.getAllPolicyRetentionRisksOrderedBySurrenderProbability();
    }
}