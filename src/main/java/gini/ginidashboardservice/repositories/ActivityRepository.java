package gini.ginidashboardservice.repositories;


import gini.ginidashboardservice.models.Activity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

    @Query(value = "SELECT a.activity_type AS type, COUNT(*) AS typeCount FROM activities a " +
            "WHERE a.employee_id = :employeeId " +
            "AND a.last_modified_dt BETWEEN DATE_SUB(CURRENT_DATE(), INTERVAL 360 DAY) AND CURRENT_DATE() " +
            "GROUP BY a.activity_type " +
            "ORDER BY typeCount DESC",nativeQuery = true)
    Page<Object[]> findActivityTypeCountsByEmployeeId(@Param("employeeId") Long employeeId, Pageable pageable);
}