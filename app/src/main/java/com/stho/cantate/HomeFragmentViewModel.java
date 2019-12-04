package com.stho.cantate;

import android.content.res.XmlResourceParser;
import android.util.SparseArray;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class HomeFragmentViewModel extends ViewModel {

    private MainViewModel mainViewModel = null;
    private MutableLiveData<Day> dayLiveData = new MutableLiveData<>();
    private MutableLiveData<Year> yearLiveData = new MutableLiveData<>();
    private MutableLiveData<Sunday> nextSundayLiveData = new MutableLiveData<>();

    public HomeFragmentViewModel() {
        // cannot do anything if the main view model is not present yet
    }

    public void setMainViewModel(MainViewModel mainViewModel) {
        this.mainViewModel = mainViewModel;
    }

    public MainViewModel getMainViewModel() {
        return this.mainViewModel;
    }

    public LiveData<Sunday> getNextSundayLD() { return nextSundayLiveData; }
    public LiveData<ArrayList<Cantate>> getCantatasLD() {
        return Transformations.map(nextSundayLiveData, sunday -> mainViewModel.getCantatasFor(sunday));
    }

    /*
       To set the day in the Home Fragment. This method is called for quite a number of fragments next to each other.
       Do not update the position in the main viewmodel here!
     */
    public void setPosition(int position) {
        Day day = mainViewModel.getDay(position);
        Sunday sunday = day.year.sundays.get(day.dayInYear);
        dayLiveData.postValue(day);
        yearLiveData.postValue(day.year);
        nextSundayLiveData.postValue(sunday);
    }

    public int getPosition() {
        Day day = dayLiveData.getValue();
        return day != null ? day.position : 0;
    }

    /*
        To update the current position in the main viewmodel
     */
    public void setCurrentPosition(int position) {
        mainViewModel.setCurrentPosition(position);
    }
}

