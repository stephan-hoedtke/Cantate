package com.stho.cantate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

class Formatter {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("EEE. yyyy-MM-dd", Locale.ENGLISH);

    static String toString(Calendar date) {
        // yyyy-MMM-dd HH:mm
        // EEEE -> EvangelicSunday; EEE -> Sun
        return sdf.format(date.getTime());
    }
}
