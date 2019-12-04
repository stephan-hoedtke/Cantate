package com.stho.cantate;

import android.util.SparseArray;

import java.util.ArrayList;
import java.util.HashMap;

public class Cantatas {
    private HashMap<String, Cantate> cantatasByBwv = new HashMap<>();
    private SparseArray<ArrayList<String>> bwvsBySunday = new SparseArray<>();

    Cantate getCantate(String bwv) {
        Cantate cantate = cantatasByBwv.get(bwv);
        if (cantate == null) {
            cantate = new Cantate(this, bwv);
            cantatasByBwv.put(bwv, cantate);
        }
        return cantate;
    }

    void setOccasion(@EvangelicSundayAnnotation.Sunday int occasion, String bwv) {
        ArrayList<String> bwvs = bwvsBySunday.get(occasion);
        if (bwvs == null) {
            bwvs = new ArrayList<>();
            bwvsBySunday.put(occasion, bwvs);
        }
        bwvs.add(bwv);
    }

    ArrayList<Cantate> getCantatasFor(@EvangelicSundayAnnotation.Sunday int occasion) {
        ArrayList<Cantate> cantatas = new ArrayList<>();
        ArrayList<String> bwvs = bwvsBySunday.get(occasion);
        if (bwvs != null) {
            for (String bwv : bwvs) {
                cantatas.add(getCantate(bwv));
            }
        }
        return cantatas;
    }
}

