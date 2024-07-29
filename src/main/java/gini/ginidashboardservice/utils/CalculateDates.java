package gini.ginidashboardservice.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CalculateDates {
    public LocalDateTime getEndDate() {
        // Calculate the end of the year: December 31, 23:59:59.999
        LocalDateTime endOfYear = LocalDateTime.of(
                LocalDateTime.now().getYear(),  // Current year
                12,                            // December
                31,                            // Last day
                23,                            // 23 hours
                59,                            // 59 minutes
                59,                            // 59 seconds
                999_999_999                     // 999 milliseconds
        );
        return endOfYear;
    }

    public LocalDateTime getStartDate() {
        // Calculate the start of the year: January 1, 00:00:00
        LocalDateTime startOfYear = LocalDateTime.of(
                LocalDateTime.now().getYear(),  // Current year
                1,                             // January
                1,                             // First day
                0,                             // 00 hours
                0,                             // 00 minutes
                0,                             // 00 seconds
                0                               // 0 milliseconds
        );
        return startOfYear;
    }

//    private Date toDate(LocalDateTime localDateTime) {
//        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
//        return Date.from(zonedDateTime.toInstant());
//    }
}
