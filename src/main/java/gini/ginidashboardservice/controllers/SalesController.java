package gini.ginidashboardservice.controllers;

import gini.ginidashboardservice.dto.SalesDashboardResponse;
import gini.ginidashboardservice.service.SalesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class SalesController {
    private final SalesService salesService;

    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @GetMapping("/sales")
    public Mono<SalesDashboardResponse> getSalesInfo(@RequestParam Long employeeId)
    {
        return salesService.getSalesInfo(employeeId);
    }

}
