package com.stho.cantate;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.security.InvalidParameterException;

/*
  https://www.erzabtei-beuron.de/schott/schott_anz/index.html?datum=2019-11-24
  https://gregorien.info/de
 */
class CatholicDominicaAnnotation {

    static final int HEBDOMADA_I_ADVENTUS                           = 1;
    static final int HEBDOMADA_II_ADVENTUS                          = 2;
    static final int HEBDOMADA_III_ADVENTUS                         = 3;
    static final int HEBDOMADA_IV_ADVENTUS                          = 4;
    static final int IN_VIGILIA_NATIVITATIS_DOMINI                  = 5;            // 24. Dec., Christnacht
    static final int IN_NATIVITATE_DOMINI                           = 6;            // 25. Dec., Weihnachten
    static final int SANCTI_STEPHANI_PROTOMARTYRIS                  = 7;            // 26. Dec.
    static final int SANCTAE_FAMILIAE                               = 8;            // 30. Dec, Heilige Familie, 1. Sonntag nach Weihnachten
    static final int SILVESTER                                      = 9;
    static final int SOLLEMNITAS_SANCTAE_DEI_GENETRICIS_MARIAE      = 10;           // 1. Jan., New Year
    static final int DOMINICA_II_POST_NATIVITATEM                   = 11;           // 2. Sunday after Christmas
    static final int IN_EPIPHANIA_DOMINI                            = 12;           // 6. Jan.
    static final int IN_BAPTISMATE_DOMINI                           = 13;           // Taufe des Herrn = Sonntag nach 6. Jan. Epiphanie
    static final int CINERUM                                        = 21;           // Ash Wednesday
    static final int HEBDOMADA_I_QUADRAGESIMAE                      = 22;           // 1st week in Lent - INVOCABIT
    static final int HEBDOMADA_II_QUADRAGESIMAE                     = 23;           // 2st week in Lent - REMINISCERE
    static final int HEBDOMADA_III_QUADRAGESIMAE                    = 24;           // 3st week in Lent - OCULI
    static final int HEBDOMADA_IV_QUADRAGESIMAE                     = 25;           // 4st week in Lent - LAETARE
    static final int HEBDOMADA_V_QUADRAGESIMAE                      = 26;           // 5st week in Lent - JUDICA
    static final int DOMINICA_IN_PALMIS_DE_PASSIONE_DOMINI          = 27;           // 6st week in Lent - PALMARUM, Palmsonntag
    static final int IN_CENA_DOMINE                                 = 28;           // Gründonnerstag, Mahl des Herrn, Fußwaschung
    static final int ADORATIO_SANCTAE_CRUCIS                        = 30;           // Karfreitag, Kreuzverehrung
    static final int VIGILIAM_PASCHALEM                             = 31;           // Osternacht
    static final int DOMINICA_RESURRECTIONIS                        = 32;           // Ostern, Auferstehung
    static final int FERIA_II_INFRA_OCTAVAM_PASCHAE                 = 33;           // Ostermontag, Thomas
    static final int FERIA_III_INFRA_OCTAVAM_PASCHAE                = 34;           // Osterdienstag
    static final int HEBDOMADA_II_PASCHAE                           = 40;           // CatholicDominica Secunda Paschae, First EvangelicSunday after Easter, Weißer Sonntag, DOMINICA_IN_ALBES, QUASIMODOGENITI
    static final int HEBDOMADA_III_PASCHAE                          = 41;           // Second EvangelicSunday after Easter, JUBILATE
    static final int HEBDOMADA_IV_PASCHAE                           = 42;           // Third EvangelicSunday after Easter, MISERICORDIA
    static final int HEBDOMADA_V_PASCHAE                            = 43;           // Fourth EvangelicSunday after Easter, CANTATE
    static final int HEBDOMADA_VI_PASCHAE                           = 44;           // Fifth EvangelicSunday after Easter, ROGATE
    static final int IN_ASCENSIONE_DOMINI                           = 45;           // Himmelfahrt
    static final int HEBDOMADA_VII_PASCHAE                          = 46;           // Sixth EvangelicSunday after Easter, EXAUDI
    static final int DOMINICA_PENTECOSTES                           = 47;           // Pfingsten
    static final int SANCTISSIMAE_TRINITATIS                        = 48;
    static final int DOMINICA_II_PER_ANNUM                          = 102;
    static final int DOMINICA_III_PER_ANNUM                         = 103;
    static final int DOMINICA_IV_PER_ANNUM                          = 104;
    static final int DOMINICA_V_PER_ANNUM                           = 105;
    static final int DOMINICA_VI_PER_ANNUM                          = 106;
    static final int DOMINICA_VII_PER_ANNUM                         = 107;
    static final int DOMINICA_VIII_PER_ANNUM                        = 108;
    static final int DOMINICA_IX_PER_ANNUM                          = 109;
    static final int DOMINICA_X_PER_ANNUM                           = 110;
    static final int DOMINICA_XI_PER_ANNUM                          = 111;
    static final int DOMINICA_XII_PER_ANNUM                         = 112;
    static final int DOMINICA_XIII_PER_ANNUM                        = 113;
    static final int DOMINICA_XIV_PER_ANNUM                         = 114;
    static final int DOMINICA_XV_PER_ANNUM                          = 115;
    static final int DOMINICA_XVI_PER_ANNUM                         = 116;
    static final int DOMINICA_XVII_PER_ANNUM                        = 117;
    static final int DOMINICA_XVIII_PER_ANNUM                       = 118;
    static final int DOMINICA_XIX_PER_ANNUM                         = 119;
    static final int DOMINICA_XX_PER_ANNUM                          = 120;
    static final int DOMINICA_XXI_PER_ANNUM                         = 121;
    static final int DOMINICA_XXII_PER_ANNUM                        = 122;
    static final int DOMINICA_XXIII_PER_ANNUM                       = 123;
    static final int DOMINICA_XXIV_PER_ANNUM                        = 124;
    static final int DOMINICA_XXV_PER_ANNUM                         = 125;
    static final int DOMINICA_XXVI_PER_ANNUM                        = 126;
    static final int DOMINICA_XXVII_PER_ANNUM                       = 127;
    static final int DOMINICA_XXVIII_PER_ANNUM                      = 128;
    static final int DOMINICA_XXIX_PER_ANNUM                        = 129;
    static final int DOMINICA_XXX_PER_ANNUM                         = 130;
    static final int DOMINICA_XXXI_PER_ANNUM                        = 131;
    static final int DOMINICA_XXXII_PER_ANNUM                       = 132;
    static final int DOMINICA_XXXIII_PER_ANNUM                      = 133;
    static final int OMNIUM_SANCTORUM                               = 134;          // 1. Nov
    static final int OMNIUM_FIDELIUM_DEFUNCTORUM                    = 135;          // 2. Nov --> MISSA PRO DEFUNCTIS
    static final int DOMINICA_ULTIMA_PER_ANNUM                      = 136;          // Christkönig = Domino Nostro Iesu Christi Universorum Regis
    static final int IN_ASSUMPTIONE_BEATAE_MARIAE_VIRGINIS          = 137;          // 15. August
    static final int OTHER                                          = 0;


