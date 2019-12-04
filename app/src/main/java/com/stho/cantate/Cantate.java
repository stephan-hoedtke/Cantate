package com.stho.cantate;

import java.util.Calendar;
import java.util.ArrayList;

public class Cantate {
    private final Cantatas cantatas;
    private int id;
    private final String bwv;
    private String title;
    private String volume;
    private String instrumentation;
    private ArrayList<Track> tracks = new ArrayList<>();
    private String originalDate;
    private String town;
    private String link;
    private String authors;
    private ArrayList<String> remarks = new ArrayList<>();
    private @EvangelicSundayAnnotation.Sunday int occasion;
    private boolean isReady = false;

    Cantate(Cantatas cantatas, String bwv) {
        this.cantatas = cantatas;
        this.bwv = bwv;
    }

    public int getId() { return id; }
    public String getBWV() { return bwv; }
    public String getTitle() {
        return title;
    }
    public String getVolume() { return volume; }
    public String getInstrumentation() { return instrumentation; }
    public ArrayList<Track> getTracks() { return tracks; }
    public String getOriginalDate() { return originalDate; }
    public String getTown() { return town; }
    public String getLink() { return link; }
    public String getAuthors() { return authors; }
    public ArrayList<String> getRemarks() { return remarks; }
    public @EvangelicSundayAnnotation.Sunday int getOccasion() { return occasion; }
    public boolean getIsReady() { return isReady; }

    void setId(int id) { this.id = id; }
    void setVolume(String volume) { this.volume = volume; }
    void setInstrumentation(String instrumentation) { this.instrumentation = instrumentation; }

    Track getTrack(int no) {
        for (Track track : tracks) {
            if (track.getNo() == no) {
                return track;
            }
        }
        return addTrack(new Track(no));
    }

    private Track addTrack(Track track) {
        this.tracks.add(track);
        this.isReady = true;
        return track;
    }

    void setOriginalDate(String dateString) {
        this.originalDate = dateString;
        if (dateString != null) {
            Calendar date = Formatter.parseString(dateString);
            if (date != null) {
                this.originalDate = Formatter.toString(date);
            }
        }
    }
    void setTown(String town) { this.town = town; }
    void setLink(String link) { this.link = link; }
    void setAuthors(String authors) { this.authors = authors; }
    void setTitle(String title) { this.title = title; }
    void addRemark(String remark) { this.remarks.add(remark); }
    void setOccasion(String occasion) {
        if (occasion == null || occasion.isEmpty()) {
            setOccasion(EvangelicSundayAnnotation.UNKNOWN);
        }
        else {
            for (String token : occasion.split(";")) {
                setOccasion(EvangelicSundayAnnotation.fromName(token));
            }
        }
    }
    private void setOccasion(@EvangelicSundayAnnotation.Sunday int occasion) {
        this.occasion = occasion;
        this.cantatas.setOccasion(occasion, this.bwv);
    }

    void setIsReady() {
        this.isReady = true;
    }
}


