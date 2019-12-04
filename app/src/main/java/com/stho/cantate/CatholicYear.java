package com.stho.cantate;

import android.util.SparseIntArray;

import java.util.Calendar;

/*
  See: https://de.wikipedia.org/wiki/Sonntage_im_Jahreskreis
 */
class CatholicYear {

    private final Year year;
    private final SparseIntArray mapDominicaByDayInYear = new SparseIntArray();

    static SparseIntArray getMap(Year year) {
        CatholicYear calculator = new CatholicYear(year);
        return calculator.mapDominicaByDayInYear;
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
        put(year.newYear, CatholicDominicaAnnotation.SOLLEMNITAS_SANCTAE_DEI_GENETRICIS_MARIAE);
        put(Algorithms.getSundayAfterExclusive(year.newYear), CatholicDominicaAnnotation.DOMINICA_II_POST_NATIVITATEM);
        put(year.epiphany, CatholicDominicaAnnotation.IN_EPIPHANIA_DOMINI);
    }

    private void initializeMapAfterEpiphany() {
        int day = Algorithms.getSundayAfterExclusive(year.epiphany).get(Calendar.DAY_OF_YEAR);
        @CatholicDominicaAnnotation.Dominica int[] sundays = new int[] {
                CatholicDominicaAnnotation.IN_BAPTISMATE_DOMINI,
                CatholicDominicaAnnotation.DOMINICA_II_PER_ANNUM,
                CatholicDominicaAnnotation.DOMINICA_III_PER_ANNUM,
                CatholicDominicaAnnotation.DOMINICA_IV_PER_ANNUM,
                CatholicDominicaAnnotation.DOMINICA_V_PER_ANNUM,
                CatholicDominicaAnnotation.DOMINICA_VI_PER_ANNUM,
                CatholicDominicaAnnotation.DOMINICA_VII_PER_ANNUM,
                CatholicDominicaAnnotation.DOMINICA_VIII_PER_ANNUM,
                CatholicDominicaAnnotation.DOMINICA_IX_PER_ANNUM,
        };
        for (int i=0; i < 9; i++) {
            put(day, sundays[i]);
            day += 7;
        }
    }

    private void initializeMapEaster() {
        int day = year.easter.get(Calendar.DAY_OF_YEAR);
        put(day - 46, CatholicDominicaAnnotation.CINERUM);
        put(day - 42, CatholicDominicaAnnotation.HEBDOMADA_I_QUADRAGESIMAE);
        put(day - 35, CatholicDominicaAnnotation.HEBDOMADA_II_QUADRAGESIMAE);
        put(day - 28, CatholicDominicaAnnotation.HEBDOMADA_III_QUADRAGESIMAE);
        put(day - 21, CatholicDominicaAnnotation.HEBDOMADA_IV_QUADRAGESIMAE);
        put(day - 14, CatholicDominicaAnnotation.HEBDOMADA_V_QUADRAGESIMAE);
        put(day - 7, CatholicDominicaAnnotation.DOMINICA_IN_PALMIS_DE_PASSIONE_DOMINI);
        put(day - 3, CatholicDominicaAnnotation.IN_CENA_DOMINE);
        put(day - 2, CatholicDominicaAnnotation.ADORATIO_SANCTAE_CRUCIS);
        put(day - 1, CatholicDominicaAnnotation.VIGILIAM_PASCHALEM);
        put(day, CatholicDominicaAnnotation.DOMINICA_RESURRECTIONIS);
        put(day + 1, CatholicDominicaAnnotation.FERIA_II_INFRA_OCTAVAM_PASCHAE);
        put(day + 2, CatholicDominicaAnnotation.FERIA_III_INFRA_OCTAVAM_PASCHAE);
        put(day + 7, CatholicDominicaAnnotation.HEBDOMADA_II_PASCHAE);
        put(day + 14, CatholicDominicaAnnotation.HEBDOMADA_III_PASCHAE);
        put(day + 21, CatholicDominicaAnnotation.HEBDOMADA_IV_PASCHAE);
        put(day + 28, CatholicDominicaAnnotation.HEBDOMADA_V_PASCHAE);
        put(day + 35, CatholicDominicaAnnotation.HEBDOMADA_VI_PASCHAE);
        put(day + 39, CatholicDominicaAnnotation.IN_ASCENSIONE_DOMINI);
        put(day + 42, CatholicDominicaAnnotation.HEBDOMADA_VII_PASCHAE);
        put(day + 49, CatholicDominicaAnnotation.DOMINICA_PENTECOSTES);
        put(day + 56, CatholicDominicaAnnotation.SANCTISSIMAE_TRINITATIS);
    }

