package com.rbc.shopping.scheduler;

import com.rbc.shopping.util.AppConstants;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Loads the Data on Daily basis to the database.
 *
 * @author SARA
 */
@Component
public final class DataScheduler {

    /**
     * Fires the Database refresh event every day at 10:15 PM.
     *
     */
    @Scheduled(cron = "0 15 22 * * ?")
    public void cronJobSch() {
        final SimpleDateFormat sdf = new SimpleDateFormat(AppConstants.SCHEDULER_DATE_FORMAT);
        final Date now = new Date();
        final String strDate = sdf.format(now);
        /* DEVELOPER NOTE: SARA As of now the application utilizes h2 in-memory database.
         The logic for connecting to the database and loading data can be implemented here once the
         real database such as Oracle or MySQL is connected.
         */
        System.out.println("Database Refresh scheduler executed at :: " + strDate);
    }
}
