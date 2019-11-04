package com.stho.cantate;

import android.util.SparseArray;
import android.util.SparseIntArray;

import java.util.Calendar;

/*
  See: https://de.wikipedia.org/wiki/Sonntage_im_Jahreskreis
 */
class CatholicYear {

    private final Year year;
    private final SparseArray<String> map = new SparseArray<>();

    static SparseArray<String> getMap(Year year) {
        CatholicYear calculator = new CatholicYear(year);
        return calculator.map;
    }

    private CatholicYear(Year year) {
        this.year = year;
        initialize();
    }

    private void initialize() {
        initializeMapNewYear();
        initializeMapAfterEpiphany();
        initializeMapEaster();
        initializeMapAfterTrinity();
        initializeMapAdvent();
        initializeMapSundayAfterChristmas(); // it may be overwritten by christmas
        initializeMapChristmas();
        initializeMapOthers();
    }

    private void initializeMapNewYear() {
        put(year.newYear, DominicaAnnotation.SOLLEMNITAS_SANCTAE_DEI_GENETRICIS_MARIAE);
        put(Algorithms.getSundayAfterExclusive(year.newYear), DominicaAnnotation.DOMINICA_II_POST_NATIVITATEM);
        put(year.epiphany, DominicaAnnotation.IN_EPIPHANIA_DOMINI);
    }

    private void initializeMapAfterEpiphany() {
        int day = Algorithms.getSundayAfterExclusive(year.epiphany).get(Calendar.DAY_OF_YEAR);
        @DominicaAnnotation.Dominica String[] sundays = new String[] {
                DominicaAnnotation.IN_BAPTISMATE_DOMINI,
                DominicaAnnotation.DOMINICA_II_PER_ANNUM,
                DominicaAnnotation.DOMINICA_III_PER_ANNUM,
                DominicaAnnotation.DOMINICA_IV_PER_ANNUM,
                DominicaAnnotation.DOMINICA_V_PER_ANNUM,
                DominicaAnnotation.DOMINICA_VI_PER_ANNUM,
                DominicaAnnotation.DOMINICA_VII_PER_ANNUM,
                DominicaAnnotation.DOMINICA_VIII_PER_ANNUM,
                DominicaAnnotation.DOMINICA_IX_PER_ANNUM,
        };
        for (int i=0; i < 9; i++) {
            put(day, sundays[i]);
            day += 7;
        }
    }

    private void initializeMapEaster() {
        int day = year.easter.get(Calendar.DAY_OF_YEAR);
        put(day - 46, DominicaAnnotation.CINERUM);
        put(day - 42, DominicaAnnotation.HEBDOMADA_I_QUADRAGESIMAE);
        put(day - 35, DominicaAnnotation.HEBDOMADA_II_QUADRAGESIMAE);
        put(day - 28, DominicaAnnotation.HEBDOMADA_III_QUADRAGESIMAE);
        put(day - 21, DominicaAnnotation.HEBDOMADA_IV_QUADRAGESIMAE);
        put(day - 14, DominicaAnnotation.HEBDOMADA_V_QUADRAGESIMAE);
        put(day - 7, DominicaAnnotation.DOMINICA_IN_PALMIS_DE_PASSIONE_DOMINI);
        put(day - 3, DominicaAnnotation.IN_CENA_DOMINE);
        put(day - 2, DominicaAnnotation.ADORATIO_SANCTAE_CRUCIS);
        put(day - 1, DominicaAnnotation.VIGILIAM_PASCHALEM);
        put(day, DominicaAnnotation.DOMINICA_RESURRECTIONIS);
        put(day + 1, DominicaAnnotation.FERIA_II_INFRA_OCTAVAM_PASCHA);
        put(day + 2, DominicaAnnotation.FERIA_III_INFRA_OCTAVAM_PASCHA);
        put(day + 7, DominicaAnnotation.HEBDOMADA_II_PASCHAE);
        put(day + 14, DominicaAnnotation.HEBDOMADA_III_PASCHAE);
        put(day + 21, DominicaAnnotation.HEBDOMADA_IV_PASCHAE);
        put(day + 28, DominicaAnnotation.HEBDOMADA_V_PASCHAE);
        put(day + 35, DominicaAnnotation.HEBDOMADA_VI_PASCHAE);
        put(day + 39, DominicaAnnotation.IN_ASCENSIONE_DOMINI);
        put(day + 42, DominicaAnnotation.HEBDOMADA_VII_PASCHAE);
        put(day + 49, DominicaAnnotation.DOMINICA_PENTECOSTES);
    }

