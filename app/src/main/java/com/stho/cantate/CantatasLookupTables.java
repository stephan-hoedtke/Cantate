package com.stho.cantate;

import android.annotation.SuppressLint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class CantatasLookupTables {

    @SuppressLint("UseSparseArrays")
    private final HashMap<String, ArrayList<String>> map = new HashMap<>();

    CantatasLookupTables() {
        // see: https://www.bach-cantatas.com/LCY/Lutheran-2016-2020.htm
        set(SundayAnnotation.SUNDAY_1_IN_ADVENT, "61", "62", "36");
        set(SundayAnnotation.SUNDAY_2_IN_ADVENT, "70a");
        set(SundayAnnotation.SUNDAY_3_IN_ADVENT, "186a", "141");
        set(SundayAnnotation.SUNDAY_4_IN_ADVENT, "132", "147a");
        set(SundayAnnotation.CHRISTMAS_DAY_1, "63", "91", "110", "191", "248/1", "197a", "142");
        set(SundayAnnotation.CHRISTMAS_DAY_2, "40", "121", "57", "248/2");
        set(SundayAnnotation.CHRISTMAS_DAY_3, "64", "133", "151", "248/3");
        set(SundayAnnotation.SUNDAY_AFTER_CHRISTMAS, "152", "122", "28");
        set(SundayAnnotation.NEW_YEAR, "190", "41", "16", "171", "143", "248/4", "134a");
        set(SundayAnnotation.SUNDAY_AFTER_NEW_YEAR, "153", "58", "248/5");
        set(SundayAnnotation.EPIPHANY, "65", "123", "248/6");
        set(SundayAnnotation.SUNDAY_AFTER_EPIPHANY_1, "154", "124", "32", "217");
        set(SundayAnnotation.SUNDAY_AFTER_EPIPHANY_2, "155", "3", "13");
        set(SundayAnnotation.SUNDAY_AFTER_EPIPHANY_3, "73", "111", "72", "156");
        set(SundayAnnotation.SUNDAY_AFTER_EPIPHANY_4, "81", "14");
        set(SundayAnnotation.SUNDAY_AFTER_EPIPHANY_5);
        set(SundayAnnotation.SUNDAY_AFTER_EPIPHANY_6);
        set(SundayAnnotation.SEPTUAGESIMA, "144", "92", "84");
        set(SundayAnnotation.SEXAGESIMA, "18", "181", "126");
        set(SundayAnnotation.QUINQUAGESIMA_ESTOMIHI, "22", "23", "127", "159");
        set(SundayAnnotation.INVOCABIT);
        set(SundayAnnotation.REMINISCERE);
        set(SundayAnnotation.OCULI, "54", "80a");
        set(SundayAnnotation.LAETARE);
        set(SundayAnnotation.JUDICA);
        set(SundayAnnotation.PALMARUM, "182");
        set(SundayAnnotation.GOOD_FRIDAY, "244", "245", "246", "247", "A169");
        set(SundayAnnotation.EASTER_SUNDAY, "4", "31", "249", "15", "160");
        set(SundayAnnotation.EASTER_MONDAY, "66", "6", "190");
        set(SundayAnnotation.EASTER_TUESDAY, "134", "145", "158");
        set(SundayAnnotation.QUASIMODOGENITI, "67", "42");
        set(SundayAnnotation.MISERICORDIAS, "104", "85", "112");
        set(SundayAnnotation.JUBILATE, "12", "103", "146");
        set(SundayAnnotation.CANTATE, "166", "108");
        set(SundayAnnotation.ROGATE, "86", "87");
        set(SundayAnnotation.ASCENSION_DAY, "37", "128", "43", "11");
        set(SundayAnnotation.EXAUDI, "44", "183");
        set(SundayAnnotation.PENTECOST_SUNDAY, "172", "59", "74", "34", "218");
        set(SundayAnnotation.PENTECOST_MONDAY, "173", "68", "174");
        set(SundayAnnotation.PENTECOST_TUESDAY, "184", "175");
        set(SundayAnnotation.TRINITY, "165", "194", "176", "129");
        set(SundayAnnotation.SUNDAY_1_AFTER_TRINITY, "75", "20", "39");
        set(SundayAnnotation.SUNDAY_2_AFTER_TRINITY, "76", "2");
        set(SundayAnnotation.SUNDAY_3_AFTER_TRINITY, "21", "135");
        set(SundayAnnotation.SUNDAY_4_AFTER_TRINITY, "185", "24", "177");
        set(SundayAnnotation.SUNDAY_5_AFTER_TRINITY, "93", "88");
        set(SundayAnnotation.SUNDAY_6_AFTER_TRINITY, "170", "9");
        set(SundayAnnotation.SUNDAY_7_AFTER_TRINITY, "186", "107", "187", "A1", "A209", "54?");
        set(SundayAnnotation.SUNDAY_8_AFTER_TRINITY, "136", "178", "45");
        set(SundayAnnotation.SUNDAY_9_AFTER_TRINITY, "105", "94", "168");
        set(SundayAnnotation.SUNDAY_10_AFTER_TRINITY, "46", "101", "102");
        set(SundayAnnotation.SUNDAY_11_AFTER_TRINITY, "199", "179", "113");
        set(SundayAnnotation.SUNDAY_12_AFTER_TRINITY, "69a", "137", "35");
        set(SundayAnnotation.SUNDAY_13_AFTER_TRINITY, "77", "33", "164");
        set(SundayAnnotation.SUNDAY_14_AFTER_TRINITY, "25", "78", "17");
        set(SundayAnnotation.SUNDAY_15_AFTER_TRINITY, "138", "99", "51", "100");
        set(SundayAnnotation.SUNDAY_16_AFTER_TRINITY, "161", "95", "8", "27");
        set(SundayAnnotation.SUNDAY_17_AFTER_TRINITY, "114", "148", "47");
        set(SundayAnnotation.SUNDAY_18_AFTER_TRINITY, "96", "169");
        set(SundayAnnotation.SUNDAY_19_AFTER_TRINITY, "48", "5", "56", "A2");
        set(SundayAnnotation.SUNDAY_20_AFTER_TRINITY, "162", "180", "49");
        set(SundayAnnotation.SUNDAY_21_AFTER_TRINITY, "109", "38", "98", "188");
        set(SundayAnnotation.SUNDAY_22_AFTER_TRINITY, "89", "115", "55");
        set(SundayAnnotation.SUNDAY_23_AFTER_TRINITY, "163", "139", "52");
        set(SundayAnnotation.SUNDAY_24_AFTER_TRINITY, "60", "26");
        set(SundayAnnotation.SUNDAY_25_AFTER_TRINITY, "90", "116");
        set(SundayAnnotation.SUNDAY_26_AFTER_TRINITY, "70");
        set(SundayAnnotation.SUNDAY_27_AFTER_TRINITY, "140");
        set(SundayAnnotation.PURIFICATION_MARIAE, "83", "125", "82", "157", "158", "200", "161", "A157");
        set(SundayAnnotation.ANNUNCIATION_MARIAE, "1", "182", "A156", "A199");
        set(SundayAnnotation.JOHANNIS, "167", "7", "30", "220");
        set(SundayAnnotation.VISITATION_MARIAE, "147", "10", "189");
        set(SundayAnnotation.MICHAELIS, "130", "19", "149", "50", "219", "A198");
        set(SundayAnnotation.REFORMATION, "80", "79", "129?", "192");
        set(SundayAnnotation.FUNERAL, "106", "157", "118", "53", "198");
        set(SundayAnnotation.WEDDING, "192?", "195", "196", "197", "34a", "120a");
        set(SundayAnnotation.OTHER, "194", "150", "131", "21", "51", "100", "21", "117", "97", "80b", "221", "222");
    }

    private void set(@SundayAnnotation.Sunday String key, String ...cantatas) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, cantatas);
        map.put(key, list);
    }

    ArrayList<String> get(@SundayAnnotation.Sunday String key) {
        return map.get(key);
    }

}
