package com.stho.cantate;


import androidx.annotation.StringDef;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*
  Lesejahr
 */
public class CatholicLiturgicalYearAnnotation {
    static final String ALL = "ALL";
    static final String A = "A";
    static final String B = "B";
    static final String C = "C";

    // Declare the @ StringDef for these constants:
    @StringDef({A, B, C, ALL})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Year { }
}
