package gini.ginidashboardservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ActivityService {
    public Page<Object[]> getActivityTypeCountsByEmployeeId(Long employeeId, Pageable pageable);
}
