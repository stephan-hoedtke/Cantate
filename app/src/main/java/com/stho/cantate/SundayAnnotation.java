package com.stho.cantate;

import androidx.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class SundayAnnotation {

    /*
     https://www.kirchenjahr-evangelisch.de/#2019-60-0-0
     */
    static final String SUNDAY_1_IN_ADVENT         = "SUNDAY_1_IN_ADVENT";
    static final String SUNDAY_2_IN_ADVENT         = "SUNDAY_2_IN_ADVENT";
    static final String SUNDAY_3_IN_ADVENT         = "SUNDAY_3_IN_ADVENT";
    static final String SUNDAY_4_IN_ADVENT         = "SUNDAY_4_IN_ADVENT";
    static final String CHRISTMAS_DAY_1            = "CHRISTMAS_DAY_1";         // 25. Dec. Geburt des Herrn
    static final String CHRISTMAS_DAY_2            = "CHRISTMAS_DAY_2";
    static final String CHRISTMAS_DAY_3            = "CHRISTMAS_DAY_3";
    static final String SUNDAY_AFTER_CHRISTMAS     = "SUNDAY_AFTER_CHRISTMAS";
    static final String NEW_YEAR                   = "NEW_YEAR";
    static final String SUNDAY_AFTER_NEW_YEAR      = "SUNDAY_AFTER_NEW_YEAR";   // 2nd EvangelicSunday after Christmas
    static final String EPIPHANY                   = "EPIPHANY";                // 6. Jan. Epiphanie = Taufe des Herrn
    static final String SUNDAY_AFTER_EPIPHANY_1    = "SUNDAY_AFTER_EPIPHANY_1";
    static final String SUNDAY_AFTER_EPIPHANY_2    = "SUNDAY_AFTER_EPIPHANY_2";
    static final String SUNDAY_AFTER_EPIPHANY_3    = "SUNDAY_AFTER_EPIPHANY_3";
    static final String SUNDAY_AFTER_EPIPHANY_4    = "SUNDAY_AFTER_EPIPHANY_4";
    static final String SUNDAY_AFTER_EPIPHANY_5    = "SUNDAY_AFTER_EPIPHANY_5";
    static final String SUNDAY_AFTER_EPIPHANY_6    = "SUNDAY_AFTER_EPIPHANY_6";
    static final String SEPTUAGESIMA               = "SEPTUAGESIMA";            // Third EvangelicSunday before Lent / Ash Wednesday
    static final String SEXAGESIMA                 = "SEXAGESIMA";              // Second EvangelicSunday before Lent / Ash Wednesday
    static final String QUINQUAGESIMA_ESTOMIHI     = "QUINQUAGESIMA_ESTOMIHI";  // EvangelicSunday before Lent / Ash Wednesday
    static final String ASH_WEDNESDAY              = "ASH_WEDNESDAY";           // Ash Wednesday
    static final String INVOCABIT                  = "INVOCABIT";               // First EvangelicSunday in Lent
    static final String REMINISCERE                = "REMINISCERE";             // Second EvangelicSunday in Lent
    static final String OCULI                      = "OCULI";                   // Third EvangelicSunday in Lent
    static final String LAETARE                    = "LAETARE";                 // Fourth EvangelicSunday in Lent
    static final String JUDICA                     = "JUDICA";                  // Fifth EvangelicSunday in Lent
    static final String PALMARUM                   = "PALMARUM";                // Palmsonntag
    static final String GOOD_FRIDAY                = "GOOD_FRIDAY";             // Kreuzverehrung
    static final String EASTER_SUNDAY              = "EASTER_SUNDAY";
    static final String EASTER_MONDAY              = "EASTER_MONDAY";
    static final String EASTER_TUESDAY             = "EASTER_TUESDAY";
    static final String QUASIMODOGENITI            = "QUASIMODOGENITI";         // First EvangelicSunday after Easter
    static final String MISERICORDIAS              = "MISERICORDIAS";           // Second EvangelicSunday after Easter
    static final String JUBILATE                   = "JUBILATE";                // Third EvangelicSunday after Easter
    static final String CANTATE                    = "CANTATE";                 // Fourth EvangelicSunday after Easter
    static final String ROGATE                     = "ROGATE ";                 // Fifth EvangelicSunday after Easter
    static final String ASCENSION_DAY              = "ASCENSION_DAY";
    static final String EXAUDI                     = "EXAUDI";                  // Sixth EvangelicSunday after Easter
    static final String PENTECOST_SUNDAY           = "PENTECOST_SUNDAY";        // Whit EvangelicSunday
    static final String PENTECOST_MONDAY           = "PENTECOST_MONDAY";        // Whit Monday
    static final String PENTECOST_TUESDAY          = "PENTECOST_TUESDAY";       // Whit Tuesday
    static final String TRINITY                    = "TRINITY";
    static final String SUNDAY_1_AFTER_TRINITY     = "SUNDAY_1_AFTER_TRINITY";
    static final String SUNDAY_2_AFTER_TRINITY     = "SUNDAY_2_AFTER_TRINITY";
    static final String SUNDAY_3_AFTER_TRINITY     = "SUNDAY_3_AFTER_TRINITY";
    static final String SUNDAY_4_AFTER_TRINITY     = "SUNDAY_4_AFTER_TRINITY";
    static final String SUNDAY_5_AFTER_TRINITY     = "SUNDAY_5_AFTER_TRINITY";
    static final String SUNDAY_6_AFTER_TRINITY     = "SUNDAY_6_AFTER_TRINITY";
    static final String SUNDAY_7_AFTER_TRINITY     = "SUNDAY_7_AFTER_TRINITY";
    static final String SUNDAY_8_AFTER_TRINITY     = "SUNDAY_8_AFTER_TRINITY";
    static final String SUNDAY_9_AFTER_TRINITY     = "SUNDAY_9_AFTER_TRINITY";
    static final String SUNDAY_10_AFTER_TRINITY    = "SUNDAY_10_AFTER_TRINITY";
    static final String SUNDAY_11_AFTER_TRINITY    = "SUNDAY_11_AFTER_TRINITY";
    static final String SUNDAY_12_AFTER_TRINITY    = "SUNDAY_12_AFTER_TRINITY";
    static final String SUNDAY_13_AFTER_TRINITY    = "SUNDAY_13_AFTER_TRINITY";
    static final String SUNDAY_14_AFTER_TRINITY    = "SUNDAY_14_AFTER_TRINITY";
    static final String SUNDAY_15_AFTER_TRINITY    = "SUNDAY_15_AFTER_TRINITY";
    static final String SUNDAY_16_AFTER_TRINITY    = "SUNDAY_16_AFTER_TRINITY";
    static final String SUNDAY_17_AFTER_TRINITY    = "SUNDAY_17_AFTER_TRINITY";
    static final String SUNDAY_18_AFTER_TRINITY    = "SUNDAY_18_AFTER_TRINITY";
    static final String SUNDAY_19_AFTER_TRINITY    = "SUNDAY_19_AFTER_TRINITY";
    static final String SUNDAY_20_AFTER_TRINITY    = "SUNDAY_20_AFTER_TRINITY";
    static final String SUNDAY_21_AFTER_TRINITY    = "SUNDAY_21_AFTER_TRINITY";
    static final String SUNDAY_22_AFTER_TRINITY    = "SUNDAY_22_AFTER_TRINITY";
    static final String SUNDAY_23_AFTER_TRINITY    = "SUNDAY_23_AFTER_TRINITY";
    static final String SUNDAY_24_AFTER_TRINITY    = "SUNDAY_24_AFTER_TRINITY";
    static final String SUNDAY_25_AFTER_TRINITY    = "SUNDAY_25_AFTER_TRINITY";
    static final String SUNDAY_26_AFTER_TRINITY    = "SUNDAY_26_AFTER_TRINITY";
    static final String SUNDAY_27_AFTER_TRINITY    = "SUNDAY_27_AFTER_TRINITY";
    static final String PURIFICATION_MARIAE        = "PURIFICATION_MARIAE";             // 2. Feb. = Praesentatione Domini (Darstellung des Herrn) = "Maria Lichtmess"
    static final String ANNUNCIATION_MARIAE        = "ANNUNCIATION_MARIAE";             // 25. March = Annuntiationae Domini (Verkündigung des Herrn)
    static final String JOHANNIS                   = "JOHANNIS";                        // 24. June
    static final String VISITATION_MARIAE          = "VISITATION_MARIAE";               // 2. Juli
    static final String MICHAELIS                  = "MICHAELIS";                       // 29. Sept.
    static final String REFORMATION                = "REFORMATION";                     // 31. Oct.
    static final String FUNERAL                    = "FUNERAL";
    static final String WEDDING                    = "WEDDING";
    static final String OTHER                      = "OTHER";


    // Declare the @ StringDef for these constants:
    @StringDef({
            SUNDAY_1_IN_ADVENT,
            SUNDAY_2_IN_ADVENT,
            SUNDAY_3_IN_ADVENT,
            SUNDAY_4_IN_ADVENT,
            CHRISTMAS_DAY_1,
            CHRISTMAS_DAY_2,
            CHRISTMAS_DAY_3,
            SUNDAY_AFTER_CHRISTMAS,
            NEW_YEAR,
            SUNDAY_AFTER_NEW_YEAR,
            EPIPHANY,
            SUNDAY_AFTER_EPIPHANY_1,
            SUNDAY_AFTER_EPIPHANY_2,
            SUNDAY_AFTER_EPIPHANY_3,
            SUNDAY_AFTER_EPIPHANY_4,
            SUNDAY_AFTER_EPIPHANY_5,
            SUNDAY_AFTER_EPIPHANY_6,
            SEPTUAGESIMA,
            SEXAGESIMA,
            QUINQUAGESIMA_ESTOMIHI,
            ASH_WEDNESDAY,
            INVOCABIT,
            REMINISCERE,
            OCULI,
            LAETARE,
            JUDICA,
            PALMARUM,
            GOOD_FRIDAY,
            EASTER_SUNDAY,
            EASTER_MONDAY,
            EASTER_TUESDAY,
            QUASIMODOGENITI,
            MISERICORDIAS,
            JUBILATE,
            CANTATE,
            ROGATE,
            ASCENSION_DAY,
            EXAUDI,
            PENTECOST_SUNDAY,
            PENTECOST_MONDAY,
            PENTECOST_TUESDAY,
            TRINITY,
            SUNDAY_1_AFTER_TRINITY,
            SUNDAY_2_AFTER_TRINITY,
            SUNDAY_3_AFTER_TRINITY,
            SUNDAY_4_AFTER_TRINITY,
            SUNDAY_5_AFTER_TRINITY,
            SUNDAY_6_AFTER_TRINITY,
            SUNDAY_7_AFTER_TRINITY,
            SUNDAY_8_AFTER_TRINITY,
            SUNDAY_9_AFTER_TRINITY,
            SUNDAY_10_AFTER_TRINITY,
            SUNDAY_11_AFTER_TRINITY,
            SUNDAY_12_AFTER_TRINITY,
            SUNDAY_13_AFTER_TRINITY,
            SUNDAY_14_AFTER_TRINITY,
            SUNDAY_15_AFTER_TRINITY,
            SUNDAY_16_AFTER_TRINITY,
            SUNDAY_17_AFTER_TRINITY,
            SUNDAY_18_AFTER_TRINITY,
            SUNDAY_19_AFTER_TRINITY,
            SUNDAY_20_AFTER_TRINITY,
            SUNDAY_21_AFTER_TRINITY,
            SUNDAY_22_AFTER_TRINITY,
            SUNDAY_23_AFTER_TRINITY,
            SUNDAY_24_AFTER_TRINITY,
            SUNDAY_25_AFTER_TRINITY,
            SUNDAY_26_AFTER_TRINITY,
            SUNDAY_27_AFTER_TRINITY,
            PURIFICATION_MARIAE,
            ANNUNCIATION_MARIAE,
            JOHANNIS,
            VISITATION_MARIAE,
            MICHAELIS,
            REFORMATION,
            WEDDING,
            FUNERAL,
            OTHER,
    })
    @Retention(RetentionPolicy.SOURCE)
    public @interface Sunday {}
 }
