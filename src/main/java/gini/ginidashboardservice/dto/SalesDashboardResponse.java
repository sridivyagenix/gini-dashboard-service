package gini.ginidashboardservice.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Data
public class SalesDashboardResponse {
    BigDecimal CurrentSales;
    Long TotalNumberOfSales;
    BigDecimal Goal;
    BigDecimal Drop;
}
