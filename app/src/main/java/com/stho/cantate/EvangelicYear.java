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
        put(Algorithms.getSundayAfterExclusive(year.newYear), SundayAnnotation.AFTER_NEW_YEAR);
        put(year.epiphany, SundayAnnotation.EPIPHANY);
    }

    private void initializeMapAfterEpiphany() {
        int day = Algorithms.getSundayAfterExclusive(year.epiphany).get(Calendar.DAY_OF_YEAR);
        @SundayAnnotation.Sunday String[] sundays = new String[] {
                SundayAnnotation.EPIPHANY_I,
                SundayAnnotation.EPIPHANY_II,
                SundayAnnotation.EPIPHANY_III,
                SundayAnnotation.EPIPHANY_IV,
                SundayAnnotation.EPIPHANY_V,
                SundayAnnotation.EPIPHANY_VI,
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
        put(day - 49, SundayAnnotation.ESTOMIHI);
        put(day - 46, SundayAnnotation.ASH_WEDNESDAY);
        put(day - 42, SundayAnnotation.INVOCABIT);
        put(day - 35, SundayAnnotation.REMINISCERE);
        put(day - 28, SundayAnnotation.OCULI);
        put(day - 21, SundayAnnotation.LAETARE);
        put(day - 14, SundayAnnotation.JUDICA);
        put(day - 7, SundayAnnotation.PALMARUM);
        put(day - 2, SundayAnnotation.GOOD_FRIDAY);
        put(day, SundayAnnotation.EASTER_SUNDAY);
        put(day + 1, SundayAnnotation.EASTER_MONDAY);
        put(day + 2, SundayAnnotation.EASTER_TUESDAY);
        put(day + 7, SundayAnnotation.QUASIMODOGENITI);
        put(day + 14, SundayAnnotation.MISERICORDIAS);
        put(day + 21, SundayAnnotation.JUBILATE);
        put(day + 28, SundayAnnotation.CANTATE);
        put(day + 35, SundayAnnotation.ROGATE);
        put(day + 39, SundayAnnotation.ASCENSION);
        put(day + 42, SundayAnnotation.EXAUDI);
        put(day + 49, SundayAnnotation.PENTECOST_SUNDAY);
        put(day + 50, SundayAnnotation.PENTECOST_MONDAY);
        put(day + 51, SundayAnnotation.PENTECOST_TUESDAY);
        put(day + 56, SundayAnnotation.TRINITY);
    }

    private void initializeMapAfterTrinity() {
        int day = Algorithms.getSundayAfterExclusive(year.trinity).get(Calendar.DAY_OF_YEAR);
        @SundayAnnotation.Sunday String[] sundays = new String[] {
                SundayAnnotation.TRINITY_I,
                SundayAnnotation.TRINITY_II,
                SundayAnnotation.TRINITY_III,
                SundayAnnotation.TRINITY_IV,
                SundayAnnotation.TRINITY_V,
                SundayAnnotation.TRINITY_VI,
                SundayAnnotation.TRINITY_VII,
                SundayAnnotation.TRINITY_VIII,
                SundayAnnotation.TRINITY_IX,
                SundayAnnotation.TRINITY_X,
                SundayAnnotation.TRINITY_XI,
                SundayAnnotation.TRINITY_XII,
                SundayAnnotation.TRINITY_XIII,
                SundayAnnotation.TRINITY_XIV,
                SundayAnnotation.TRINITY_XV,
                SundayAnnotation.TRINITY_XVI,
                SundayAnnotation.TRINITY_XVII,
                SundayAnnotation.TRINITY_XVIII,
                SundayAnnotation.TRINITY_XIX,
                SundayAnnotation.TRINITY_XX,
                SundayAnnotation.TRINITY_XXI,
                SundayAnnotation.TRINITY_XXII,
                SundayAnnotation.TRINITY_XXIII,
                SundayAnnotation.TRINITY_XXIV,
                SundayAnnotation.TRINITY_XXV,
                SundayAnnotation.TRINITY_XXVI,
                SundayAnnotation.TRINITY_XXVII,
        };
        for (int i=0; i < 27; i++) {
            put(day, sundays[i]);
            day += 7;
        }
    }

    private void initializeMapAdvent() {
        int day = year.advent.get(Calendar.DAY_OF_YEAR);
        put(day, SundayAnnotation.ADVENT_I);
        put(day + 7, SundayAnnotation.ADVENT_II);
        put(day + 14, SundayAnnotation.ADVENT_III);
        put(day + 21, SundayAnnotation.ADVENT_IV);
    }

    private void initializeMapSundayAfterChristmas() {
        put(Algorithms.getSundayAfterExclusive(year.christmas), SundayAnnotation.AFTER_CHRISTMAS);
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

