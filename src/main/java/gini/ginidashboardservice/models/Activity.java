package gini.ginidashboardservice.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "activities")
public class Activity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long activityId;

        private Long companyId;
        private Long employeeId;
        private Long salesAgentId;
        private Long customerId;
        private Long opportunityId;

        @Column(length = 50)
        private String activityType;

        private LocalDateTime createdDt;
        private LocalDateTime lastModifiedDt;

        @Column(length = 255)
        private String status;

        @Column(columnDefinition = "json")
        private String metadata;

        private LocalDateTime createdAt;
        private LocalDateTime lastModifiedAt;
}