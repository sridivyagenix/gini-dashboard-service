package gini.ginidashboardservice.controllers;

import gini.ginidashboardservice.dto.ActivityResponse;
import gini.ginidashboardservice.service.ActivityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivityController {
    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/activities")
    public ResponseEntity<Page<ActivityResponse>> getActivityTypeCounts(
            @RequestHeader("X-Username") Long loggedInEmployeeId,
            @RequestParam Long employeeId,
            @RequestParam int page,
            @RequestParam int size) {
        if (!employeeId.equals(loggedInEmployeeId)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        Page<ActivityResponse> activities = activityService.getActivityTypeCountsByEmployeeId(employeeId, PageRequest.of(page, size));
        return ResponseEntity.ok(activities);
    }
}