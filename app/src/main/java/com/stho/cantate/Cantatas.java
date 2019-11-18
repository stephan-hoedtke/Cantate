package com.stho.cantate;

import android.util.ArrayMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Cantatas {
    private HashMap<String, Cantate> cantatas = new HashMap<>();
    private HashMap<String, ArrayList<String>> lookupTable = new HashMap<>();

    Cantate getCantate(String bwv) {
        Cantate cantate = cantatas.get(bwv);
        if (cantate == null) {
            cantate = new Cantate(bwv);
            cantatas.put(bwv, cantate);
        }
        return cantate;
    }

    void setOccasion(@SundayAnnotation.Sunday String occasion, String bwv) {
        ArrayList<String> list = lookupTable.get(occasion);
        if (list == null) {
            list = new ArrayList<>();
            lookupTable.put(occasion, list);
        }
        list.add(bwv);
    }

    ArrayList<Cantate> getCantatasFor(@SundayAnnotation.Sunday String occasion) {
        ArrayList<Cantate> array = new ArrayList<>();
        ArrayList<String> list = lookupTable.get(occasion);
        if (list != null) {
            for (String bwv : list) {
                Cantate cantate = getCantate(bwv);
                if (cantate == null) {
                    cantate = new Cantate(bwv);
                }
                array.add(cantate);
            }
        }
        return array;
    }
}

