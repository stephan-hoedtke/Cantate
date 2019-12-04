package com.stho.cantate;

import android.util.SparseArray;
import android.util.SparseIntArray;

import java.util.Calendar;
import java.util.HashMap;

public class Year {

    final int year;
    private final SparseIntArray mapSundayByDayInYear;
    private final SparseIntArray mapDominicaByDayInYear;
    final Calendar advent;
    final Calendar christmas;
    final Calendar allerHeiligen;
    final Calendar allerSeelen;
    final Calendar johannis;
    final Calendar michaelis;
    final Calendar reformation;
    final Calendar silvester;
    final Calendar newYear;
    final Calendar epiphany;
    final Calendar easter;
    final Calendar pentecost;
    final Calendar trinity;
    final SparseArray<Sunday> sundays;

    static Year fromDate(SparseArray<EvangelicSunday> evangelic, SparseArray<CatholicDominica> catholic, Calendar date) {
        return new Year(evangelic, catholic, date.get(Calendar.YEAR));
    }

    static Year fromYear(SparseArray<EvangelicSunday> evangelic, SparseArray<CatholicDominica> catholic, int year) {
        return new Year(evangelic, catholic, year);
    }

    /*
        Calculation is based on calendar years, not on church year
     */
    private Year(final SparseArray<EvangelicSunday> evangelic, final SparseArray<CatholicDominica> catholic, int year) {
        this.year = year;

        this.newYear = Algorithms.getDate(year, Calendar.JANUARY, 1);
        this.epiphany = Algorithms.getDate(year, Calendar.JANUARY, 6);
        this.silvester = Algorithms.getDate(year, Calendar.DECEMBER, 31);
        this.allerHeiligen = Algorithms.getDate(year, Calendar.NOVEMBER, 1);
        this.allerSeelen = Algorithms.getDate(year, Calendar.NOVEMBER, 2);
        this.johannis = Algorithms.getDate(year, Calendar.JUNE, 24);
        this.michaelis = Algorithms.getDate(year, Calendar.SEPTEMBER, 29);
        this.reformation = Algorithms.getDate(year, Calendar.OCTOBER, 31);
        this.christmas = Algorithms.getDate(year, Calendar.DECEMBER, 25);
        this.easter = Algorithms.getEaster(year);
        this.pentecost = Algorithms.addWeeks(easter, 7);
        this.trinity = Algorithms.addWeeks(easter, 8);
        this.advent = Algorithms.addWeeks(Algorithms.getSundayBeforeExclusive(christmas), -3);

        this.mapSundayByDayInYear = EvangelicYear.getMap(this);
        this.mapDominicaByDayInYear = CatholicYear.getMap(this);

        this.sundays = prepareSundays(evangelic, catholic);
    }

    /*
      Must not be invoked before the year was initialized
     */
    private SparseArray<Sunday> prepareSundays(final SparseArray<EvangelicSunday> evangelic, final SparseArray<CatholicDominica> catholic) {
        final SparseArray<Sunday> sundays = new SparseArray<>();

        for (int index = 0; index < mapSundayByDayInYear.size(); index++) {
            int day = mapSundayByDayInYear.keyAt(index);
            @EvangelicSundayAnnotation.Sunday int key = mapSundayByDayInYear.valueAt(index);
            Sunday sunday = getSundayFor(sundays, day, year);
            sunday.setEvangelicSunday(evangelic.get(key));
        }

        for (int index = 0; index < mapDominicaByDayInYear.size(); index++) {
            int day = mapDominicaByDayInYear.keyAt(index);
            @CatholicDominicaAnnotation.Dominica int key = mapDominicaByDayInYear.valueAt(index);
            Sunday sunday = getSundayFor(sundays, day, year);
            sunday.setCatholicDominica(catholic.get(key));
        }

        return sundays;
    }

    private Sunday getSundayFor(final SparseArray<Sunday> sundays, int day, int year) {
        Sunday sunday = sundays.get(day);
        if (sunday == null) {
            sunday = new Sunday(year, day, Algorithms.getLiturgicalYear(this.year, day, this.advent));
            sundays.put(day, sunday);
        }
        return sunday;
    }

    final static int KEY_NOT_FOUND = -1;

    int getNextMusicDayInYear(Calendar date) {
        int dayInYear = date.get(Calendar.DAY_OF_YEAR);
        return getNextMusicDayInYear(dayInYear);
    }

    private static int NOT_FOUND = -1;

    int getNextMusicDayInYear(int dayInYear) {
        while (dayInYear <= 366) {
            @EvangelicSundayAnnotation.Sunday int musicDay = mapSundayByDayInYear.get(dayInYear, NOT_FOUND);
            if (musicDay > 0) {
                return dayInYear;
            }
            @CatholicDominicaAnnotation.Dominica int dominica = mapDominicaByDayInYear.get(dayInYear, NOT_FOUND);
            if (dominica > 0) {
                return dayInYear;
            }
            dayInYear++;
        }
        return KEY_NOT_FOUND;
    }

    int getPreviousMusicDayInYear(Calendar date) {
        int dayInYear = date.get(Calendar.DAY_OF_YEAR);
        return getPreviousMusicDayInYear(dayInYear);
    }

    int getPreviousMusicDayInYear(int dayInYear) {
        while (dayInYear >= 0) {
            @EvangelicSundayAnnotation.Sunday int musicDay = mapSundayByDayInYear.get(dayInYear, NOT_FOUND);
            if (musicDay > 0) {
                return dayInYear;
            }
            @CatholicDominicaAnnotation.Dominica int dominica = mapDominicaByDayInYear.get(dayInYear, NOT_FOUND);
            if (dominica > 0) {
                return dayInYear;
            }
            dayInYear--;
        }
        return KEY_NOT_FOUND;
    }

    int getNextSundayDayOfYear(Calendar date) {
        return Algorithms.getSundayAfterInclusive(date).get(Calendar.DAY_OF_YEAR);
    }
}
