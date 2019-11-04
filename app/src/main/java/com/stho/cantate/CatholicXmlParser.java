package com.stho.cantate;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.HashMap;

/*
  See: https://medium.com/@ssaurel/parsing-xml-data-in-android-apps-71ef607fbb16
 */
class CatholicXmlParser {

    private final HashMap<String, CatholicDominica> catholic;

    CatholicXmlParser(HashMap<String, CatholicDominica> catholic) {
        this.catholic = catholic;
    }

    void process(XmlPullParser parser) throws IOException, XmlPullParserException {
        int eventType = parser.getEventType();
        CatholicDominica currentDominica = null;
        String tag = null;
        @DominicaAnnotation.Dominica String year = null;

        while (eventType != XmlPullParser.END_DOCUMENT) {

            switch (eventType) {
                case XmlPullParser.START_TAG:
                    tag = parser.getName();
                    if (isCatholic(tag)) {
                        String key = getAttributeValue(parser, "Key");
                        String name = getAttributeValue(parser, "Name");
                        String tempus = getAttributeValue(parser, "Tempus");
                        String friendlyName = getAttributeValue(parser, "FriendlyName");
                        currentDominica = catholic.get(key);
                        if (currentDominica == null) {
                            currentDominica = new CatholicDominica(key, name, tempus);
                            catholic.put(key, currentDominica);
                        }
                        if (friendlyName != null) {
                            currentDominica.setFriendlyName(friendlyName);
                        }
                    }
                    if (isIntroitus(tag)) {
                       year = getAttributeValue(parser, "Year");
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
                        }
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

    private boolean isCatholic(String name) {
        return ("Catholic".equalsIgnoreCase(name));
    }

    private boolean isIntroitus(String tag) {
        return ("Introitus".equalsIgnoreCase(tag));
    }

    private boolean isCommunio(String tag) {
        return ("Communio".equalsIgnoreCase(tag));
    }

    private boolean isLink(String tag) {
        return ("Link".equalsIgnoreCase(tag));
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
