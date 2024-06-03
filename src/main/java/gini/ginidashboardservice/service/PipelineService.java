package gini.ginidashboardservice.service;

import gini.ginidashboardservice.dto.PipelineDashboardResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface PipelineService {
    Mono<PipelineDashboardResponse> getPipelineInfo(Long employeeId);
}
