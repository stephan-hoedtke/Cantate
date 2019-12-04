package com.stho.cantate;

import android.content.res.XmlResourceParser;
import android.database.sqlite.SQLiteDatabase;
import android.util.SparseArray;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

class Data {

    private final Cantatas cantatas = new Cantatas();
    private final SparseArray<EvangelicSunday> evangelic = new SparseArray<>();
    private final SparseArray<CatholicDominica> catholic = new SparseArray<>();
    private final SparseArray<Year> years = new SparseArray<>(); // year --> Year

    Data() {
        // Empty
    }

    Data prepareCantatas(CantateSqliteHelper hlp) {
        try {
            SQLiteDatabase db = hlp.getReadableDatabase();
            CantateSqliteAdapter adapter = new CantateSqliteAdapter(db);
            adapter.fetchCantatas(cantatas);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Cannot read cantate from database", ex);
        }
        return this;
    }

    Cantate prepareCantate(CantateSqliteHelper hlp, String bwv) {
        Cantate cantate = cantatas.getCantate(bwv);
        if (!cantate.getIsReady()) {
            try {
                SQLiteDatabase db = hlp.getReadableDatabase();
                CantateSqliteAdapter adapter = new CantateSqliteAdapter(db);
                adapter.fetchTracks(cantate);
                adapter.fetchRemarks(cantate);
                cantate.setIsReady();
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new RuntimeException("Cannot read tracks or remarks from database", ex);
            }
        }
        return cantate;
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
                @EvangelicSundayAnnotation.Sunday int key = evangelicSunday.getKey();
                return cantatas.getCantatasFor(key);
            }
        }
        return null;
    }

    Cantate getCantate(String bwv) {
        return cantatas.getCantate(bwv);
    }

    EvangelicSunday getEvangelicSunday(@EvangelicSundayAnnotation.Sunday int key) {
        return evangelic.get(key);
    }
}

