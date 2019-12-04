package com.stho.cantate;

import android.util.SparseIntArray;

import java.util.Calendar;

class EvangelicYear {

    private final Year year;
    private final SparseIntArray mapSundayByDayInYear = new SparseIntArray();

    static SparseIntArray getMap(Year year) {
        EvangelicYear calculator = new EvangelicYear(year);
        return calculator.mapSundayByDayInYear;
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
        put(year.newYear, EvangelicSundayAnnotation.NEW_YEAR);
        put(Algorithms.getSundayAfterExclusive(year.newYear), EvangelicSundayAnnotation.AFTER_NEW_YEAR);
        put(year.epiphany, EvangelicSundayAnnotation.EPIPHANY);
    }

    private void initializeMapAfterEpiphany() {
        int day = Algorithms.getSundayAfterExclusive(year.epiphany).get(Calendar.DAY_OF_YEAR);
        @EvangelicSundayAnnotation.Sunday int[] sundays = new int[] {
                EvangelicSundayAnnotation.EPIPHANY_I,
                EvangelicSundayAnnotation.EPIPHANY_II,
                EvangelicSundayAnnotation.EPIPHANY_III,
                EvangelicSundayAnnotation.EPIPHANY_IV,
                EvangelicSundayAnnotation.EPIPHANY_V,
                EvangelicSundayAnnotation.EPIPHANY_VI,
        };
        for (int i=0; i < 6; i++) {
            put(day, sundays[i]);
            day += 7;
        }
    }

    private void initializeMapEaster() {
        int day = year.easter.get(Calendar.DAY_OF_YEAR);
        put(day - 63, EvangelicSundayAnnotation.SEPTUAGESIMA);
        put(day - 56, EvangelicSundayAnnotation.SEXAGESIMA);
        put(day - 49, EvangelicSundayAnnotation.ESTOMIHI);
        put(day - 46, EvangelicSundayAnnotation.ASH_WEDNESDAY);
        put(day - 42, EvangelicSundayAnnotation.INVOCABIT);
        put(day - 35, EvangelicSundayAnnotation.REMINISCERE);
        put(day - 28, EvangelicSundayAnnotation.OCULI);
        put(day - 21, EvangelicSundayAnnotation.LAETARE);
        put(day - 14, EvangelicSundayAnnotation.JUDICA);
        put(day - 7, EvangelicSundayAnnotation.PALMARUM);
        put(day - 2, EvangelicSundayAnnotation.GOOD_FRIDAY);
        put(day, EvangelicSundayAnnotation.EASTER_SUNDAY);
        put(day + 1, EvangelicSundayAnnotation.EASTER_MONDAY);
        put(day + 2, EvangelicSundayAnnotation.EASTER_TUESDAY);
        put(day + 7, EvangelicSundayAnnotation.QUASIMODOGENITI);
        put(day + 14, EvangelicSundayAnnotation.MISERICORDIAS);
        put(day + 21, EvangelicSundayAnnotation.JUBILATE);
        put(day + 28, EvangelicSundayAnnotation.CANTATE);
        put(day + 35, EvangelicSundayAnnotation.ROGATE);
        put(day + 39, EvangelicSundayAnnotation.ASCENSION);
        put(day + 42, EvangelicSundayAnnotation.EXAUDI);
        put(day + 49, EvangelicSundayAnnotation.PENTECOST_SUNDAY);
        put(day + 50, EvangelicSundayAnnotation.PENTECOST_MONDAY);
        put(day + 51, EvangelicSundayAnnotation.PENTECOST_TUESDAY);
        put(day + 56, EvangelicSundayAnnotation.TRINITY);
    }

    private void initializeMapAfterTrinity() {
        int day = Algorithms.getSundayAfterExclusive(year.trinity).get(Calendar.DAY_OF_YEAR);
        @EvangelicSundayAnnotation.Sunday int[] sundays = new int[] {
                EvangelicSundayAnnotation.TRINITY_I,
                EvangelicSundayAnnotation.TRINITY_II,
                EvangelicSundayAnnotation.TRINITY_III,
                EvangelicSundayAnnotation.TRINITY_IV,
                EvangelicSundayAnnotation.TRINITY_V,
                EvangelicSundayAnnotation.TRINITY_VI,
                EvangelicSundayAnnotation.TRINITY_VII,
                EvangelicSundayAnnotation.TRINITY_VIII,
                EvangelicSundayAnnotation.TRINITY_IX,
                EvangelicSundayAnnotation.TRINITY_X,
                EvangelicSundayAnnotation.TRINITY_XI,
                EvangelicSundayAnnotation.TRINITY_XII,
                EvangelicSundayAnnotation.TRINITY_XIII,
                EvangelicSundayAnnotation.TRINITY_XIV,
                EvangelicSundayAnnotation.TRINITY_XV,
                EvangelicSundayAnnotation.TRINITY_XVI,
                EvangelicSundayAnnotation.TRINITY_XVII,
                EvangelicSundayAnnotation.TRINITY_XVIII,
                EvangelicSundayAnnotation.TRINITY_XIX,
                EvangelicSundayAnnotation.TRINITY_XX,
                EvangelicSundayAnnotation.TRINITY_XXI,
                EvangelicSundayAnnotation.TRINITY_XXII,
                EvangelicSundayAnnotation.TRINITY_XXIII,
                EvangelicSundayAnnotation.TRINITY_XXIV,
                EvangelicSundayAnnotation.TRINITY_XXV,
                EvangelicSundayAnnotation.TRINITY_XXVI,
                EvangelicSundayAnnotation.TRINITY_XXVII,
        };
        for (int i=0; i < 27; i++) {
            put(day, sundays[i]);
            day += 7;
        }
    }

    private void initializeMapAdvent() {
        int day = year.advent.get(Calendar.DAY_OF_YEAR);
        put(day, EvangelicSundayAnnotation.ADVENT_I);
        put(day + 7, EvangelicSundayAnnotation.ADVENT_II);
        put(day + 14, EvangelicSundayAnnotation.ADVENT_III);
        put(day + 21, EvangelicSundayAnnotation.ADVENT_IV);
    }

    private void initializeMapSundayAfterChristmas() {
        put(Algorithms.getSundayAfterExclusive(year.christmas), EvangelicSundayAnnotation.AFTER_CHRISTMAS);
    }

    private void initializeMapChristmas() {
        int day = year.christmas.get(Calendar.DAY_OF_YEAR);
        put(day, EvangelicSundayAnnotation.CHRISTMAS_DAY_1);
        put(day + 1, EvangelicSundayAnnotation.CHRISTMAS_DAY_2);
        put(day + 2, EvangelicSundayAnnotation.CHRISTMAS_DAY_3);
    }

    private void initializeMapOthers() {
        put(year.johannis, EvangelicSundayAnnotation.JOHANNIS);
        put(year.michaelis, EvangelicSundayAnnotation.MICHAELIS);
        put(year.reformation, EvangelicSundayAnnotation.REFORMATION);
    }

    private void put(Calendar date, @EvangelicSundayAnnotation.Sunday int sunday) {
        mapSundayByDayInYear.put(date.get(Calendar.DAY_OF_YEAR), sunday);
    }

    private void put(int day, @EvangelicSundayAnnotation.Sunday int sunday) {
        mapSundayByDayInYear.put(day, sunday);
    }

}

