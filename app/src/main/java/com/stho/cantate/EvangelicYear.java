package com.stho.cantate;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.util.SparseIntArray;

import java.util.Calendar;
import java.util.HashMap;

class EvangelicYear {

    private final Year year;
    private final SparseArray<String> map = new SparseArray<>();

    static SparseArray<String> getMap(Year year) {
        EvangelicYear calculator = new EvangelicYear(year);
        return calculator.map;
    }

    private EvangelicYear(Year year) {
        this.year = year;
        initialize();
    }

    private void initialize() {
        initializeMapNewYear();
        initializeMapAfterEpiphany();
        initializeMapEaster();
        initializeMapAfterTrinity();
        initializeMapAdvent();
        initializeMapSundayAfterChristmas(); // it may be overwritten by christmas
        initializeMapChristmas();
        initializeMapOthers();
    }

    private void initializeMapNewYear() {
        put(year.newYear, SundayAnnotation.NEW_YEAR);
        put(Algorithms.getSundayAfterExclusive(year.newYear), SundayAnnotation.SUNDAY_AFTER_NEW_YEAR);
        put(year.epiphany, SundayAnnotation.EPIPHANY);
    }

    private void initializeMapAfterEpiphany() {
        int day = Algorithms.getSundayAfterExclusive(year.epiphany).get(Calendar.DAY_OF_YEAR);
        @SundayAnnotation.Sunday String[] sundays = new String[] {
                SundayAnnotation.SUNDAY_AFTER_EPIPHANY_1,
                SundayAnnotation.SUNDAY_AFTER_EPIPHANY_2,
                SundayAnnotation.SUNDAY_AFTER_EPIPHANY_3,
                SundayAnnotation.SUNDAY_AFTER_EPIPHANY_4,
                SundayAnnotation.SUNDAY_AFTER_EPIPHANY_5,
                SundayAnnotation.SUNDAY_AFTER_EPIPHANY_6,
        };
        for (int i=0; i < 6; i++) {
            put(day, sundays[i]);
            day += 7;
        }
    }

    private void initializeMapEaster() {
        int day = year.easter.get(Calendar.DAY_OF_YEAR);
        put(day - 63, SundayAnnotation.SEPTUAGESIMA);
        put(day - 56, SundayAnnotation.SEXAGESIMA);
        put(day - 49, SundayAnnotation.QUINQUAGESIMA_ESTOMIHI);
        put(day - 46, SundayAnnotation.ASH_WEDNESDAY);
        put(day - 42, SundayAnnotation.INVOCABIT);
        put(day - 35, SundayAnnotation.REMINISCERE);
        put(day - 28, SundayAnnotation.OCULI);
        put(day - 21, SundayAnnotation.LAETARE);
        put(day - 14, SundayAnnotation.JUDICA);
        put(day - 7, SundayAnnotation.PALMARUM);
        put(day - 2, SundayAnnotation.GOOD_FRIDAY);
        put(day, SundayAnnotation.EASTER_SUNDAY);
        put(day + 2, SundayAnnotation.EASTER_MONDAY);
        put(day + 3, SundayAnnotation.EASTER_TUESDAY);
        put(day + 7, SundayAnnotation.QUASIMODOGENITI);
        put(day + 14, SundayAnnotation.MISERICORDIAS);
        put(day + 21, SundayAnnotation.JUBILATE);
        put(day + 28, SundayAnnotation.CANTATE);
        put(day + 35, SundayAnnotation.ROGATE);
        put(day + 39, SundayAnnotation.ASCENSION_DAY);
        put(day + 42, SundayAnnotation.EXAUDI);
        put(day + 49, SundayAnnotation.PENTECOST_SUNDAY);
        put(day + 50, SundayAnnotation.PENTECOST_MONDAY);
        put(day + 51, SundayAnnotation.PENTECOST_TUESDAY);
        put(day + 56, SundayAnnotation.TRINITY);
    }

