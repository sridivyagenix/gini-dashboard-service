package gini.ginidashboardservice.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
@Data
public class PipelineDashboardResponse {
    BigDecimal PipelineSales;
}
