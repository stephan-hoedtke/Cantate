package com.stho.cantate;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class CantateFragmentViewModel extends ViewModel {

    private MainViewModel mainViewModel = null;
    private MutableLiveData<Cantate> cantateLiveData = new MutableLiveData<>();

    public CantateFragmentViewModel() {
        // cannot do anything if the main view model is not present yet
    }

    public void setMainViewModel(MainViewModel mainViewModel) {
        this.mainViewModel = mainViewModel;
    }

    public LiveData<Cantate> getCantateLD() { return cantateLiveData; }
    public LiveData<EvangelicSunday> getEvangelicSundayLD() {
        return Transformations.map(cantateLiveData, cantate -> mainViewModel.getData().getEvangelicSunday(cantate.getOccasion())); }

    public void setCantate(Cantate cantate) {
        cantateLiveData.postValue(cantate);
    }
}

