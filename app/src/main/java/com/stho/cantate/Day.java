package com.stho.cantate;

import java.util.Calendar;

class Day {
    final Year year;
    final int dayInYear;
    final int position;

    Day(Year year, int dayInYear, int position) {
        this.year = year;
        this.dayInYear = dayInYear;
        this.position = position;
    }

    Calendar getDate() {
        Calendar date = Calendar.getInstance();
        date.set(Calendar.YEAR, year.year);
        date.set(Calendar.DAY_OF_YEAR, dayInYear);
        return date;
    }
}

