package gini.ginidashboardservice.controllers;

import gini.ginidashboardservice.service.ActivityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivityController {
    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/activities")
    public Page<Object[]> getActivityTypeCounts(
            @RequestParam Long employeeId,
            @RequestParam int page,
            @RequestParam int size) {
        return activityService.getActivityTypeCountsByEmployeeId(employeeId, PageRequest.of(page, size));
    }
}