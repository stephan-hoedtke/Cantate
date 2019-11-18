package com.stho.cantate;

import java.text.Normalizer;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;

public class Cantate {
    private final String bwv;
    private String title;
    private String volume;
    private ArrayList<String> tracks = new ArrayList<>();
    private String originalDate;
    private String town;
    private String link;
    private ArrayList<String> remarks = new ArrayList<>();
    private @SundayAnnotation.Sunday String occasion;

    Cantate(String bwv) {
        this.bwv = bwv;
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
    public ArrayList<String> getRemarks() { return remarks; }
    public @SundayAnnotation.Sunday String getOccasion() { return occasion; }

    void setVolume(String volume) { this.volume = volume; }
    void addTrack(String track) { this.tracks.add(track); }
    void setOriginalDate(String dateString) {
        Calendar date = Formatter.parseString(dateString);
        if (date != null) {
            this.originalDate = Formatter.toString(date);
        }
        else {
            this.originalDate = dateString;
        }
    }
    void setTown(String town) { this.town = town; }
    public void setLink(String link) { this.link = link; }
    void setTitle(String title) { this.title = title; }
    void addRemark(String remark) { this.remarks.add(remark); }
    void setOccasion(@SundayAnnotation.Sunday String occasion) { this.occasion = occasion; }
}
