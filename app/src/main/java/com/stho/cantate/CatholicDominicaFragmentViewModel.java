package com.stho.cantate;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.stho.cantate.Cantate;
import com.stho.cantate.Day;
import com.stho.cantate.MainViewModel;
import com.stho.cantate.Sunday;
import com.stho.cantate.Year;

import java.util.ArrayList;

public class CatholicDominicaFragmentViewModel extends ViewModel {

    private MainViewModel mainViewModel = null;
    private MutableLiveData<Year> yearLiveData = new MutableLiveData<>();
    private MutableLiveData<Sunday> nextSundayLiveData = new MutableLiveData<>();

    public CatholicDominicaFragmentViewModel() {
        // cannot do anything if the main view model is not present yet
    }

    public void setMainViewModel(MainViewModel mainViewModel) {
        this.mainViewModel = mainViewModel;
    }

    public LiveData<Year> getYearLD() { return yearLiveData; }
    public LiveData<Sunday> getNextSundayLD() { return nextSundayLiveData; }

    public void setPosition(int position) {
        Day day = mainViewModel.getDay(position);
        Sunday sunday = day.year.sundays.get(day.dayInYear);
        yearLiveData.postValue(day.year);
        nextSundayLiveData.postValue(sunday);
    }
}

