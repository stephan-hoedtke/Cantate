package com.stho.cantate;

import androidx.annotation.IntDef;
import androidx.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*
  https://www.erzabtei-beuron.de/schott/schott_anz/index.html?datum=2019-11-24
 */
class DominicaAnnotation {

    static final String HEBDOMADA_I_ADVENTUS                           = "HEBDOMADA_I_ADVENTUS";
    static final String HEBDOMADA_II_ADVENTUS                          = "HEBDOMADA_II_ADVENTUS";
    static final String HEBDOMADA_III_ADVENTUS                         = "HEBDOMADA_III_ADVENTUS";
    static final String HEBDOMADA_IV_ADVENTUS                          = "HEBDOMADA_IV_ADVENTUS";
    static final String IN_VIGILIA_NATIVITATIS_DOMINI                  = "IN_VIGILIA_NATIVITATIS_DOMINI";               // Christnacht
    static final String IN_NATIVITATE_DOMINI                           = "IN_NATIVITATE_DOMINI";                        // 25. Dec., Weihnachten
    static final String SANCTI_STEPHANI_PROTOMARTYRIS                  = "SANCTI_STEPHANI_PROTOMARTYRIS";               // 26. Dec.
    static final String SANCTAE_FAMILIAE                               = "SANCTAE_FAMILIAE";                            // Heilige Familie, 1. Sonntag nach Weihnachten
    static final String SILVESTER                                      = "SILVESTER";
    static final String SOLLEMNITAS_SANCTAE_DEI_GENETRICIS_MARIAE      = "SOLLEMNITAS_SANCTAE_DEI_GENETRICIS_MARIAE";   // 1. Jan., New Year
    static final String DOMINICA_II_POST_NATIVITATEM                   = "DOMINICA_II_POST_NATIVITATEM";                // 2nd Sunday after Christmas
    static final String IN_EPIPHANIA_DOMINI                            = "IN_EPIPHANIA_DOMINI";                         // 6. Jan.
    static final String IN_BAPTISMATE_DOMINI                           = "IN_BAPTISMATE_DOMINI";                        // Taufe des Herrn = Sonntag nach 6. Jan. Epiphanie
    static final String CINERUM                                        = "CINERUM";                                     // Ash Wednesday
    static final String HEBDOMADA_I_QUADRAGESIMAE                      = "HEBDOMADA_I_QUADRAGESIMAE";                   // 1st week in Lent - INVOCABIT
    static final String HEBDOMADA_II_QUADRAGESIMAE                     = "HEBDOMADA_II_QUADRAGESIMAE";                  // 2st week in Lent - REMINISCERE
    static final String HEBDOMADA_III_QUADRAGESIMAE                    = "HEBDOMADA_III_QUADRAGESIMAE";                 // 3st week in Lent - OCULI
    static final String HEBDOMADA_IV_QUADRAGESIMAE                     = "HEBDOMADA_IV_QUADRAGESIMAE";                  // 4st week in Lent - LAETARE
    static final String HEBDOMADA_V_QUADRAGESIMAE                      = "HEBDOMADA_V_QUADRAGESIMAE";                   // 5st week in Lent - JUDICA
    static final String DOMINICA_IN_PALMIS_DE_PASSIONE_DOMINI          = "DOMINICA_IN_PALMIS_DE_PASSIONE_DOMINI";       // 6st week in Lent - PALMARUM, Palmsonntag
    static final String IN_CENA_DOMINE                                 = "IN_CENA_DOMINE";                              // Gründonnerstag, Mahl des Herrn, Fußwaschung
    static final String ADORATIO_SANCTAE_CRUCIS                        = "ADORATIO_SANCTAE_CRUCIS";                     // Karfreitag, Kreuzverehrung
    static final String VIGILIAM_PASCHALEM                             = "VIGILIAM_PASCHALEM";                          // Osternacht
    static final String DOMINICA_RESURRECTIONIS                        = "DOMINICA_RESURRECTIONIS";                     // Ostern, Auferstehung
    static final String FERIA_II_INFRA_OCTAVAM_PASCHA                  = "FERIA_II_INFRA_OCTAVAM_PASCHA";               // Ostermontag, Thomas
    static final String FERIA_III_INFRA_OCTAVAM_PASCHA                 = "FERIA_III_INFRA_OCTAVAM_PASCHA";              // Osterdienstag
    static final String HEBDOMADA_II_PASCHAE                           = "HEBDOMADA_II_PASCHAE";                        // CatholicDominica Secunda Paschae, First EvangelicSunday after Easter, Weißer Sonntag, DOMINICA_IN_ALBES, QUASIMODOGENITI
    static final String HEBDOMADA_III_PASCHAE                          = "HEBDOMADA_III_PASCHAE";                       // Second EvangelicSunday after Easter, JUBILATE
    static final String HEBDOMADA_IV_PASCHAE                           = "HEBDOMADA_IV_PASCHAE";                        // Third EvangelicSunday after Easter, MISERICORDIA
    static final String HEBDOMADA_V_PASCHAE                            = "HEBDOMADA_V_PASCHAE";                         // Fourth EvangelicSunday after Easter, CANTATE
    static final String HEBDOMADA_VI_PASCHAE                           = "HEBDOMADA_VI_PASCHAE";                        // Fifth EvangelicSunday after Easter, ROGATE
    static final String IN_ASCENSIONE_DOMINI                           = "IN_ASCENSIONE_DOMINI";                        // Himmelfahrt
    static final String HEBDOMADA_VII_PASCHAE                          = "HEBDOMADA_VII_PASCHAE";                       // Sixth EvangelicSunday after Easter, EXAUDI
    static final String DOMINICA_PENTECOSTES                           = "DOMINICA_PENTECOSTES";                        // Pfingsten
    static final String DOMINICA_II_PER_ANNUM                          = "DOMINICA_II_PER_ANNUM";
    static final String DOMINICA_III_PER_ANNUM                         = "DOMINICA_III_PER_ANNUM";
    static final String DOMINICA_IV_PER_ANNUM                          = "DOMINICA_IV_PER_ANNUM";
    static final String DOMINICA_V_PER_ANNUM                           = "DOMINICA_V_PER_ANNUM";
    static final String DOMINICA_VI_PER_ANNUM                          = "DOMINICA_VI_PER_ANNUM";
    static final String DOMINICA_VII_PER_ANNUM                         = "DOMINICA_VII_PER_ANNUM";
    static final String DOMINICA_VIII_PER_ANNUM                        = "DOMINICA_VIII_PER_ANNUM";
    static final String DOMINICA_IX_PER_ANNUM                          = "DOMINICA_IX_PER_ANNUM";
    static final String DOMINICA_X_PER_ANNUM                           = "DOMINICA_X_PER_ANNUM";
    static final String DOMINICA_XI_PER_ANNUM                          = "DOMINICA_XI_PER_ANNUM";
    static final String DOMINICA_XII_PER_ANNUM                         = "DOMINICA_XII_PER_ANNUM";
    static final String DOMINICA_XIII_PER_ANNUM                        = "DOMINICA_XIII_PER_ANNUM";
    static final String DOMINICA_XIV_PER_ANNUM                         = "DOMINICA_XIV_PER_ANNUM";
    static final String DOMINICA_XV_PER_ANNUM                          = "DOMINICA_XV_PER_ANNUM";
    static final String DOMINICA_XVI_PER_ANNUM                         = "DOMINICA_XVI_PER_ANNUM";
    static final String DOMINICA_XVII_PER_ANNUM                        = "DOMINICA_XVII_PER_ANNUM";
    static final String DOMINICA_XVIII_PER_ANNUM                       = "DOMINICA_XVIII_PER_ANNUM";
    static final String DOMINICA_XIX_PER_ANNUM                         = "DOMINICA_XIX_PER_ANNUM";
    static final String DOMINICA_XX_PER_ANNUM                          = "DOMINICA_XX_PER_ANNUM";
    static final String DOMINICA_XXI_PER_ANNUM                         = "DOMINICA_XXI_PER_ANNUM";
    static final String DOMINICA_XXII_PER_ANNUM                        = "DOMINICA_XXII_PER_ANNUM";
    static final String DOMINICA_XXIII_PER_ANNUM                       = "DOMINICA_XXIII_PER_ANNUM";
    static final String DOMINICA_XXIV_PER_ANNUM                        = "DOMINICA_XXIV_PER_ANNUM";
    static final String DOMINICA_XXV_PER_ANNUM                         = "DOMINICA_XXV_PER_ANNUM";
    static final String DOMINICA_XXVI_PER_ANNUM                        = "DOMINICA_XXVI_PER_ANNUM";
    static final String DOMINICA_XXVII_PER_ANNUM                       = "DOMINICA_XXVII_PER_ANNUM";
    static final String DOMINICA_XXVIII_PER_ANNUM                      = "DOMINICA_XXVIII_PER_ANNUM";
    static final String DOMINICA_XXIX_PER_ANNUM                        = "DOMINICA_XXIX_PER_ANNUM";
    static final String DOMINICA_XXX_PER_ANNUM                         = "DOMINICA_XXX_PER_ANNUM";
    static final String DOMINICA_XXXI_PER_ANNUM                        = "DOMINICA_XXXI_PER_ANNUM";
    static final String DOMINICA_XXXII_PER_ANNUM                       = "DOMINICA_XXXII_PER_ANNUM";
    static final String DOMINICA_XXXIII_PER_ANNUM                      = "DOMINICA_XXXIII_PER_ANNUM";
    static final String ALLERHEILIGEN                                  = "ALLERHEILIGEN";
    static final String ALLERSEELEN                                    = "ALLERSEELEN";
    static final String DOMINICA_ULTIMA_PER_ANNUM                      = "DOMINICA_ULTIMA_PER_ANNUM"; // Christkönig = Domino Nostro Iesu Christi Universorum Regis
    static final String OTHER                                          = "OTHER";


    // Declare the @ StringDef for these constants:
    @StringDef({
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
            FERIA_II_INFRA_OCTAVAM_PASCHA,
            FERIA_III_INFRA_OCTAVAM_PASCHA,
            HEBDOMADA_II_PASCHAE,
            HEBDOMADA_III_PASCHAE,
            HEBDOMADA_IV_PASCHAE,
            HEBDOMADA_V_PASCHAE,
            HEBDOMADA_VI_PASCHAE,
            IN_ASCENSIONE_DOMINI,
            HEBDOMADA_VII_PASCHAE,
            DOMINICA_PENTECOSTES,
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
            ALLERHEILIGEN,
            ALLERSEELEN,
            OTHER,
    })
    @Retention(RetentionPolicy.SOURCE)
    @interface Dominica {}
 }
