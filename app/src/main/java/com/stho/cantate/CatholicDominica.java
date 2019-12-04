package com.stho.cantate;

import android.util.Pair;
import android.util.SparseArray;

import java.util.ArrayList;
import java.util.HashMap;

public class CatholicDominica {

    private final @CatholicDominicaAnnotation.Dominica int key;
    private final String name;
    private final String tempus;
    private final ArrayList<String> links = new ArrayList<>();
    private final SparseArray<String> introitus = new SparseArray<>();
    private final SparseArray<String> communio = new SparseArray<>();
    private final ArrayList<Pair<String, String>> others = new ArrayList<>();
    private String friendlyName;

    @CatholicDominicaAnnotation.Dominica int getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getTempus() { return tempus; }

    public String getIntroitusAbbreviation(@CatholicLiturgicalYearAnnotation.Year int liturgicalYear) {
        String value = getIntroitus(liturgicalYear);
        if (value != null) {
            int x = value.indexOf('.');
            int y = value.indexOf('?');
            int z = value.indexOf(':');
            int pos = 0;
            if (x > 0)
                pos = (pos > 0) ? Math.min(pos, x) : x;
            if (y > 0)
                pos = (pos > 0) ? Math.min(pos, y) : y;
            if (z > 0)
                pos = (pos > 0) ? Math.min(pos, z) : z;
            if (pos > 10)
                value = value.substring(0, pos - 1).trim();
        }
        return value;
    }

    public boolean hasIntroitus() {
        return introitus.size() > 0;
    }

    public String getIntroitus(@CatholicLiturgicalYearAnnotation.Year int liturgicalYear) {
        String value = introitus.get(liturgicalYear);
        if (value == null) {
            value = introitus.get(CatholicLiturgicalYearAnnotation.ALL);
        }
        return value;
    }

    public boolean hasCommunio() {
        return communio.size() > 0;
    }

    public String getCommunio(@CatholicLiturgicalYearAnnotation.Year int liturgicalYear) {
        String value = introitus.get(liturgicalYear);
        if (value == null) {
            value = communio.get(CatholicLiturgicalYearAnnotation.ALL);
        }
        return value;
    }

    public boolean hasOthers() {
        return others.size() > 0;
    }

    private static final String EOL = "\n";

    public String getOthers() {
        StringBuilder sb = new StringBuilder();
        for (Pair<String, String> pair : others) {
            if (sb.length() > 0) {
                sb.append(EOL);
            }
            sb.append(pair.first);
            sb.append(EOL);
            sb.append(pair.second);
            sb.append(EOL);
        }
        return sb.toString();
    }

    public String getFriendlyName() { return (friendlyName != null) ? friendlyName : getName(); }

    ArrayList<String> getLinks() {
        return links;
    }

    void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    void setLink(String link) {
        this.links.add(link);
    }

    void setIntroitus(String introitus, String liturgicalYear) {
        if (liturgicalYear == null || liturgicalYear.isEmpty()) {
            setIntroitus(introitus, CatholicLiturgicalYearAnnotation.ALL);
        }
        else {
            for (String token : liturgicalYear.split(",")) {
                setIntroitus(introitus, CatholicLiturgicalYearAnnotation.fromName(token));
            }
        }
    }

    private void setIntroitus(String introitus, @CatholicLiturgicalYearAnnotation.Year int liturgicalYear) {
        this.introitus.put(liturgicalYear, introitus);
    }

    void setCommunio(String communio, String liturgicalYear) {
        if (liturgicalYear == null || liturgicalYear.isEmpty()) {
            setCommunio(communio, CatholicLiturgicalYearAnnotation.ALL);
        }
        else {
            for (String token : liturgicalYear.split(",")) {
                setCommunio(communio, CatholicLiturgicalYearAnnotation.fromName(token));
            }
        }
    }

    private void setCommunio(String communio, @CatholicLiturgicalYearAnnotation.Year int liturgicalYear) {
        this.communio.put(liturgicalYear, communio);
    }

    void setOthers(String type, String value) {
        this.others.add(new Pair<String, String>(type, value));
    }

    CatholicDominica(@CatholicDominicaAnnotation.Dominica int key, String name, String tempus) {
        this.key = key;
        this.name = name;
        this.tempus = tempus;
        this.friendlyName = null;
    }
}


