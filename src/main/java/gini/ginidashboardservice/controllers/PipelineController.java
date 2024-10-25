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
import java.util.concurrent.CompletableFuture;

@RestController
public class PipelineController {

    private final PipelineService pipelineService;

    public PipelineController(PipelineService pipelineService) {
        this.pipelineService = pipelineService;
    }

    @GetMapping("/pipeline")
    public CompletableFuture<ResponseEntity<Object>> getPipelineInfo(@RequestHeader("X-Username") Long loggedInEmployeeId, @RequestParam Long id, @RequestParam(value = "userType", defaultValue = "employee") String userType)
    {
        PipelineDashboardResponse response;
        if ("sales_agent".equalsIgnoreCase(userType)) {
            response = pipelineService.getPipelineInfoForSalesAgent(id);  // Call sales agent-specific service
        } else {
            if (!id.equals(loggedInEmployeeId)) {
                return CompletableFuture.completedFuture(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
            }
            response = pipelineService.getPipelineInfo(id);  // Call employee-specific service
        }
        return CompletableFuture.completedFuture(ResponseEntity.ok(response));
    }
    @GetMapping("/stages")
    public CompletableFuture<ResponseEntity<List<StageSummary>>> getPoliciesCountAndPremiumSumByStage(@RequestHeader("X-Username") Long loggedInEmployeeId, @RequestParam("employeeId") Long employeeId) {
        if (!employeeId.equals(loggedInEmployeeId)) {
            return CompletableFuture.completedFuture(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
        }
        return CompletableFuture.completedFuture(ResponseEntity.ok(pipelineService.getPoliciesCountAndPremiumSumByStageForEmployee(employeeId)));
    }
}
