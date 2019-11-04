package com.stho.cantate;

import java.util.ArrayList;
import java.util.HashMap;

public class CatholicDominica {

    private final @DominicaAnnotation.Dominica String key;
    private final String name;
    private final String tempus;
    private final ArrayList<String> links = new ArrayList<>();
    private final HashMap<String, String> introitus = new HashMap<>();
    private final HashMap<String, String> communio = new HashMap<>();
    private String friendlyName;

    @DominicaAnnotation.Dominica String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getTempus() { return tempus; }

    public String getIntroitus(@CatholicLiturgicalYearAnnotation.Year String liturgicalYear) {
        if (introitus.containsKey(liturgicalYear)) {
            return introitus.get(liturgicalYear);
        }
        return introitus.get(CatholicLiturgicalYearAnnotation.ALL);
    }

    public String getCommunio(@CatholicLiturgicalYearAnnotation.Year String liturgicalYear) {
        if (communio.containsKey(liturgicalYear)) {
            return introitus.get(liturgicalYear);
        }
        return communio.get(CatholicLiturgicalYearAnnotation.ALL);
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

    void setIntroitus(String introitus) {
        setIntroitus(introitus, CatholicLiturgicalYearAnnotation.ALL);
    }

    void setIntroitus(String introitus, @CatholicLiturgicalYearAnnotation.Year String liturgicalYear) {
        if (liturgicalYear == null || liturgicalYear.isEmpty()) {
            liturgicalYear = CatholicLiturgicalYearAnnotation.ALL;
        }
        this.introitus.put(liturgicalYear, introitus);
    }

    void setCommunio(String communio) {
        setCommunio(communio, CatholicLiturgicalYearAnnotation.ALL);
    }

    void setCommunio(String communio, @CatholicLiturgicalYearAnnotation.Year String liturgicalYear) {
        if (liturgicalYear == null || liturgicalYear.isEmpty()) {
            liturgicalYear = CatholicLiturgicalYearAnnotation.ALL;
        }
        this.communio.put(liturgicalYear, communio);
    }

    CatholicDominica(@DominicaAnnotation.Dominica String key, String name, String tempus) {
        this.key = key;
        this.name = name;
        this.tempus = tempus;
        this.friendlyName = null;
    }
}