    private void initializeMapAfterTrinity() {
        int min = Algorithms.getSundayAfterExclusive(year.trinity).get(Calendar.DAY_OF_YEAR);
        int day = Algorithms.getSundayBeforeExclusive(year.advent).get(Calendar.DAY_OF_YEAR);
        @DominicaAnnotation.Dominica String[] sundays = new String[] {
                DominicaAnnotation.DOMINICA_ULTIMA_PER_ANNUM,
                DominicaAnnotation.DOMINICA_XXXIII_PER_ANNUM,
                DominicaAnnotation.DOMINICA_XXXII_PER_ANNUM,
                DominicaAnnotation.DOMINICA_XXXI_PER_ANNUM,
                DominicaAnnotation.DOMINICA_XXX_PER_ANNUM,
                DominicaAnnotation.DOMINICA_XXIX_PER_ANNUM,
                DominicaAnnotation.DOMINICA_XXVIII_PER_ANNUM,
                DominicaAnnotation.DOMINICA_XXVII_PER_ANNUM,
                DominicaAnnotation.DOMINICA_XXVI_PER_ANNUM,
                DominicaAnnotation.DOMINICA_XXV_PER_ANNUM,
                DominicaAnnotation.DOMINICA_XXIV_PER_ANNUM,
                DominicaAnnotation.DOMINICA_XXIII_PER_ANNUM,
                DominicaAnnotation.DOMINICA_XXII_PER_ANNUM,
                DominicaAnnotation.DOMINICA_XXI_PER_ANNUM,
                DominicaAnnotation.DOMINICA_XX_PER_ANNUM,
                DominicaAnnotation.DOMINICA_XIX_PER_ANNUM,
                DominicaAnnotation.DOMINICA_XVIII_PER_ANNUM,
                DominicaAnnotation.DOMINICA_XVII_PER_ANNUM,
                DominicaAnnotation.DOMINICA_XVI_PER_ANNUM,
                DominicaAnnotation.DOMINICA_XV_PER_ANNUM,
                DominicaAnnotation.DOMINICA_XIV_PER_ANNUM,
                DominicaAnnotation.DOMINICA_XIII_PER_ANNUM,
                DominicaAnnotation.DOMINICA_XII_PER_ANNUM,
                DominicaAnnotation.DOMINICA_XI_PER_ANNUM,
                DominicaAnnotation.DOMINICA_X_PER_ANNUM,
                DominicaAnnotation.DOMINICA_IX_PER_ANNUM,
                DominicaAnnotation.DOMINICA_VIII_PER_ANNUM,
                DominicaAnnotation.DOMINICA_VII_PER_ANNUM,
                DominicaAnnotation.DOMINICA_VI_PER_ANNUM,
                DominicaAnnotation.DOMINICA_V_PER_ANNUM,
                DominicaAnnotation.DOMINICA_IV_PER_ANNUM,
                DominicaAnnotation.DOMINICA_III_PER_ANNUM,
                DominicaAnnotation.DOMINICA_II_PER_ANNUM,
        };
        for (int i=0; day >= min; i++) {
            put(day, sundays[i]);
            day -= 7;
        }
    }

    private void initializeMapAdvent() {
        int day = year.advent.get(Calendar.DAY_OF_YEAR);
        put(day, DominicaAnnotation.HEBDOMADA_I_ADVENTUS);
        put(day + 7, DominicaAnnotation.HEBDOMADA_II_ADVENTUS);
        put(day + 14, DominicaAnnotation.HEBDOMADA_III_ADVENTUS);
        put(day + 21, DominicaAnnotation.HEBDOMADA_IV_ADVENTUS);
    }

    private void initializeMapSundayAfterChristmas() {
        put(Algorithms.getSundayAfterExclusive(year.christmas), DominicaAnnotation.SANCTAE_FAMILIAE);
    }

    private void initializeMapChristmas() {
        int day = year.christmas.get(Calendar.DAY_OF_YEAR);
        put(day - 1, DominicaAnnotation.IN_VIGILIA_NATIVITATIS_DOMINI);
        put(day, DominicaAnnotation.IN_NATIVITATE_DOMINI);
        put(day + 1, DominicaAnnotation.SANCTI_STEPHANI_PROTOMARTYRIS);
    }

    private void initializeMapOthers() {
        put(year.silvester, DominicaAnnotation.SILVESTER);
        put(year.allerHeiligen, DominicaAnnotation.ALLERHEILIGEN);
        put(year.allerSeelen, DominicaAnnotation.ALLERSEELEN);
    }


    private void put(Calendar date, @DominicaAnnotation.Dominica String dominica) {
        map.put(date.get(Calendar.DAY_OF_YEAR), dominica);
    }

    private void put(int day, @DominicaAnnotation.Dominica String dominica) {
        map.put(day, dominica);
    }

}