    private void initializeMapAfterTrinity() {
        int day = Algorithms.getSundayAfterExclusive(year.trinity).get(Calendar.DAY_OF_YEAR);
        @SundayAnnotation.Sunday String[] sundays = new String[] {
                SundayAnnotation.SUNDAY_1_AFTER_TRINITY,
                SundayAnnotation.SUNDAY_2_AFTER_TRINITY,
                SundayAnnotation.SUNDAY_3_AFTER_TRINITY,
                SundayAnnotation.SUNDAY_4_AFTER_TRINITY,
                SundayAnnotation.SUNDAY_5_AFTER_TRINITY,
                SundayAnnotation.SUNDAY_6_AFTER_TRINITY,
                SundayAnnotation.SUNDAY_7_AFTER_TRINITY,
                SundayAnnotation.SUNDAY_8_AFTER_TRINITY,
                SundayAnnotation.SUNDAY_9_AFTER_TRINITY,
                SundayAnnotation.SUNDAY_10_AFTER_TRINITY,
                SundayAnnotation.SUNDAY_11_AFTER_TRINITY,
                SundayAnnotation.SUNDAY_12_AFTER_TRINITY,
                SundayAnnotation.SUNDAY_13_AFTER_TRINITY,
                SundayAnnotation.SUNDAY_14_AFTER_TRINITY,
                SundayAnnotation.SUNDAY_15_AFTER_TRINITY,
                SundayAnnotation.SUNDAY_16_AFTER_TRINITY,
                SundayAnnotation.SUNDAY_17_AFTER_TRINITY,
                SundayAnnotation.SUNDAY_18_AFTER_TRINITY,
                SundayAnnotation.SUNDAY_19_AFTER_TRINITY,
                SundayAnnotation.SUNDAY_20_AFTER_TRINITY,
                SundayAnnotation.SUNDAY_21_AFTER_TRINITY,
                SundayAnnotation.SUNDAY_22_AFTER_TRINITY,
                SundayAnnotation.SUNDAY_23_AFTER_TRINITY,
                SundayAnnotation.SUNDAY_24_AFTER_TRINITY,
                SundayAnnotation.SUNDAY_25_AFTER_TRINITY,
                SundayAnnotation.SUNDAY_26_AFTER_TRINITY,
                SundayAnnotation.SUNDAY_27_AFTER_TRINITY,
        };
        for (int i=0; i < 27; i++) {
            put(day, sundays[i]);
            day += 7;
        }
    }

    private void initializeMapAdvent() {
        int day = year.advent.get(Calendar.DAY_OF_YEAR);
        put(day, SundayAnnotation.SUNDAY_1_IN_ADVENT);
        put(day + 7, SundayAnnotation.SUNDAY_2_IN_ADVENT);
        put(day + 14, SundayAnnotation.SUNDAY_3_IN_ADVENT);
        put(day + 21, SundayAnnotation.SUNDAY_4_IN_ADVENT);
    }

    private void initializeMapSundayAfterChristmas() {
        put(Algorithms.getSundayAfterExclusive(year.christmas), SundayAnnotation.SUNDAY_AFTER_CHRISTMAS);
    }

    private void initializeMapChristmas() {
        int day = year.christmas.get(Calendar.DAY_OF_YEAR);
        put(day, SundayAnnotation.CHRISTMAS_DAY_1);
        put(day + 1, SundayAnnotation.CHRISTMAS_DAY_2);
        put(day + 2, SundayAnnotation.CHRISTMAS_DAY_3);
    }

    private void initializeMapOthers() {
        put(year.johannis, SundayAnnotation.JOHANNIS);
        put(year.michaelis, SundayAnnotation.MICHAELIS);
        put(year.reformation, SundayAnnotation.REFORMATION);
    }

    private void put(Calendar date, @SundayAnnotation.Sunday String sunday) {
        map.put(date.get(Calendar.DAY_OF_YEAR), sunday);
    }

    private void put(int day, @SundayAnnotation.Sunday String sunday) {
        map.put(day, sunday);
    }

}

