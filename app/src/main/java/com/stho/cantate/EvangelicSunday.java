package com.stho.cantate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class EvangelicSunday {

    /*
        https://en.wikipedia.org/wiki/Bach_cantata
     */

    private final @SundayAnnotation.Sunday String key;
    private final String name;
    private final ArrayList<String> links = new ArrayList<>();

    @SundayAnnotation.Sunday String getKey() { return key; }

    public String getName() {
        return name;
    }

    public ArrayList<String> getLinks() { return links; }

    public EvangelicSunday setLink(String link) { this.links.add(link); return this; }

    EvangelicSunday(@SundayAnnotation.Sunday String key, String name) {
        this.key = key;
        this.name = name;
    }
}
