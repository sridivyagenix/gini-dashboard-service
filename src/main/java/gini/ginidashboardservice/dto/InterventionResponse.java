package gini.ginidashboardservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterventionResponse {
    private long employeeId;
    private String interventionType;
    private long count;
}
