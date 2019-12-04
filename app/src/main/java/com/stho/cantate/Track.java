package com.stho.cantate;

public class Track {
    private final int no;
    private String title;
    private String form;
    private String lyrics;
    private String voices;
    private String instrumentation;

    Track(int no) {
        this.no = no;
    }

    public int getNo() { return no; }
    public String getTitle() { return title == null || title.length() == 0 ? lyrics : title; }
    public String getForm() { return form; }
    public String getLyrics() { return lyrics == null || lyrics.length() == 0 ? title : lyrics; }
    public String getVoices() { return voices; }
    public String getInstrumentation() { return instrumentation; }

    void setTitle(String title) { this.title = title ;}
    void setForm(String form) { this.form = form; }
    void setLyrics(String lyrics) { this.lyrics = lyrics; }
    void setVoices(String voices) { this.voices = voices; }
    void setInstrumentation(String instrumentation) { this.instrumentation = instrumentation; }
}
