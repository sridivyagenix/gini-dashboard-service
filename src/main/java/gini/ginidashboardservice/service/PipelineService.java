package gini.ginidashboardservice.service;

import gini.ginidashboardservice.dto.PipelineDashboardResponse;
import gini.ginidashboardservice.dto.StageSummary;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface PipelineService {
    Mono<PipelineDashboardResponse> getPipelineInfo(Long employeeId);
    Flux<StageSummary> getPoliciesCountAndPremiumSumByStageForEmployee(Long employeeId);
}
