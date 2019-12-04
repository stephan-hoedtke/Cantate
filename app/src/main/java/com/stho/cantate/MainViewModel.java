package com.stho.cantate;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {

    private Data data = null;
    private Day reference = null;

    private final MutableLiveData<Integer> currentPositionLiveData = new MutableLiveData<>();

    public MainViewModel() {
        currentPositionLiveData.setValue(HomePagerAdapter.START_POSITION);
    }

    public LiveData<Integer> getCurrentPositionLD() { return currentPositionLiveData; }

    public int getCurrentPosition() {
        return currentPositionLiveData.getValue();
    }

    public void setCurrentPosition(int position) {
        currentPositionLiveData.postValue(position);
    }

    boolean isNotPrepared() {
        return (data == null);
    }

    void prepare(Data data) {
        this.data = data;
    }

    public Cantate prepareCantate(CantateSqliteHelper hlp, String bwv) {
        return data.prepareCantate(hlp, bwv);
    }

    Day getDay(int position) {
        if (reference == null) {
            reference = data.getToday();
        }
        while (position > reference.position) {
            reference = data.next(reference);
        }
        while (position < reference.position) {
            reference = data.previous(reference);
        }
        return reference;
    }

    ArrayList<Cantate> getCantatasFor(Sunday sunday) {
        if (data != null) {
            return data.getCantatasFor(sunday);
        }
        return null;
    }

    Data getData() {
        return data;
    }

}