    @IntDef({
            HEBDOMADA_I_ADVENTUS,
            HEBDOMADA_II_ADVENTUS,
            HEBDOMADA_III_ADVENTUS,
            HEBDOMADA_IV_ADVENTUS,
            IN_VIGILIA_NATIVITATIS_DOMINI,
            IN_NATIVITATE_DOMINI,
            SANCTI_STEPHANI_PROTOMARTYRIS,
            SANCTAE_FAMILIAE,
            SILVESTER,
            SOLLEMNITAS_SANCTAE_DEI_GENETRICIS_MARIAE,
            DOMINICA_II_POST_NATIVITATEM,
            IN_EPIPHANIA_DOMINI,
            IN_BAPTISMATE_DOMINI,
            CINERUM,
            HEBDOMADA_I_QUADRAGESIMAE,
            HEBDOMADA_II_QUADRAGESIMAE,
            HEBDOMADA_III_QUADRAGESIMAE,
            HEBDOMADA_IV_QUADRAGESIMAE,
            HEBDOMADA_V_QUADRAGESIMAE,
            DOMINICA_IN_PALMIS_DE_PASSIONE_DOMINI,
            IN_CENA_DOMINE,
            ADORATIO_SANCTAE_CRUCIS,
            VIGILIAM_PASCHALEM,
            DOMINICA_RESURRECTIONIS,
            FERIA_II_INFRA_OCTAVAM_PASCHAE,
            FERIA_III_INFRA_OCTAVAM_PASCHAE,
            HEBDOMADA_II_PASCHAE,
            HEBDOMADA_III_PASCHAE,
            HEBDOMADA_IV_PASCHAE,
            HEBDOMADA_V_PASCHAE,
            HEBDOMADA_VI_PASCHAE,
            IN_ASCENSIONE_DOMINI,
            HEBDOMADA_VII_PASCHAE,
            DOMINICA_PENTECOSTES,
            SANCTISSIMAE_TRINITATIS,
            DOMINICA_II_PER_ANNUM,
            DOMINICA_III_PER_ANNUM,
            DOMINICA_IV_PER_ANNUM,
            DOMINICA_V_PER_ANNUM,
            DOMINICA_VI_PER_ANNUM,
            DOMINICA_VII_PER_ANNUM,
            DOMINICA_VIII_PER_ANNUM,
            DOMINICA_IX_PER_ANNUM,
            DOMINICA_X_PER_ANNUM,
            DOMINICA_XI_PER_ANNUM,
            DOMINICA_XII_PER_ANNUM,
            DOMINICA_XIII_PER_ANNUM,
            DOMINICA_XIV_PER_ANNUM,
            DOMINICA_XV_PER_ANNUM,
            DOMINICA_XVI_PER_ANNUM,
            DOMINICA_XVII_PER_ANNUM,
            DOMINICA_XVIII_PER_ANNUM,
            DOMINICA_XIX_PER_ANNUM,
            DOMINICA_XX_PER_ANNUM,
            DOMINICA_XXI_PER_ANNUM,
            DOMINICA_XXII_PER_ANNUM,
            DOMINICA_XXIII_PER_ANNUM,
            DOMINICA_XXIV_PER_ANNUM,
            DOMINICA_XXV_PER_ANNUM,
            DOMINICA_XXVI_PER_ANNUM,
            DOMINICA_XXVII_PER_ANNUM,
            DOMINICA_XXVIII_PER_ANNUM,
            DOMINICA_XXIX_PER_ANNUM,
            DOMINICA_XXX_PER_ANNUM,
            DOMINICA_XXXI_PER_ANNUM,
            DOMINICA_XXXII_PER_ANNUM,
            DOMINICA_XXXIII_PER_ANNUM,
            DOMINICA_ULTIMA_PER_ANNUM,
            OMNIUM_SANCTORUM,
            OMNIUM_FIDELIUM_DEFUNCTORUM,
            IN_ASSUMPTIONE_BEATAE_MARIAE_VIRGINIS,
            OTHER,
    })

