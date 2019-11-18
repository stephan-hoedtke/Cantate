package com.stho.cantate;

import androidx.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class SundayAnnotation {

    /*
     https://www.kirchenjahr-evangelisch.de/#2019-60-0-0
     */
    static final String ADVENT_I                = "ADVENT_I";
    static final String ADVENT_II               = "ADVENT_II";
    static final String ADVENT_III              = "ADVENT_III";
    static final String ADVENT_IV               = "ADVENT_IV";
    static final String CHRISTMAS_DAY_1         = "CHRISTMAS_DAY_1";        // 25. Dec. Geburt des Herrn
    static final String CHRISTMAS_DAY_2         = "CHRISTMAS_DAY_2";
    static final String CHRISTMAS_DAY_3         = "CHRISTMAS_DAY_3";
    static final String AFTER_CHRISTMAS         = "AFTER_CHRISTMAS";
    static final String NEW_YEAR                = "NEW_YEAR";
    static final String AFTER_NEW_YEAR          = "AFTER_NEW_YEAR";         // 2nd EvangelicSunday after Christmas
    static final String EPIPHANY                = "EPIPHANY";               // 6. Jan. Epiphanie = Taufe des Herrn
    static final String EPIPHANY_I              = "EPIPHANY_I";
    static final String EPIPHANY_II             = "EPIPHANY_II";
    static final String EPIPHANY_III            = "EPIPHANY_III";
    static final String EPIPHANY_IV             = "EPIPHANY_IV";
    static final String EPIPHANY_V              = "EPIPHANY_V";
    static final String EPIPHANY_VI             = "EPIPHANY_VI";
    static final String SEPTUAGESIMA            = "SEPTUAGESIMA";            // Third EvangelicSunday before Lent / Ash Wednesday
    static final String SEXAGESIMA              = "SEXAGESIMA";              // Second EvangelicSunday before Lent / Ash Wednesday
    static final String ESTOMIHI                = "ESTOMIHI";  // EvangelicSunday before Lent / Ash Wednesday
    static final String ASH_WEDNESDAY           = "ASH_WEDNESDAY";           // Ash Wednesday
    static final String INVOCABIT               = "INVOCABIT";               // First EvangelicSunday in Lent
    static final String REMINISCERE             = "REMINISCERE";             // Second EvangelicSunday in Lent
    static final String OCULI                   = "OCULI";                   // Third EvangelicSunday in Lent
    static final String LAETARE                 = "LAETARE";                 // Fourth EvangelicSunday in Lent
    static final String JUDICA                  = "JUDICA";                  // Fifth EvangelicSunday in Lent
    static final String PALMARUM                = "PALMARUM";                // Palmsonntag
    static final String GOOD_FRIDAY             = "GOOD_FRIDAY";             // Kreuzverehrung
    static final String EASTER_SUNDAY           = "EASTER_SUNDAY";
    static final String EASTER_MONDAY           = "EASTER_MONDAY";
    static final String EASTER_TUESDAY          = "EASTER_TUESDAY";
    static final String QUASIMODOGENITI         = "QUASIMODOGENITI";         // First EvangelicSunday after Easter
    static final String MISERICORDIAS           = "MISERICORDIAS";           // Second EvangelicSunday after Easter
    static final String JUBILATE                = "JUBILATE";                // Third EvangelicSunday after Easter
    static final String CANTATE                 = "CANTATE";                 // Fourth EvangelicSunday after Easter
    static final String ROGATE                  = "ROGATE ";                 // Fifth EvangelicSunday after Easter
    static final String ASCENSION               = "ASCENSION";
    static final String EXAUDI                  = "EXAUDI";                  // Sixth EvangelicSunday after Easter
    static final String PENTECOST_SUNDAY        = "PENTECOST_SUNDAY";        // Whit EvangelicSunday
    static final String PENTECOST_MONDAY        = "PENTECOST_MONDAY";        // Whit Monday
    static final String PENTECOST_TUESDAY       = "PENTECOST_TUESDAY";       // Whit Tuesday
    static final String TRINITY                 = "TRINITY";
    static final String TRINITY_I               = "TRINITY_I";
    static final String TRINITY_II              = "TRINITY_II";
    static final String TRINITY_III             = "TRINITY_III";
    static final String TRINITY_IV              = "TRINITY_IV";
    static final String TRINITY_V               = "TRINITY_V";
    static final String TRINITY_VI              = "TRINITY_VI";
    static final String TRINITY_VII             = "TRINITY_VII";
    static final String TRINITY_VIII            = "TRINITY_VIII";
    static final String TRINITY_IX              = "TRINITY_IX";
    static final String TRINITY_X               = "TRINITY_X";
    static final String TRINITY_XI              = "TRINITY_XI";
    static final String TRINITY_XII             = "TRINITY_XII";
    static final String TRINITY_XIII            = "TRINITY_XIII";
    static final String TRINITY_XIV             = "TRINITY_XIV";
    static final String TRINITY_XV              = "TRINITY_XV";
    static final String TRINITY_XVI             = "TRINITY_XVI";
    static final String TRINITY_XVII            = "TRINITY_XVII";
    static final String TRINITY_XVIII           = "TRINITY_XVIII";
    static final String TRINITY_XIX             = "TRINITY_XIX";
    static final String TRINITY_XX              = "TRINITY_XX";
    static final String TRINITY_XXI             = "TRINITY_XXI";
    static final String TRINITY_XXII            = "TRINITY_XXII";
    static final String TRINITY_XXIII           = "TRINITY_XXIII";
    static final String TRINITY_XXIV            = "TRINITY_XXIV";
    static final String TRINITY_XXV             = "TRINITY_XXV";
    static final String TRINITY_XXVI            = "TRINITY_XXVI";
    static final String TRINITY_XXVII           = "TRINITY_XXVII";
    static final String PURIFICATION            = "PURIFICATION";             // 2. Feb. = Praesentatione Domini (Darstellung des Herrn) = "Maria Lichtmess"
    static final String ANNUNCIATION            = "ANNUNCIATION";             // 25. March = Annuntiationae Domini (Verkündigung des Herrn)
    static final String JOHANNIS                = "JOHANNIS";                 // 24. June
    static final String VISITATION              = "VISITATION";               // 2. Juli
    static final String MICHAELIS               = "MICHAELIS";                // 29. Sept.
    static final String REFORMATION             = "REFORMATION";              // 31. Oct.
    static final String FUNERAL                 = "FUNERAL";
    static final String WEDDING                 = "WEDDING";
    static final String RATSWAHL                = "RATSWAHL";
    static final String OTHER                   = "OTHER";
    static final String UNKNOWN                 = "UNKNOWN";


    // Declare the @ StringDef for these constants:
    @StringDef({
            ADVENT_I,
            ADVENT_II,
            ADVENT_III,
            ADVENT_IV,
            CHRISTMAS_DAY_1,
            CHRISTMAS_DAY_2,
            CHRISTMAS_DAY_3,
            AFTER_CHRISTMAS,
            NEW_YEAR,
            AFTER_NEW_YEAR,
            EPIPHANY,
            EPIPHANY_I,
            EPIPHANY_II,
            EPIPHANY_III,
            EPIPHANY_IV,
            EPIPHANY_V,
            EPIPHANY_VI,
            SEPTUAGESIMA,
            SEXAGESIMA,
            ESTOMIHI,
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
            ASCENSION,
            EXAUDI,
            PENTECOST_SUNDAY,
            PENTECOST_MONDAY,
            PENTECOST_TUESDAY,
            TRINITY,
            TRINITY_I,
            TRINITY_II,
            TRINITY_III,
            TRINITY_IV,
            TRINITY_V,
            TRINITY_VI,
            TRINITY_VII,
            TRINITY_VIII,
            TRINITY_IX,
            TRINITY_X,
            TRINITY_XI,
            TRINITY_XII,
            TRINITY_XIII,
            TRINITY_XIV,
            TRINITY_XV,
            TRINITY_XVI,
            TRINITY_XVII,
            TRINITY_XVIII,
            TRINITY_XIX,
            TRINITY_XX,
            TRINITY_XXI,
            TRINITY_XXII,
            TRINITY_XXIII,
            TRINITY_XXIV,
            TRINITY_XXV,
            TRINITY_XXVI,
            TRINITY_XXVII,
            PURIFICATION,
            ANNUNCIATION,
            JOHANNIS,
            VISITATION,
            MICHAELIS,
            REFORMATION,
            WEDDING,
            FUNERAL,
            RATSWAHL,
            OTHER,
            UNKNOWN,
    })
    @Retention(RetentionPolicy.SOURCE)
    public @interface Sunday {}
 }
