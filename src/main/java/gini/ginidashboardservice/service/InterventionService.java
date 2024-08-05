package gini.ginidashboardservice.service;

import gini.ginidashboardservice.dto.ActivityResponse;
import gini.ginidashboardservice.dto.InterventionResponse;
import gini.ginidashboardservice.repositories.InterventionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface InterventionService {
    public Page<InterventionResponse> getInterventionTypeCountsByEmployeeId(Long employeeId, Pageable pageable);
}
