package com.stho.cantate;

import androidx.annotation.IntDef;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.security.InvalidParameterException;

public class EvangelicSundayAnnotation {

    /*
     https://www.kirchenjahr-evangelisch.de/#2019-60-0-0
     */
    static final int ADVENT_I                = 1;
    static final int ADVENT_II               = 2;
    static final int ADVENT_III              = 3;
    static final int ADVENT_IV               = 4;
    static final int CHRISTMAS_DAY_1         = 5;
    static final int CHRISTMAS_DAY_2         = 6;
    static final int CHRISTMAS_DAY_3         = 7;
    static final int AFTER_CHRISTMAS         = 8;
    static final int NEW_YEAR                = 9;
    static final int AFTER_NEW_YEAR          = 10;      // 2nd EvangelicSunday after Christmas
    static final int EPIPHANY                = 100;     // 6. Jan. Epiphanie = Taufe des Herrn
    static final int EPIPHANY_I              = 101;
    static final int EPIPHANY_II             = 102;
    static final int EPIPHANY_III            = 103;
    static final int EPIPHANY_IV             = 104;
    static final int EPIPHANY_V              = 105;
    static final int EPIPHANY_VI             = 106;
    static final int SEPTUAGESIMA            = 200;     // Third EvangelicSunday before Lent / Ash Wednesday
    static final int SEXAGESIMA              = 201;     // Second EvangelicSunday before Lent / Ash Wednesday
    static final int ESTOMIHI                = 202;     // EvangelicSunday before Lent / Ash Wednesday
    static final int ASH_WEDNESDAY           = 203;     // Ash Wednesday
    static final int INVOCABIT               = 204;     // First EvangelicSunday in Lent
    static final int REMINISCERE             = 205;     // Second EvangelicSunday in Lent
    static final int OCULI                   = 206;     // Third EvangelicSunday in Lent
    static final int LAETARE                 = 207;     // Fourth EvangelicSunday in Lent
    static final int JUDICA                  = 208;     // Fifth EvangelicSunday in Lent
    static final int PALMARUM                = 209;     // Palmsonntag
    static final int GOOD_FRIDAY             = 210;     // Kreuzverehrung, Karfreitag
    static final int EASTER_SUNDAY           = 211;
    static final int EASTER_MONDAY           = 212;
    static final int EASTER_TUESDAY          = 213;
    static final int QUASIMODOGENITI         = 214;     // First EvangelicSunday after Easter
    static final int MISERICORDIAS           = 215;     // Second EvangelicSunday after Easter
    static final int JUBILATE                = 216;     // Third EvangelicSunday after Easter
    static final int CANTATE                 = 217;     // Fourth EvangelicSunday after Easter
    static final int ROGATE                  = 218;     // Fifth EvangelicSunday after Easter
    static final int ASCENSION               = 219;     // Himmelfahrt
    static final int EXAUDI                  = 220;     // Sixth EvangelicSunday after Easter
    static final int PENTECOST_SUNDAY        = 221;     // Whit EvangelicSunday
    static final int PENTECOST_MONDAY        = 222;     // Whit Monday
    static final int PENTECOST_TUESDAY       = 223;     // Whit Tuesday
    static final int TRINITY                 = 300;
    static final int TRINITY_I               = 301;
    static final int TRINITY_II              = 302;
    static final int TRINITY_III             = 303;
    static final int TRINITY_IV              = 304;
    static final int TRINITY_V               = 305;
    static final int TRINITY_VI              = 306;
    static final int TRINITY_VII             = 307;
    static final int TRINITY_VIII            = 308;
    static final int TRINITY_IX              = 309;
    static final int TRINITY_X               = 310;
    static final int TRINITY_XI              = 311;
    static final int TRINITY_XII             = 312;
    static final int TRINITY_XIII            = 313;
    static final int TRINITY_XIV             = 314;
    static final int TRINITY_XV              = 315;
    static final int TRINITY_XVI             = 316;
    static final int TRINITY_XVII            = 317;
    static final int TRINITY_XVIII           = 318;
    static final int TRINITY_XIX             = 319;
    static final int TRINITY_XX              = 320;
    static final int TRINITY_XXI             = 321;
    static final int TRINITY_XXII            = 322;
    static final int TRINITY_XXIII           = 323;
    static final int TRINITY_XXIV            = 324;
    static final int TRINITY_XXV             = 325;
    static final int TRINITY_XXVI            = 326;
    static final int TRINITY_XXVII           = 327;
    static final int PURIFICATION            = 401;     // 2. Feb. = Praesentatione Domini (Darstellung des Herrn) = "Maria Lichtmess"
    static final int ANNUNCIATION            = 402;     // 25. March = Annuntiationae Domini (Verkündigung des Herrn)
    static final int JOHANNIS                = 403;     // 24. June
    static final int VISITATION              = 404;     // 2. Juli
    static final int MICHAELIS               = 405;     // 29. Sept.
    static final int REFORMATION             = 406;     // 31. Oct.
    static final int FUNERAL                 = 407;
    static final int WEDDING                 = 408;
    static final int RATSWECHSEL             = 409;
    static final int BIRTHDAY                = 410;
    static final int UNKNOWN                 = 0;

