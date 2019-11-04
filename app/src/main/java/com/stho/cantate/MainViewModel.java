package com.stho.cantate;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.SparseArray;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

public class MainViewModel extends ViewModel {

    private Data data = null;
    private Day reference = null;

    public MainViewModel() {
    }

    boolean isNotPrepared() {
        return (data == null);
    }

    void prepare(Data data) {
        this.data = data;
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


}

