package com.stho.cantate;

public class SearchTrackResult {

    public final String bwv;
    public final String title;
    public final int trackNo;
    public final String trackTitle;
    public final String trackForm;
    public final String trackVoices;
    public final String trackInstrumentation;

    SearchTrackResult(String bwv, String title, int trackNo, String trackTitle, String trackForm, String trackVoices, String trackInstrumentation) {
        this.bwv = bwv;
        this.title = title;
        this.trackNo = trackNo;
        this.trackTitle = trackTitle;
        this.trackForm = trackForm;
        this.trackVoices = trackVoices;
        this.trackInstrumentation = trackInstrumentation;
    }
}
