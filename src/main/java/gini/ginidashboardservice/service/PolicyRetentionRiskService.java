package gini.ginidashboardservice.service;

import gini.ginidashboardservice.models.PolicyRetentionRisk;

import java.util.List;

public interface PolicyRetentionRiskService {
    public List<PolicyRetentionRisk> getAllPolicyRetentionRisksOrderedBySurrenderProbability();
}
