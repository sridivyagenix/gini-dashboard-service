package gini.ginidashboardservice.controllers;

import gini.ginidashboardservice.dto.PipelineDashboardResponse;
import gini.ginidashboardservice.dto.StageSummary;
import gini.ginidashboardservice.service.PipelineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PipelineController {

    private final PipelineService pipelineService;

    public PipelineController(PipelineService pipelineService) {
        this.pipelineService = pipelineService;
    }

    @GetMapping("/pipeline")
    public ResponseEntity<PipelineDashboardResponse> getPipelineInfo(@RequestHeader("X-Username") Long loggedInEmployeeId, @RequestParam Long employeeId)
    {
        if (!employeeId.equals(loggedInEmployeeId)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(pipelineService.getPipelineInfo(employeeId));
    }
    @GetMapping("/stages")
    public ResponseEntity<List<StageSummary>> getPoliciesCountAndPremiumSumByStage(@RequestHeader("X-Username") Long loggedInEmployeeId, @RequestParam("employeeId") Long employeeId) {
        if (!employeeId.equals(loggedInEmployeeId)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(pipelineService.getPoliciesCountAndPremiumSumByStageForEmployee(employeeId));
    }
}
