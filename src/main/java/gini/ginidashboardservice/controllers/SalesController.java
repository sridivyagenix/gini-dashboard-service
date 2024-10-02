package gini.ginidashboardservice.controllers;

import gini.ginidashboardservice.dto.SalesAgentSummary;
import gini.ginidashboardservice.dto.SalesDashboardResponse;
import gini.ginidashboardservice.service.SalesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SalesController {
    private final SalesService salesService;

    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @GetMapping("/sales")
    public ResponseEntity<SalesDashboardResponse> getSalesInfo(@RequestHeader("X-Username") Long loggedInEmployeeId, @RequestParam Long employeeId)
    {
        if (!employeeId.equals(loggedInEmployeeId)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(salesService.getSalesInfo(employeeId));
    }

    @GetMapping("/people")
    public ResponseEntity<List<SalesAgentSummary>> getTopSalesAgents(@RequestParam(required = false) String agentName) {
        List<SalesAgentSummary> salesAgents = salesService.getTopSalesAgents(agentName);
        return ResponseEntity.ok(salesAgents);
    }

}