    // Declare the @ StringDef for these constants:
    @IntDef({
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
            RATSWECHSEL,
            BIRTHDAY,
            UNKNOWN,
    })

    @Retention(RetentionPolicy.SOURCE)
    public @interface Sunday {}

    @Sunday
    static int fromName(String name) {
        if (name == null) {
            return EvangelicSundayAnnotation.UNKNOWN;
        }
        switch (name) {
            case "ADVENT_I":                return EvangelicSundayAnnotation.ADVENT_I;
            case "ADVENT_II":               return EvangelicSundayAnnotation.ADVENT_II;
            case "ADVENT_III":              return EvangelicSundayAnnotation.ADVENT_III;
            case "ADVENT_IV":               return EvangelicSundayAnnotation.ADVENT_IV;
            case "CHRISTMAS_DAY_1":         return EvangelicSundayAnnotation.CHRISTMAS_DAY_1;
            case "CHRISTMAS_DAY_2":         return EvangelicSundayAnnotation.CHRISTMAS_DAY_2;
            case "CHRISTMAS_DAY_3":         return EvangelicSundayAnnotation.CHRISTMAS_DAY_3;
            case "AFTER_CHRISTMAS":         return EvangelicSundayAnnotation.AFTER_CHRISTMAS;
            case "NEW_YEAR":                return EvangelicSundayAnnotation.NEW_YEAR;
            case "AFTER_NEW_YEAR":          return EvangelicSundayAnnotation.AFTER_NEW_YEAR;
            case "EPIPHANY":                return EvangelicSundayAnnotation.EPIPHANY;
            case "EPIPHANY_I":              return EvangelicSundayAnnotation.EPIPHANY_I;
            case "EPIPHANY_II":             return EvangelicSundayAnnotation.EPIPHANY_II;
            case "EPIPHANY_III":            return EvangelicSundayAnnotation.EPIPHANY_III;
            case "EPIPHANY_IV":             return EvangelicSundayAnnotation.EPIPHANY_IV;
            case "EPIPHANY_V":              return EvangelicSundayAnnotation.EPIPHANY_V;
            case "EPIPHANY_VI":             return EvangelicSundayAnnotation.EPIPHANY_VI;
            case "SEPTUAGESIMA":            return EvangelicSundayAnnotation.SEPTUAGESIMA;
            case "SEXAGESIMA":              return EvangelicSundayAnnotation.SEXAGESIMA;
            case "ESTOMIHI":                return EvangelicSundayAnnotation.ESTOMIHI;
            case "ASH_WEDNESDAY":           return EvangelicSundayAnnotation.ASH_WEDNESDAY;
            case "INVOCABIT":               return EvangelicSundayAnnotation.INVOCABIT;
            case "REMINISCERE":             return EvangelicSundayAnnotation.REMINISCERE;
            case "OCULI":                   return EvangelicSundayAnnotation.OCULI;
            case "LAETARE":                 return EvangelicSundayAnnotation.LAETARE;
            case "JUDICA":                  return EvangelicSundayAnnotation.JUDICA;
            case "PALMARUM":                return EvangelicSundayAnnotation.PALMARUM;
            case "GOOD_FRIDAY":             return EvangelicSundayAnnotation.GOOD_FRIDAY;
            case "EASTER_SUNDAY":           return EvangelicSundayAnnotation.EASTER_SUNDAY;
            case "EASTER_MONDAY":           return EvangelicSundayAnnotation.EASTER_MONDAY;
            case "EASTER_TUESDAY":          return EvangelicSundayAnnotation.EASTER_TUESDAY;
            case "QUASIMODOGENITI":         return EvangelicSundayAnnotation.QUASIMODOGENITI;
            case "MISERICORDIAS":           return EvangelicSundayAnnotation.MISERICORDIAS;
            case "JUBILATE":                return EvangelicSundayAnnotation.JUBILATE;
            case "CANTATE":                 return EvangelicSundayAnnotation.CANTATE;
            case "ROGATE":                  return EvangelicSundayAnnotation.ROGATE;
            case "ASCENSION":               return EvangelicSundayAnnotation.ASCENSION;
            case "EXAUDI":                  return EvangelicSundayAnnotation.EXAUDI;
            case "PENTECOST_SUNDAY":        return EvangelicSundayAnnotation.PENTECOST_SUNDAY;
            case "PENTECOST_MONDAY":        return EvangelicSundayAnnotation.PENTECOST_MONDAY;
            case "PENTECOST_TUESDAY":       return EvangelicSundayAnnotation.PENTECOST_TUESDAY;
            case "TRINITY":                 return EvangelicSundayAnnotation.TRINITY;
            case "TRINITY_I":               return EvangelicSundayAnnotation.TRINITY_I;
            case "TRINITY_II":              return EvangelicSundayAnnotation.TRINITY_II;
            case "TRINITY_III":             return EvangelicSundayAnnotation.TRINITY_III;
            case "TRINITY_IV":              return EvangelicSundayAnnotation.TRINITY_IV;
            case "TRINITY_V":               return EvangelicSundayAnnotation.TRINITY_V;
            case "TRINITY_VI":              return EvangelicSundayAnnotation.TRINITY_VI;
            case "TRINITY_VII":             return EvangelicSundayAnnotation.TRINITY_VII;
            case "TRINITY_VIII":            return EvangelicSundayAnnotation.TRINITY_VIII;
            case "TRINITY_IX":              return EvangelicSundayAnnotation.TRINITY_IX;
            case "TRINITY_X":               return EvangelicSundayAnnotation.TRINITY_X;
            case "TRINITY_XI":              return EvangelicSundayAnnotation.TRINITY_XI;
            case "TRINITY_XII":             return EvangelicSundayAnnotation.TRINITY_XII;
            case "TRINITY_XIII":            return EvangelicSundayAnnotation.TRINITY_XIII;
            case "TRINITY_XIV":             return EvangelicSundayAnnotation.TRINITY_XIV;
            case "TRINITY_XV":              return EvangelicSundayAnnotation.TRINITY_XV;
            case "TRINITY_XVI":             return EvangelicSundayAnnotation.TRINITY_XVI;
            case "TRINITY_XVII":            return EvangelicSundayAnnotation.TRINITY_XVII;
            case "TRINITY_XVIII":           return EvangelicSundayAnnotation.TRINITY_XVIII;
            case "TRINITY_XIX":             return EvangelicSundayAnnotation.TRINITY_XIX;
            case "TRINITY_XX":              return EvangelicSundayAnnotation.TRINITY_XX;
            case "TRINITY_XXI":             return EvangelicSundayAnnotation.TRINITY_XXI;
            case "TRINITY_XXII":            return EvangelicSundayAnnotation.TRINITY_XXII;
            case "TRINITY_XXIII":           return EvangelicSundayAnnotation.TRINITY_XXIII;
            case "TRINITY_XXIV":            return EvangelicSundayAnnotation.TRINITY_XXIV;
            case "TRINITY_XXV":             return EvangelicSundayAnnotation.TRINITY_XXV;
            case "TRINITY_XXVI":            return EvangelicSundayAnnotation.TRINITY_XXVI;
            case "TRINITY_XXVII":           return EvangelicSundayAnnotation.TRINITY_XXVII;
            case "PURIFICATION":            return EvangelicSundayAnnotation.PURIFICATION;
            case "ANNUNCIATION":            return EvangelicSundayAnnotation.ANNUNCIATION;
            case "JOHANNIS":                return EvangelicSundayAnnotation.JOHANNIS;
            case "VISITATION":              return EvangelicSundayAnnotation.VISITATION;
            case "MICHAELIS":               return EvangelicSundayAnnotation.MICHAELIS;
            case "REFORMATION":             return EvangelicSundayAnnotation.REFORMATION;
            case "FUNERAL":                 return EvangelicSundayAnnotation.FUNERAL;
            case "WEDDING":                 return EvangelicSundayAnnotation.WEDDING;
            case "RATSWECHSEL":             return EvangelicSundayAnnotation.RATSWECHSEL;
            case "BIRTHDAY":                return EvangelicSundayAnnotation.BIRTHDAY;
            case "UNKNOWN":
            case "OTHER":                   return EvangelicSundayAnnotation.UNKNOWN;
            default:
                throw new InvalidParameterException("The Sunday " + name + " is invalid.");
        }
    }
}


