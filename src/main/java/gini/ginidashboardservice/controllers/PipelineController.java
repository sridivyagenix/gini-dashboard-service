package gini.ginidashboardservice.controllers;

import gini.ginidashboardservice.dto.PipelineDashboardResponse;
import gini.ginidashboardservice.dto.StageSummary;
import gini.ginidashboardservice.service.PipelineService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PipelineController {

    private final PipelineService pipelineService;

    public PipelineController(PipelineService pipelineService) {
        this.pipelineService = pipelineService;
    }

    @GetMapping("/pipeline")
    public Mono<PipelineDashboardResponse> getPipelineInfo(@RequestParam Long employeeId)
    {
        return pipelineService.getPipelineInfo(employeeId);
    }
    @GetMapping("/stages")
    public Flux<StageSummary> getPoliciesCountAndPremiumSumByStage(@RequestParam("employeeId") Long employeeId) {
        return pipelineService.getPoliciesCountAndPremiumSumByStageForEmployee(employeeId);
    }
}
