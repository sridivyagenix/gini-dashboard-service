package gini.ginidashboardservice.models;

import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDateTime;

@Entity
@Data
@Table("employees")
public class Employee {

    @Id
    private Long employeeId;

    @Column("employee_name")
    private String employeeName;

    @Column("email")
    private String email;

    @Column("last_modified_at")
    private LocalDateTime lastModifiedAt;
}
