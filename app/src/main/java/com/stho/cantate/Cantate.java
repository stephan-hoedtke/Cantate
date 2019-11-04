package com.stho.cantate;

import java.util.ArrayList;
import java.util.Calendar;

public class Cantate {
    private final String bwv;
    private String title;
    private String volume;
    private ArrayList<String> tracks = new ArrayList<>();
    private String originalDate;
    private String town;
    private String link;

    Cantate(String bwv) {
        this.bwv = bwv;
    }

    Cantate(String bwv, String title) {
        this.bwv = bwv;
        this.title = title;
    }



    public String getBWV() { return bwv; }
    public String getTitle() {
        return title;
    }
    public String getVolume() { return volume; }
    public ArrayList<String> getTracks() { return tracks; }
    public String getOriginalDate() { return originalDate; }
    public String getTown() { return town; }
    public String getLink() { return link; }

    void setVolume(String volume) {
        this.volume = volume;
    }

    void addTrack(String track) {
        this.tracks.add(track);
    }

    void setOriginalDate(String date) { this.originalDate = date; }

    void setTown(String town) { this.town = town; }

    public void setLink(String link) { this.link = link; }

    void setTitle(String title) { this.title = title; }
}
