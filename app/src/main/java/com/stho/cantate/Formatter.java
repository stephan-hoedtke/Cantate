package com.stho.cantate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

class Formatter {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("EEE d.M.yyyy", Locale.GERMANY);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

    static String toString(Calendar date) {
        // yyyy-MMM-dd HH:mms
        // EEE -> Sunday; EEE -> Sun
        // MMM --> Jul
        return sdf.format(date.getTime());
    }

    static Calendar parseString(String dateString) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateFormat.parse(dateString));
            return calendar;
        }
        catch (ParseException e) {
            return null;
        }
    }
}

