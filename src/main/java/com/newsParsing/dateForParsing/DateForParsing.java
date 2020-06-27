package com.newsParsing.dateForParsing;

import com.newsParsing.dataHolder.SiteUrls;
import com.newsParsing.htmlParsers.HtmlGetter;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class DateForParsing {
    private final String yesterdayDateString;
    private final String dayBeforeYesterday;

    public DateForParsing() {
        this.yesterdayDateString = yesterday();
        this.dayBeforeYesterday = dayBeforeYesterday();
    }

    public String getYesterdayDateString() {
        return yesterdayDateString;
    }

    public String getDayBeforeYesterday() {
        return dayBeforeYesterday;
    }

    private String dayBeforeYesterday() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -2);
        return getDateString(cal.getTime());
    }

    private String yesterday() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return getDateString(cal.getTime());
    }

    private String getDateString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("d");
        return dateFormat.format(date);
    }

}