    private void initializeMapAfterTrinity() {
        int min = Algorithms.getSundayAfterExclusive(year.trinity).get(Calendar.DAY_OF_YEAR);
        int day = Algorithms.getSundayBeforeExclusive(year.advent).get(Calendar.DAY_OF_YEAR);
        @CatholicDominicaAnnotation.Dominica int[] sundays = new int[] {
                CatholicDominicaAnnotation.DOMINICA_ULTIMA_PER_ANNUM,
                CatholicDominicaAnnotation.DOMINICA_XXXIII_PER_ANNUM,
                CatholicDominicaAnnotation.DOMINICA_XXXII_PER_ANNUM,
                CatholicDominicaAnnotation.DOMINICA_XXXI_PER_ANNUM,
                CatholicDominicaAnnotation.DOMINICA_XXX_PER_ANNUM,
                CatholicDominicaAnnotation.DOMINICA_XXIX_PER_ANNUM,
                CatholicDominicaAnnotation.DOMINICA_XXVIII_PER_ANNUM,
                CatholicDominicaAnnotation.DOMINICA_XXVII_PER_ANNUM,
                CatholicDominicaAnnotation.DOMINICA_XXVI_PER_ANNUM,
                CatholicDominicaAnnotation.DOMINICA_XXV_PER_ANNUM,
                CatholicDominicaAnnotation.DOMINICA_XXIV_PER_ANNUM,
                CatholicDominicaAnnotation.DOMINICA_XXIII_PER_ANNUM,
                CatholicDominicaAnnotation.DOMINICA_XXII_PER_ANNUM,
                CatholicDominicaAnnotation.DOMINICA_XXI_PER_ANNUM,
                CatholicDominicaAnnotation.DOMINICA_XX_PER_ANNUM,
                CatholicDominicaAnnotation.DOMINICA_XIX_PER_ANNUM,
                CatholicDominicaAnnotation.DOMINICA_XVIII_PER_ANNUM,
                CatholicDominicaAnnotation.DOMINICA_XVII_PER_ANNUM,
                CatholicDominicaAnnotation.DOMINICA_XVI_PER_ANNUM,
                CatholicDominicaAnnotation.DOMINICA_XV_PER_ANNUM,
                CatholicDominicaAnnotation.DOMINICA_XIV_PER_ANNUM,
                CatholicDominicaAnnotation.DOMINICA_XIII_PER_ANNUM,
                CatholicDominicaAnnotation.DOMINICA_XII_PER_ANNUM,
                CatholicDominicaAnnotation.DOMINICA_XI_PER_ANNUM,
                CatholicDominicaAnnotation.DOMINICA_X_PER_ANNUM,
                CatholicDominicaAnnotation.DOMINICA_IX_PER_ANNUM,
                CatholicDominicaAnnotation.DOMINICA_VIII_PER_ANNUM,
                CatholicDominicaAnnotation.DOMINICA_VII_PER_ANNUM,
                CatholicDominicaAnnotation.DOMINICA_VI_PER_ANNUM,
                CatholicDominicaAnnotation.DOMINICA_V_PER_ANNUM,
                CatholicDominicaAnnotation.DOMINICA_IV_PER_ANNUM,
                CatholicDominicaAnnotation.DOMINICA_III_PER_ANNUM,
                CatholicDominicaAnnotation.DOMINICA_II_PER_ANNUM,
        };
        for (int i=0; day >= min; i++) {
            put(day, sundays[i]);
            day -= 7;
        }
    }

    private void initializeMapAdvent() {
        int day = year.advent.get(Calendar.DAY_OF_YEAR);
        put(day, CatholicDominicaAnnotation.HEBDOMADA_I_ADVENTUS);
        put(day + 7, CatholicDominicaAnnotation.HEBDOMADA_II_ADVENTUS);
        put(day + 14, CatholicDominicaAnnotation.HEBDOMADA_III_ADVENTUS);
        put(day + 21, CatholicDominicaAnnotation.HEBDOMADA_IV_ADVENTUS);
    }

    private void initializeMapSundayAfterChristmas() {
        put(Algorithms.getSundayAfterExclusive(year.christmas), CatholicDominicaAnnotation.SANCTAE_FAMILIAE);
    }

    private void initializeMapChristmas() {
        int day = year.christmas.get(Calendar.DAY_OF_YEAR);
        put(day - 1, CatholicDominicaAnnotation.IN_VIGILIA_NATIVITATIS_DOMINI);
        put(day, CatholicDominicaAnnotation.IN_NATIVITATE_DOMINI);
        put(day + 1, CatholicDominicaAnnotation.SANCTI_STEPHANI_PROTOMARTYRIS);
    }

    private void initializeMapOthers() {
        put(year.silvester, CatholicDominicaAnnotation.SILVESTER);
        put(year.allerHeiligen, CatholicDominicaAnnotation.OMNIUM_SANCTORUM);
        put(year.allerSeelen, CatholicDominicaAnnotation.OMNIUM_FIDELIUM_DEFUNCTORUM);
    }


    private void put(Calendar date, @CatholicDominicaAnnotation.Dominica int dominica) {
        mapDominicaByDayInYear.put(date.get(Calendar.DAY_OF_YEAR), dominica);
    }

    private void put(int day, @CatholicDominicaAnnotation.Dominica int dominica) {
        mapDominicaByDayInYear.put(day, dominica);
    }

}

