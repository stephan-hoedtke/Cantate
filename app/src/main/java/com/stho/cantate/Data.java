package com.stho.cantate;

import android.content.res.XmlResourceParser;
import android.util.SparseArray;
import android.util.SparseIntArray;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

class Data {

    private final Cantatas cantatas = new Cantatas();
    private final HashMap<String, EvangelicSunday> evangelic = new HashMap<>();
    private final HashMap<String, CatholicDominica> catholic = new HashMap<>();
    private final SparseArray<Year> years = new SparseArray<>(); // year --> Year

    Data() {
        // Empty
    }

    Data prepareCantatas(XmlResourceParser xrp)  {
        try {
            new CantatasXmlParser(cantatas).process(xrp);
        } catch (IOException | XmlPullParserException e) {
            e.printStackTrace();
        }
        return this;
    }

    Data prepareCatholic(XmlResourceParser xrp) {
        try {
            new CatholicXmlParser(catholic).process(xrp);
        } catch (IOException | XmlPullParserException e) {
            e.printStackTrace();
        }
        return this;
    }

    Data prepareEvangelic(XmlResourceParser xrp) {
        try {
            new EvangelicXmlParser(evangelic).process(xrp);
        } catch (IOException | XmlPullParserException e) {
            e.printStackTrace();
        }
        return this;
    }

    Day getToday() {
        Calendar date = Calendar.getInstance();
        Year year = getYear(date.get(Calendar.YEAR));
        int dayInYear = year.getNextMusicDayInYear(date.get(Calendar.DAY_OF_YEAR));
        return new Day(year, dayInYear, HomePagerAdapter.START_POSITION);
    }

    Day next(Day day) {
        Year year = day.year;
        int dayInYear = year.getNextMusicDayInYear(day.dayInYear + 1);
        if (dayInYear == Year.KEY_NOT_FOUND) {
            year = getYear(year.year + 1);
            dayInYear = year.getNextMusicDayInYear(0);
        }
        return new Day(year, dayInYear, day.position + 1);
    }

    Day previous(Day day) {
        Year year = day.year;
        int dayInYear = year.getPreviousMusicDayInYear(day.dayInYear - 1);
        if (dayInYear == Year.KEY_NOT_FOUND) {
            year = getYear(year.year - 1);
            dayInYear = year.getPreviousMusicDayInYear(367);
        }
        return new Day(year, dayInYear, day.position - 1);
    }

    private Year getYear(int year) {
        Year value = years.get(year);
        if (value == null) {
            value = Year.fromYear( evangelic, catholic, year);
            years.put(year, value);
        }
        return value;
    }

    ArrayList<Cantate> getCantatasFor(Sunday sunday) {
        if (sunday != null) {
            EvangelicSunday evangelicSunday = sunday.getEvangelicSunday();
            if (evangelicSunday != null) {
                @SundayAnnotation.Sunday String key = evangelicSunday.getKey();
                return cantatas.getCantatasFor(key);
            }
        }
        return null;
    }
}

