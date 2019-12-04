package com.stho.cantate;

import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Sunday {
    private final int year;
    private final int dayOfYear;
    private final Calendar date;
    private EvangelicSunday evangelicSunday;
    private CatholicDominica catholicDominica;
    private @CatholicLiturgicalYearAnnotation.Year int catholicLiturgicalYear;

    Sunday(int year, int dayOfYear, @CatholicLiturgicalYearAnnotation.Year int catholicLiturgicalYear) {
        this.year = year;
        this.dayOfYear = dayOfYear;
        this.date = Algorithms.getDate(year, dayOfYear);
        this.catholicLiturgicalYear = catholicLiturgicalYear;
    }

    int getYear() {
        return year;
    }

    int getDayOfYear() {
        return dayOfYear;
    }

    public String getDateAsString() {
        return Formatter.toString(date);
    }

    public String getName() {
        if (evangelicSunday != null)
            return evangelicSunday.getName();

        if (catholicDominica != null)
            return  catholicDominica.getFriendlyName();

        return null;
    }


    public EvangelicSunday getEvangelicSunday() {
        return evangelicSunday;
    }

    public CatholicDominica getCatholicDominica() {
        return catholicDominica;
    }

    public @CatholicLiturgicalYearAnnotation.Year int getCatholicLiturgicalYear() { return catholicLiturgicalYear; }

    public String getCatholicLiturgicalYearAsString() { return CatholicLiturgicalYearAnnotation.toString(catholicLiturgicalYear); }

    void setEvangelicSunday(EvangelicSunday evangelicSunday) {
        this.evangelicSunday = evangelicSunday;
    }

    void setCatholicDominica(CatholicDominica catholicDominica) {
        this.catholicDominica = catholicDominica;
    }
}
