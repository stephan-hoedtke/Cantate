package com.stho.cantate;

import java.time.Duration;
import java.util.Calendar;
import java.util.GregorianCalendar;

class Algorithms {

    static Calendar getEaster(int year) {
        /*
            https://www.timeanddate.com/calendar/determining-easter-date.html

            In 325 CE, the Council of Nicaea established that Easter would be held on the first EvangelicSunday after the first Full Moon
            occurring on or after the vernal equinox.
            From that point forward, the Easter date depended on the ecclesiastical approximation of March 21 for the vernal equinox.

            Sonnengleichung: 365,2425 Tage/Jahr Schaltjahr (+1 Tag=29. Feb) := 1) /4 --> ja, /100 --> nein, /400 --> ja
            Mondgleichung: Schaltjahr (-1 Tag) alle 312.5 Jahre (2500 / 8)

            Gaußsche Osterformel von 1816
            https://de.wikipedia.org/wiki/Gau%C3%9Fsche_Osterformel
        */

        int a = year % 19;
        int b = year % 4;
        int c = year % 7;
        int k = year / 100;
        int p = (8 * k + 13) / 25;
        int q = k / 4;
        int M = (15 + k - p - q) % 30;
        int d = (19 * a + M) % 30;
        int N = (4 + k - q) % 7;
        int e = (2 * b + 4 * c + 6 * d + N) % 7;
        int day = (22 + d + e);
        int month = Calendar.MARCH;
        if (day > 31) {
            day -= 31;
            month = Calendar.APRIL;
        }
        Calendar date = Calendar.getInstance();
        date.set(year, month, day);
        return date;
    }

    static Calendar getDate(int year, int month, int dayOfMonth) {
        Calendar date = Calendar.getInstance();
        date.set(year, month, dayOfMonth);
        return date;
    }

    static Calendar getDate(int year, int dayOfYear) {
        Calendar date = Calendar.getInstance();
        date.set(Calendar.YEAR, year);
        date.set(Calendar.DAY_OF_YEAR, dayOfYear);
        return date;
    }

    static Calendar getSundayBeforeExclusive(Calendar date) {
        int day = date.get(Calendar.DAY_OF_WEEK);
        int days = 0;
        switch (day) {
            case Calendar.MONDAY:
                days = -1;
                break;
            case Calendar.TUESDAY:
                days = -2;
                break;
            case Calendar.WEDNESDAY:
                days = -3;
                break;
            case Calendar.THURSDAY:
                days = -4;
                break;
            case Calendar.FRIDAY:
                days = -5;
                break;
            case Calendar.SATURDAY:
                days = -6;
                break;
            case Calendar.SUNDAY:
                days = -7;
                break;
        }
        return addDays(date, days);
    }

    static Calendar getSundayAfterExclusive(Calendar date) {
        int day = date.get(Calendar.DAY_OF_WEEK);
        int days = 0;
        switch (day) {
            case Calendar.MONDAY:
                days = 6;
                break;
            case Calendar.TUESDAY:
                days = 5;
                break;
            case Calendar.WEDNESDAY:
                days = 4;
                break;
            case Calendar.THURSDAY:
                days = 3;
                break;
            case Calendar.FRIDAY:
                days = 2;
                break;
            case Calendar.SATURDAY:
                days = 1;
                break;
            case Calendar.SUNDAY:
                days = 7;
                break;
        }
        return addDays(date, days);
    }

    static Calendar getSundayAfterInclusive(Calendar date) {
        int day = date.get(Calendar.DAY_OF_WEEK);
        if (day == Calendar.SUNDAY) {
            return date;
        }
        else {
            return getSundayAfterExclusive(date);
        }
    }

    static Calendar addDays(Calendar date, int days) {
        Calendar newDate = Calendar.getInstance();
        newDate.setTimeInMillis(date.getTimeInMillis());
        newDate.add(Calendar.DAY_OF_MONTH, days);
        return newDate;
    }

    static Calendar addWeeks(Calendar date, int weeks) {
        return addDays(date, 7 * weeks);
    }

    static boolean isLeapYear(int year) {
        GregorianCalendar x = (GregorianCalendar) GregorianCalendar.getInstance();
        return x.isLeapYear(year);
    }

    static int weeksBetween(Calendar a, Calendar b) {
        Duration duration = Duration.between(a.toInstant(), b.toInstant());
        long days = duration.toDays();
        return (int) (days / 7);
    }

    /*
            2019 before advent --> "C"
            2019 after advent --> "A"
     */
    static @CatholicLiturgicalYearAnnotation.Year int getLiturgicalYear(int year, int dayInYear, Calendar advent) {
        if (dayInYear >= advent.get(Calendar.DAY_OF_YEAR)) {
            year++;
        }
        switch (year % 3) {
            default:
            case 0:
                return CatholicLiturgicalYearAnnotation.C;
            case 1:
                return CatholicLiturgicalYearAnnotation.A;
            case 2:
                return CatholicLiturgicalYearAnnotation.B;
        }
    }
}
