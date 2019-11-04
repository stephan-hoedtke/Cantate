package com.stho.cantate;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.HashMap;

/*
  See: https://medium.com/@ssaurel/parsing-xml-data-in-android-apps-71ef607fbb16
 */
class EvangelicXmlParser {

    private final HashMap<String, EvangelicSunday> evangelic;

    EvangelicXmlParser(HashMap<String, EvangelicSunday> evangelic) {
        this.evangelic = evangelic;
    }

    void process(XmlPullParser parser) throws IOException, XmlPullParserException {
        int eventType = parser.getEventType();
        EvangelicSunday currentSunday = null;
        String tag = null;

        while (eventType != XmlPullParser.END_DOCUMENT) {

            switch (eventType) {
                case XmlPullParser.START_TAG:
                    tag = parser.getName();
                    if (isEvangelic(tag)) {
                        String key = getAttributeValue(parser, "Key");
                        String name = getAttributeValue(parser, "Name");
                        currentSunday = evangelic.get(key);
                        if (currentSunday == null) {
                            currentSunday = new EvangelicSunday(key, name);
                            evangelic.put(key, currentSunday);
                        }
                    }
                    break;

                case XmlPullParser.TEXT:
                    if (currentSunday != null) {
                        if (isLink(tag)) {
                            currentSunday.setLink(parser.getText());
                        }
                    }
                    break;

                default:
                    tag = null;
                    break;
            }

            eventType = parser.next();
        }
    }

    private boolean isEvangelic(String name) {
        return ("Evangelic".equalsIgnoreCase(name));
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
