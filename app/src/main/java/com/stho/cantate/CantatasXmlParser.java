package com.stho.cantate;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.Map;

/*
  See: https://medium.com/@ssaurel/parsing-xml-data-in-android-apps-71ef607fbb16
 */
class CantatasXmlParser {

    private final Cantatas cantatas;

    CantatasXmlParser(Cantatas cantatas) {
        this.cantatas = cantatas;
    }

    void process(XmlPullParser parser) throws IOException, XmlPullParserException {
        int eventType = parser.getEventType();
        Cantate currentCantate = null;
        String tag = null;

        while (eventType != XmlPullParser.END_DOCUMENT) {

            switch (eventType) {
                case XmlPullParser.START_TAG:
                    tag = parser.getName();
                    if (isCantata(tag)) {
                        String bwv = getAttributeValue(parser, "BWV");
                        String volume = getAttributeValue(parser, "Volume");
                        String occasion = getAttributeValue(parser, "Occasion");
                        if (bwv != null) {
                            currentCantate = cantatas.getCantate(bwv);
                            currentCantate.setVolume(volume);
                            currentCantate.setOccasion(occasion);
                            cantatas.setOccasion(occasion, bwv);
                        }
                    }
                    break;

                case XmlPullParser.TEXT:
                    if (currentCantate != null) {
                        if (isTitle(tag)) {
                            currentCantate.setTitle(parser.getText());
                        } else if (isTrack(tag)) {
                            currentCantate.addTrack(parser.getText());
                        } else if (isOriginalDate(tag)) {
                            currentCantate.setOriginalDate(parser.getText());
                        } else if (isTown(tag)) {
                            currentCantate.setTown(parser.getText());
                        } else if (isLink(tag)) {
                            currentCantate.setLink(parser.getText());
                        } else if (isRemark(tag)) {
                            currentCantate.addRemark(parser.getText());
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

    private boolean isCantata(String name) { return "Cantata".equalsIgnoreCase(name); }
    private boolean isTitle(String tag) { return "Title".equalsIgnoreCase(tag); }
    private boolean isTrack(String tag) { return "Track".equalsIgnoreCase(tag); }
    private boolean isOriginalDate(String tag) { return "OriginalDate".equalsIgnoreCase(tag); }
    private boolean isTown(String tag) { return "Town".equalsIgnoreCase(tag); }
    private boolean isLink(String tag) { return "Link".equalsIgnoreCase(tag); }
    private boolean isRemark(String tag) { return "Remark".equalsIgnoreCase(tag); }

    private String getAttributeValue(XmlPullParser parser, String attributeName) {
        for (int i = 0; i < parser.getAttributeCount(); i++) {
            if (attributeName.equalsIgnoreCase(parser.getAttributeName(i))) {
                return parser.getAttributeValue(i);
            }
        }
        return null;
    }
}
