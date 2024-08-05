package gini.ginidashboardservice.service.impl;

import gini.ginidashboardservice.dto.InterventionResponse;
import gini.ginidashboardservice.repositories.InterventionRepository;
import gini.ginidashboardservice.service.InterventionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class InterventionServiceImpl implements InterventionService {
    private final InterventionRepository interventionRepository;

    public InterventionServiceImpl(InterventionRepository interventionRepository) {
        this.interventionRepository = interventionRepository;
    }


    @Override
    public Page<InterventionResponse> getInterventionTypeCountsByEmployeeId(Long employeeId, Pageable pageable) {
        return interventionRepository.findInterventionTypeCountsByEmployeeId(employeeId, pageable);
    }
}
