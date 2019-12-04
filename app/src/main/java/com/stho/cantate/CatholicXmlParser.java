package com.stho.cantate;

import android.util.SparseArray;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.HashMap;

/*
  See: https://medium.com/@ssaurel/parsing-xml-data-in-android-apps-71ef607fbb16
 */
class CatholicXmlParser {

    private final SparseArray<CatholicDominica> catholic;

    CatholicXmlParser(SparseArray<CatholicDominica> catholic) {
        this.catholic = catholic;
    }

    void process(XmlPullParser parser) throws IOException, XmlPullParserException {
        int eventType = parser.getEventType();
        CatholicDominica currentDominica = null;
        String tag = null;
        String year = null;

        while (eventType != XmlPullParser.END_DOCUMENT) {

            switch (eventType) {
                case XmlPullParser.START_TAG:
                    tag = parser.getName();
                    if (isCatholic(tag)) {
                        String key = getAttributeValue(parser, "Key");
                        String name = getAttributeValue(parser, "Name");
                        String tempus = getAttributeValue(parser, "Tempus");
                        String friendlyName = getAttributeValue(parser, "FriendlyName");
                        @CatholicDominicaAnnotation.Dominica int dominica = CatholicDominicaAnnotation.fromName(key);
                        currentDominica = catholic.get(dominica);
                        if (currentDominica == null) {
                            currentDominica = new CatholicDominica(dominica, name, tempus);
                            catholic.put(dominica, currentDominica);
                        }
                        if (friendlyName != null) {
                            currentDominica.setFriendlyName(friendlyName);
                        }
                    }
                    if (isIntroitus(tag) || isCommunio(tag)) {
                       year = getAttributeValue(parser, "Anno");
                    }
                    break;

                case XmlPullParser.TEXT:
                    if (currentDominica != null) {
                        if (isIntroitus(tag)) {
                            currentDominica.setIntroitus(parser.getText(), year);
                        } else if (isCommunio(tag)) {
                            currentDominica.setCommunio(parser.getText(), year);
                        } else if (isLink(tag)) {
                            currentDominica.setLink(parser.getText());
                        } else if (isGraduale(tag) || isAntiphon(tag) || isVaria(tag) || isTractus(tag) ||isAlleluia(tag))
                            currentDominica.setOthers(tag, parser.getText());
                    }
                    break;

                default:
                    tag = null;
                    year = null;
                    break;
            }

            eventType = parser.next();
        }
    }

    private boolean isCatholic(String tag) {
        return "Catholic".equalsIgnoreCase(tag);
    }

    private boolean isIntroitus(String tag) {
        return "Introitus".equalsIgnoreCase(tag);
    }

    private boolean isCommunio(String tag) {
        return "Communio".equalsIgnoreCase(tag);
    }

    private boolean isLink(String tag) {
        return "Link".equalsIgnoreCase(tag);
    }

    private boolean isGraduale(String tag) {
        return "Graduale".equalsIgnoreCase(tag);
    }

    private boolean isTractus(String tag) {
        return "Tractus".equalsIgnoreCase(tag);
    }

    private boolean isAntiphon(String tag) {
        return "Antiphon".equalsIgnoreCase(tag);
    }

    private boolean isVaria(String tag) {
        return "Varia".equalsIgnoreCase(tag);
    }

    private boolean isAlleluia(String tag) {
        return "Alleluia".equalsIgnoreCase(tag);
    }

    private String getAttributeValue(XmlPullParser parser, String attributeName) {
        for (int i = 0; i < parser.getAttributeCount(); i++) {
            if (attributeName.equalsIgnoreCase(parser.getAttributeName(i))) {
                return parser.getAttributeValue(i);
            }
        }
        return null;
    }
}
