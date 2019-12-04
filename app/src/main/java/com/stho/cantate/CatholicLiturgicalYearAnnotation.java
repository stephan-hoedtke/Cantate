package com.stho.cantate;


import android.annotation.SuppressLint;

import androidx.annotation.IntDef;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.security.InvalidParameterException;

/*
  Lesejahr
 */
public class CatholicLiturgicalYearAnnotation {
    static final int ALL = 0;
    static final int A = 1;
    static final int B = 2;
    static final int C = 3;

    @IntDef({A, B, C, ALL})

    @Retention(RetentionPolicy.SOURCE)
    public @interface Year { }

    @Year
    static int fromName(String name) {
        if (name == null) {
            return CatholicLiturgicalYearAnnotation.ALL;
        }
        switch (name) {
            case "A":   return CatholicLiturgicalYearAnnotation.A;
            case "B":   return CatholicLiturgicalYearAnnotation.B;
            case "C":   return CatholicLiturgicalYearAnnotation.C;
            case "ALL":   return CatholicLiturgicalYearAnnotation.ALL;
            default:
                throw new InvalidParameterException("The Year " + name + " is invalid.");
        }
    }

    @SuppressLint("SwitchIntDef")
    static String toString(@Year int year) {
        switch (year) {
            case A: return "A";
            case B: return "B";
            case C: return "C";
            default:
                return "";
        }
    }
}
