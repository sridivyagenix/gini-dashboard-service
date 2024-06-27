package gini.ginidashboardservice.service.impl;

import gini.ginidashboardservice.dto.PipelineDashboardResponse;
import gini.ginidashboardservice.dto.StageSummary;
import gini.ginidashboardservice.models.SalesPipelineEntries;
import gini.ginidashboardservice.repositories.SalesPipelineEntriesRepository;
import gini.ginidashboardservice.service.PipelineService;
import gini.ginidashboardservice.utils.CalculateDates;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Service
public class PipelineServiceImpl implements PipelineService{
    private final SalesPipelineEntriesRepository salesPipelineEntryRepository;
    private final CalculateDates calculateDates;

    public PipelineServiceImpl(SalesPipelineEntriesRepository salesPipelineEntryRepository, CalculateDates calculateDates) {
        this.salesPipelineEntryRepository = salesPipelineEntryRepository;
        this.calculateDates = calculateDates;
    }

    @Override
    public Mono<PipelineDashboardResponse> getPipelineInfo(Long employeeId) {
        return getPipelineSalesByEmployeeIdAndCurrentYear(employeeId)
                .map(pipelineSales -> {
                    PipelineDashboardResponse response = new PipelineDashboardResponse();
                    response.setPipelineSales(pipelineSales);
                    return response;
                });
    }

    private Mono<BigDecimal> getPipelineSalesByEmployeeIdAndCurrentYear(Long employeeId) {
        String[] opportunityType = {"New Policy Sale", "Cross-Sell Opportunity"};
        String[] stages = {"Qualification", "Underwriting", "Proposal", "Negotiation", "Needs Analysis", "Prospecting"};

        return salesPipelineEntryRepository.findByEmployeeIdAndCreatedDtBetweenAndOpportunityTypeInAndStageIn(
                        employeeId,
                        calculateDates.getStartDate(),
                        calculateDates.getEndDate(),
                        opportunityType,
                        stages)
                .map(SalesPipelineEntries::getTargetPremiumAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public Flux<StageSummary> getPoliciesCountAndPremiumSumByStageForEmployee(Long employeeId) {
        return salesPipelineEntryRepository.findPoliciesCountAndPremiumSumByStageForEmployee(employeeId);
    }
}
