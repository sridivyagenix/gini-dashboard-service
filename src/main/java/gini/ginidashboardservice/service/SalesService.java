package gini.ginidashboardservice.service;

import gini.ginidashboardservice.dto.SalesDashboardResponse;
import org.springframework.stereotype.Service;

@Service
public interface SalesService {
    SalesDashboardResponse getSalesInfo(Long employeeId);
}
