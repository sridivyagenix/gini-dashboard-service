package gini.ginidashboardservice.service;

import gini.ginidashboardservice.dto.SalesDashboardResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface SalesService {
    Mono<SalesDashboardResponse> getSalesInfo(Long employeeId);
}
