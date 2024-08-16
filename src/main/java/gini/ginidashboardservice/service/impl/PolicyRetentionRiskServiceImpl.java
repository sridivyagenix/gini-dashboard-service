package gini.ginidashboardservice.service.impl;

import gini.ginidashboardservice.models.PolicyRetentionRisk;
import gini.ginidashboardservice.repositories.PolicyRetentionRiskRepository;
import gini.ginidashboardservice.service.PolicyRetentionRiskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyRetentionRiskServiceImpl implements PolicyRetentionRiskService {
    private final PolicyRetentionRiskRepository policyRetentionRiskRepository;

    public PolicyRetentionRiskServiceImpl(PolicyRetentionRiskRepository policyRetentionRiskRepository) {
        this.policyRetentionRiskRepository = policyRetentionRiskRepository;
    }

    public List<PolicyRetentionRisk> getAllPolicyRetentionRisksOrderedBySurrenderProbability() {
        return policyRetentionRiskRepository.findAllByOrderBySurrenderProbablityPctDesc();
    }
}
