package com.stho.cantate.ui.search;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.stho.cantate.SearchTrackResult;

import java.util.ArrayList;

public class SearchViewModel extends ViewModel {

    private final MutableLiveData<String> lyricsFilterLiveData = new MutableLiveData<>();
    private final MutableLiveData<String> voicesFilterLiveData = new MutableLiveData<>();
    private final MutableLiveData<String> instrumentationFilterLiveData = new MutableLiveData<>();
    private final MutableLiveData<String> bwvFilterLiveData = new MutableLiveData<>();
    private final MutableLiveData<ArrayList<SearchTrackResult>> searchTrackResultLiveData = new MutableLiveData<>();

    public SearchViewModel() {
        reset();
    }

    private void reset() {
        lyricsFilterLiveData.setValue("");
        voicesFilterLiveData.setValue("");
        bwvFilterLiveData.setValue("");
        instrumentationFilterLiveData.setValue("");
        searchTrackResultLiveData.setValue(null);
    }

    LiveData<String> getLyricsFilterLD() {
        return lyricsFilterLiveData;
    }
    LiveData<String> getVoicesFilterLD() { return voicesFilterLiveData; }
    LiveData<String> getInstrumentationFilterLD() { return instrumentationFilterLiveData; }
    LiveData<String> getBwvFilterLD() { return bwvFilterLiveData; }
    LiveData<ArrayList<SearchTrackResult>> getSearchTrackResultLD() { return searchTrackResultLiveData; }

    public String getLyricsFilter() { return lyricsFilterLiveData.getValue(); }
    public String getVoicesFilter() { return voicesFilterLiveData.getValue(); }
    public String getInstrumentationFilter() { return instrumentationFilterLiveData.getValue(); }
    public String getBwvFilter() { return bwvFilterLiveData.getValue(); }
    ArrayList<SearchTrackResult> getSearchTrackResult() { return searchTrackResultLiveData.getValue(); }

    void setLyricsFilter(String filter) { lyricsFilterLiveData.setValue(filter); }
    void setVoicesFilter(String filter) { voicesFilterLiveData.setValue(filter); }
    void setInstrumentationFilter(String filter) { instrumentationFilterLiveData.setValue(filter); }
    void setBwvFilter(String filter) { bwvFilterLiveData.setValue(filter); }
    void setSearchTrackResult(ArrayList<SearchTrackResult> searchTrackResults) { searchTrackResultLiveData.setValue(searchTrackResults); }


}