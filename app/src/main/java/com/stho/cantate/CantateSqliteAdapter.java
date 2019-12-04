package com.stho.cantate;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class CantateSqliteAdapter {

    private final static String SELECT_ALL_CANTATAS =
            "SELECT id, bwv, title, volume, instrumentation, date, town, link, authors, occasion FROM Cantate ORDER BY id";

    private final static String SELECT_TRACKS_FOR_CANTATE =
            "SELECT no, title, form, lyrics, voices, instrumentation FROM Track WHERE cantateId=? ORDER BY no";

    private final static String SELECT_REMARKS_FOR_CANTATE =
            "SELECT remark FROM REMARK WHERE cantateId=?";

    private final static String SEARCH_TRACKS_FOR_QUERY =
            "SELECT Cantate.bwv, Cantate.title, Track.no, Track.title, Track.form, Track.voices, Track.instrumentation FROM Cantate INNER JOIN Track ON Track.cantateId = Cantate.id WHERE {QUERY} ORDER BY Cantate.bwv, Track.no LIMIT 50";

    private final static String SEARCH_TRACKS_LYRICS_FILTER =
            "Track.id IN (SELECT id FROM fts_Tracks WHERE fts_Tracks MATCH ?)";

    private final static String SEARCH_TRACKS_VOICES_FILTER =
            "Track.voices LIKE ?";

    private final static String SEARCH_TRACKS_INSTRUMENTATION_FILTER =
            "Track.instrumentation LIKE ?";

    private final static String SEARCH_TRACKS_BWV_FILTER =
            "Track.cantateId IN (SELECT id FROM Cantate WHERE bwv=?)";

    private final SQLiteDatabase db;

    public CantateSqliteAdapter(SQLiteDatabase db) {
        this.db = db;
    }

    void fetchCantatas(Cantatas cantatas) {
        Cursor cursor = db.rawQuery(SELECT_ALL_CANTATAS, null);
        if (cursor.moveToFirst()) {
            do {
                String bwv = getString(cursor, 1);
                Cantate cantate = cantatas.getCantate(bwv);
                cantate.setId(getInt(cursor, 0));
                cantate.setTitle(getString(cursor, 2));
                cantate.setVolume(getString(cursor, 3));
                cantate.setInstrumentation(getString(cursor, 4));
                cantate.setOriginalDate(getString(cursor, 5));
                cantate.setTown(getString(cursor, 6));
                cantate.setLink(getString(cursor, 7));
                cantate.setAuthors(getString(cursor, 8));
                cantate.setOccasion(getString(cursor, 9));
            }
            while (cursor.moveToNext());
        }
    }

    void fetchTracks(Cantate cantate) {
        Cursor cursor = db.rawQuery(SELECT_TRACKS_FOR_CANTATE, new String[]{Integer.toString(cantate.getId())});
        if (cursor.moveToFirst()) {
            do {
                int no = getInt(cursor, 0);
                Track track = cantate.getTrack(no);
                track.setTitle(getString(cursor, 1));
                track.setForm(getString(cursor, 2));
                track.setLyrics(getString(cursor, 3));
                track.setVoices(getString(cursor, 4));
                track.setInstrumentation(getString(cursor, 5));
            }
            while (cursor.moveToNext());
        }
    }

    void fetchRemarks(Cantate cantate) {
        Cursor cursor = db.rawQuery(SELECT_REMARKS_FOR_CANTATE, new String[]{Integer.toString(cantate.getId())});
        if (cursor.moveToFirst()) {
            do {
                cantate.addRemark(getString(cursor, 0));
            }
            while (cursor.moveToNext());
        }
    }

    private static final String _AND_ = " AND ";
    private static final String QUERY_PARAMETER = "{QUERY}";

    public ArrayList<SearchTrackResult> searchTracks(String lyricsFilter, String voicesFilter, String instrumentationFilter, String bwvFilter) {
        StringBuilder query = new StringBuilder();
        ArrayList<String> parameters = new ArrayList<>();
        if (lyricsFilter != null && lyricsFilter.length() > 0) {
            if (query.length() > 0) {
                query.append(_AND_);
            }
            query.append(SEARCH_TRACKS_LYRICS_FILTER);
            parameters.add(lyricsFilter + "*");
        }
        if (voicesFilter != null && voicesFilter.length() > 0) {
            if (query.length() > 0) {
                query.append(_AND_);
            }
            query.append(SEARCH_TRACKS_VOICES_FILTER);
            parameters.add("%" + voicesFilter + "%");
        }
        if (instrumentationFilter != null && instrumentationFilter.length() > 0) {
            if (query.length() > 0) {
                query.append(_AND_);
            }
            query.append(SEARCH_TRACKS_INSTRUMENTATION_FILTER);
            parameters.add("%" + instrumentationFilter + "%");
        }
        if (bwvFilter != null && bwvFilter.length() > 0) {
            if (query.length() > 0) {
                query.append(_AND_);
            }
            query.append(SEARCH_TRACKS_BWV_FILTER);
            parameters.add(bwvFilter);
        }

        if (query.length() > 0) {
            String sql = SEARCH_TRACKS_FOR_QUERY.replace(QUERY_PARAMETER, query.toString());
            return searchTracks(sql, parameters.toArray(new String[0]));
        }
        return null;
    }

    private static final int MAX_SEARCH_RESULTS = 33;

    private ArrayList<SearchTrackResult> searchTracks(String query, String[] parameters) {
        ArrayList<SearchTrackResult> tracks = new ArrayList<>();
        Cursor cursor = db.rawQuery(query, parameters);
        if (cursor.moveToFirst()) {
            do {
                tracks.add(new SearchTrackResult(
                        getString(cursor, 0),
                        getString(cursor, 1),
                        getInt(cursor, 2),
                        getString(cursor, 3),
                        getString(cursor, 4),
                        getString(cursor, 5),
                        getString(cursor, 6)));

                if (tracks.size() == MAX_SEARCH_RESULTS) {
                    tracks.add(new SearchTrackResult("...", "", 0, "", "...", "", ""));
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        return tracks;
    }

    private String getString(Cursor cursor, int columnIndex) {
        return getString(cursor, columnIndex, null);
    }

    private String getString(Cursor cursor, int columnIndex, String defaultValue) {
        if (cursor.isNull(columnIndex))
            return defaultValue;
        else
            return cursor.getString(columnIndex);
    }

    private int getInt(Cursor cursor, int columnIndex) {
        return getInt(cursor, columnIndex, 0);
    }

    private int getInt(Cursor cursor, int columnIndex, int defaultValue) {
        if (cursor.isNull(columnIndex))
            return defaultValue;
        else
            return cursor.getInt(columnIndex);
    }
}

