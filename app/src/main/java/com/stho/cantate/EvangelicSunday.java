package com.stho.cantate;

import java.util.ArrayList;

public class EvangelicSunday {

    /*
        https://en.wikipedia.org/wiki/Bach_cantata
     */

    private final @EvangelicSundayAnnotation.Sunday int key;
    private final String name;
    private final ArrayList<String> links = new ArrayList<>();

    @EvangelicSundayAnnotation.Sunday int getKey() { return key; }

    public String getName() {
        return name;
    }

    public ArrayList<String> getLinks() { return links; }

    public EvangelicSunday setLink(String link) { this.links.add(link); return this; }

    EvangelicSunday(@EvangelicSundayAnnotation.Sunday int key, String name) {
        this.key = key;
        this.name = name;
    }
}
