package gini.ginidashboardservice.utils;

import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
public class CalculateDates {

    public Date getEndDate() {
        // Get current year
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        Calendar endDateCalendar = Calendar.getInstance();
        endDateCalendar.set(Calendar.YEAR, currentYear);
        endDateCalendar.set(Calendar.MONTH, Calendar.DECEMBER);
        endDateCalendar.set(Calendar.DAY_OF_MONTH, 31);
        endDateCalendar.set(Calendar.HOUR_OF_DAY, 23); // Set to end of the day
        endDateCalendar.set(Calendar.MINUTE, 59);
        endDateCalendar.set(Calendar.SECOND, 59);
        Date endDate = endDateCalendar.getTime();
        return endDate;
    }

    public Date getStartDate() {
        // Get current year
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        // Get start and end dates of the current year
        Calendar startDateCalendar = Calendar.getInstance();
        startDateCalendar.set(Calendar.YEAR, currentYear);
        startDateCalendar.set(Calendar.MONTH, Calendar.JANUARY);
        startDateCalendar.set(Calendar.DAY_OF_MONTH, 1);
        startDateCalendar.set(Calendar.HOUR_OF_DAY, 0); // Set to beginning of the day
        startDateCalendar.set(Calendar.MINUTE, 0);
        startDateCalendar.set(Calendar.SECOND, 0);
        Date startDate = startDateCalendar.getTime();
        return startDate;
    }
}