    @Retention(RetentionPolicy.SOURCE)
    @interface Dominica {}

    @Dominica
    static int fromName(String name) throws InvalidParameterException {
        if (name == null) {
            return CatholicDominicaAnnotation.OTHER;
        }
        switch (name) {
            case "HEBDOMADA_I_ADVENTUS":                        return CatholicDominicaAnnotation.HEBDOMADA_I_ADVENTUS;
            case "HEBDOMADA_II_ADVENTUS":                       return CatholicDominicaAnnotation.HEBDOMADA_II_ADVENTUS;
            case "HEBDOMADA_III_ADVENTUS":                      return CatholicDominicaAnnotation.HEBDOMADA_III_ADVENTUS;
            case "HEBDOMADA_IV_ADVENTUS":                       return CatholicDominicaAnnotation.HEBDOMADA_IV_ADVENTUS;
            case "IN_VIGILIA_NATIVITATIS_DOMINI":               return CatholicDominicaAnnotation.IN_VIGILIA_NATIVITATIS_DOMINI;
            case "IN_NATIVITATE_DOMINI":                        return CatholicDominicaAnnotation.IN_NATIVITATE_DOMINI;
            case "SANCTI_STEPHANI_PROTOMARTYRIS":               return CatholicDominicaAnnotation.SANCTI_STEPHANI_PROTOMARTYRIS;
            case "SANCTAE_FAMILIAE":                            return CatholicDominicaAnnotation.SANCTAE_FAMILIAE;
            case "SILVESTER":                                   return CatholicDominicaAnnotation.SILVESTER;
            case "SOLLEMNITAS_SANCTAE_DEI_GENETRICIS_MARIAE":   return CatholicDominicaAnnotation.SOLLEMNITAS_SANCTAE_DEI_GENETRICIS_MARIAE;
            case "DOMINICA_II_POST_NATIVITATEM":                return CatholicDominicaAnnotation.DOMINICA_II_POST_NATIVITATEM;
            case "IN_EPIPHANIA_DOMINI":                         return CatholicDominicaAnnotation.IN_EPIPHANIA_DOMINI;
            case "IN_BAPTISMATE_DOMINI":                        return CatholicDominicaAnnotation.IN_BAPTISMATE_DOMINI;
            case "CINERUM":                                     return CatholicDominicaAnnotation.CINERUM;
            case "HEBDOMADA_I_QUADRAGESIMAE":                   return CatholicDominicaAnnotation.HEBDOMADA_I_QUADRAGESIMAE;
            case "HEBDOMADA_II_QUADRAGESIMAE":                  return CatholicDominicaAnnotation.HEBDOMADA_II_QUADRAGESIMAE;
            case "HEBDOMADA_III_QUADRAGESIMAE":                 return CatholicDominicaAnnotation.HEBDOMADA_III_QUADRAGESIMAE;
            case "HEBDOMADA_IV_QUADRAGESIMAE":                  return CatholicDominicaAnnotation.HEBDOMADA_IV_QUADRAGESIMAE;
            case "HEBDOMADA_V_QUADRAGESIMAE":                   return CatholicDominicaAnnotation.HEBDOMADA_V_QUADRAGESIMAE;
            case "DOMINICA_IN_PALMIS_DE_PASSIONE_DOMINI":       return CatholicDominicaAnnotation.DOMINICA_IN_PALMIS_DE_PASSIONE_DOMINI;
            case "IN_CENA_DOMINE":                              return CatholicDominicaAnnotation.IN_CENA_DOMINE;
            case "ADORATIO_SANCTAE_CRUCIS":                     return CatholicDominicaAnnotation.ADORATIO_SANCTAE_CRUCIS;
            case "VIGILIAM_PASCHALEM":                          return CatholicDominicaAnnotation.VIGILIAM_PASCHALEM;
            case "DOMINICA_RESURRECTIONIS":                     return CatholicDominicaAnnotation.DOMINICA_RESURRECTIONIS;
            case "FERIA_II_INFRA_OCTAVAM_PASCHAE":              return CatholicDominicaAnnotation.FERIA_II_INFRA_OCTAVAM_PASCHAE;
            case "FERIA_III_INFRA_OCTAVAM_PASCHAE":             return CatholicDominicaAnnotation.FERIA_III_INFRA_OCTAVAM_PASCHAE;
            case "HEBDOMADA_II_PASCHAE":                        return CatholicDominicaAnnotation.HEBDOMADA_II_PASCHAE;
            case "HEBDOMADA_III_PASCHAE":                       return CatholicDominicaAnnotation.HEBDOMADA_III_PASCHAE;
            case "HEBDOMADA_IV_PASCHAE":                        return CatholicDominicaAnnotation.HEBDOMADA_IV_PASCHAE;
            case "HEBDOMADA_V_PASCHAE":                         return CatholicDominicaAnnotation.HEBDOMADA_V_PASCHAE;
            case "HEBDOMADA_VI_PASCHAE":                        return CatholicDominicaAnnotation.HEBDOMADA_VI_PASCHAE;
            case "IN_ASCENSIONE_DOMINI":                        return CatholicDominicaAnnotation.IN_ASCENSIONE_DOMINI;
            case "HEBDOMADA_VII_PASCHAE":                       return CatholicDominicaAnnotation.HEBDOMADA_VII_PASCHAE;
            case "DOMINICA_PENTECOSTES":                        return CatholicDominicaAnnotation.DOMINICA_PENTECOSTES;
            case "SANCTISSIMAE_TRINITATIS":                     return CatholicDominicaAnnotation.SANCTISSIMAE_TRINITATIS;
            case "DOMINICA_II_PER_ANNUM":                       return CatholicDominicaAnnotation.DOMINICA_II_PER_ANNUM;
            case "DOMINICA_III_PER_ANNUM":                      return CatholicDominicaAnnotation.DOMINICA_III_PER_ANNUM;
            case "DOMINICA_IV_PER_ANNUM":                       return CatholicDominicaAnnotation.DOMINICA_IV_PER_ANNUM;
            case "DOMINICA_V_PER_ANNUM":                        return CatholicDominicaAnnotation.DOMINICA_V_PER_ANNUM;
            case "DOMINICA_VI_PER_ANNUM":                       return CatholicDominicaAnnotation.DOMINICA_VI_PER_ANNUM;
            case "DOMINICA_VII_PER_ANNUM":                      return CatholicDominicaAnnotation.DOMINICA_VII_PER_ANNUM;
            case "DOMINICA_VIII_PER_ANNUM":                     return CatholicDominicaAnnotation.DOMINICA_VIII_PER_ANNUM;
            case "DOMINICA_IX_PER_ANNUM":                       return CatholicDominicaAnnotation.DOMINICA_IX_PER_ANNUM;
            case "DOMINICA_X_PER_ANNUM":                        return CatholicDominicaAnnotation.DOMINICA_X_PER_ANNUM;
            case "DOMINICA_XI_PER_ANNUM":                       return CatholicDominicaAnnotation.DOMINICA_XI_PER_ANNUM;
            case "DOMINICA_XII_PER_ANNUM":                      return CatholicDominicaAnnotation.DOMINICA_XII_PER_ANNUM;
            case "DOMINICA_XIII_PER_ANNUM":                     return CatholicDominicaAnnotation.DOMINICA_XIII_PER_ANNUM;
            case "DOMINICA_XIV_PER_ANNUM":                      return CatholicDominicaAnnotation.DOMINICA_XIV_PER_ANNUM;
            case "DOMINICA_XV_PER_ANNUM":                       return CatholicDominicaAnnotation.DOMINICA_XV_PER_ANNUM;
            case "DOMINICA_XVI_PER_ANNUM":                      return CatholicDominicaAnnotation.DOMINICA_XVI_PER_ANNUM;
            case "DOMINICA_XVII_PER_ANNUM":                     return CatholicDominicaAnnotation.DOMINICA_XVII_PER_ANNUM;
            case "DOMINICA_XVIII_PER_ANNUM":                    return CatholicDominicaAnnotation.DOMINICA_XVIII_PER_ANNUM;
            case "DOMINICA_XIX_PER_ANNUM":                      return CatholicDominicaAnnotation.DOMINICA_XIX_PER_ANNUM;
            case "DOMINICA_XX_PER_ANNUM":                       return CatholicDominicaAnnotation.DOMINICA_XX_PER_ANNUM;
            case "DOMINICA_XXI_PER_ANNUM":                      return CatholicDominicaAnnotation.DOMINICA_XXI_PER_ANNUM;
            case "DOMINICA_XXII_PER_ANNUM":                     return CatholicDominicaAnnotation.DOMINICA_XXII_PER_ANNUM;
            case "DOMINICA_XXIII_PER_ANNUM":                    return CatholicDominicaAnnotation.DOMINICA_XXIII_PER_ANNUM;
            case "DOMINICA_XXIV_PER_ANNUM":                     return CatholicDominicaAnnotation.DOMINICA_XXIV_PER_ANNUM;
            case "DOMINICA_XXV_PER_ANNUM":                      return CatholicDominicaAnnotation.DOMINICA_XXV_PER_ANNUM;
            case "DOMINICA_XXVI_PER_ANNUM":                     return CatholicDominicaAnnotation.DOMINICA_XXVI_PER_ANNUM;
            case "DOMINICA_XXVII_PER_ANNUM":                    return CatholicDominicaAnnotation.DOMINICA_XXVII_PER_ANNUM;
            case "DOMINICA_XXVIII_PER_ANNUM":                   return CatholicDominicaAnnotation.DOMINICA_XXVIII_PER_ANNUM;
            case "DOMINICA_XXIX_PER_ANNUM":                     return CatholicDominicaAnnotation.DOMINICA_XXIX_PER_ANNUM;
            case "DOMINICA_XXX_PER_ANNUM":                      return CatholicDominicaAnnotation.DOMINICA_XXX_PER_ANNUM;
            case "DOMINICA_XXXI_PER_ANNUM":                     return CatholicDominicaAnnotation.DOMINICA_XXXI_PER_ANNUM;
            case "DOMINICA_XXXII_PER_ANNUM":                    return CatholicDominicaAnnotation.DOMINICA_XXXII_PER_ANNUM;
            case "DOMINICA_XXXIII_PER_ANNUM":                   return CatholicDominicaAnnotation.DOMINICA_XXXIII_PER_ANNUM;
            case "OMNIUM_SANCTORUM":                            return CatholicDominicaAnnotation.OMNIUM_SANCTORUM;
            case "OMNIUM_FIDELIUM_DEFUNCTORUM":                 return CatholicDominicaAnnotation.OMNIUM_FIDELIUM_DEFUNCTORUM;
            case "DOMINICA_ULTIMA_PER_ANNUM":                   return CatholicDominicaAnnotation.DOMINICA_ULTIMA_PER_ANNUM;
            case "IN_ASSUMPTIONE_BEATAE_MARIAE_VIRGINIS":       return CatholicDominicaAnnotation.IN_ASSUMPTIONE_BEATAE_MARIAE_VIRGINIS;
            case "OTHER":                                       return CatholicDominicaAnnotation.OTHER;
            default:
                throw new InvalidParameterException("The Dominica " + name + " is invalid.");
        }
    }
 }
