package com.company;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;


/**
 * Created by NecroS on 11/19/2016.
 */
public class DateHelper {
    private int SkipLengthInMinutes = 2;
    private Calendar battleStartDate;
    private Calendar date;
    private Calendar diffDate = new GregorianCalendar(0, 0, 0, 0, 0, 0);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyy MMM dd HH:mm:ss");

    public String getFormattedStartDate() {
        return dateFormat.format(battleStartDate.getTime());
    }

    public void skipTime() {
        Date dt = date.getTime();
        dt.setTime(dt.getTime() + SkipLengthInMinutes * 60 * 1000);
        date.setTime(dt);
    }

    public String getFormattedDiff() {
        Long dt = date.getTime().getTime() - battleStartDate.getTime().getTime();
        /*diffDate.set(
                date.get(Calendar.YEAR) - battleStartDate.get(Calendar.YEAR),
                date.get(Calendar.HOUR_OF_DAY) - battleStartDate.get(Calendar.HOUR_OF_DAY),
                date.get(Calendar.MINUTE) - battleStartDate.get(Calendar.MINUTE));*/
        return String.format("%s", TimeUnit.MINUTES.convert(dt, TimeUnit.MILLISECONDS));
    }

    public DateHelper() {
        battleStartDate = Calendar.getInstance();
        battleStartDate.add(Calendar.YEAR, -1500);
        date = (Calendar) battleStartDate.clone();
    }
}
