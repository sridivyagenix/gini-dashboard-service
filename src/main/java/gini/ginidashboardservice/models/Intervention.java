package gini.ginidashboardservice.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "interactions")
public class Intervention {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "interaction_id", updatable = false, nullable = false)
        private Long interactionId;

        @Column(name = "company_id", nullable = false, columnDefinition = "bigint unsigned default 0")
        private Long companyId;

        @Column(name = "employee_id", nullable = false)
        private Long employeeId;

        @Column(name = "sales_agent_id", nullable = false)
        private Long salesAgentId;

        @Column(name = "created_dt", nullable = false)
        private LocalDateTime createdDt;

        @Column(name = "interaction_type", nullable = false, length = 50)
        private String interactionType;

        @Column(name = "description", nullable = false, length = 255)
        private String description;

        @Column(name = "follow_up", nullable = false, length = 255)
        private String followUp;

        @Column(name = "status", nullable = false, length = 50)
        private String status;

        @Column(name = "metadata", nullable = false, columnDefinition = "json")
        private String metadata;

        @Column(name = "created_at", nullable = false, columnDefinition = "timestamp default current_timestamp")
        private LocalDateTime createdAt;

        @Column(name = "last_modified_at", nullable = false, columnDefinition = "timestamp default current_timestamp on update current_timestamp")
        private LocalDateTime lastModifiedAt;
}