package md.themes.themeserver;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.ArrayList;

public final class b {
    private String a;
    private ArrayList<c> b = new ArrayList<>();

    b(String str) {
        this.a = str;
    }

    public final ArrayList<c> a() {
        return this.b;
    }

    public final void b() {
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            newInstance.setNamespaceAware(true);
            XmlPullParser newPullParser = newInstance.newPullParser();
            newPullParser.setInput(new StringReader(this.a));
            c cVar = null;
            String str = "";
            boolean z = false;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                String name = newPullParser.getName();
                if (eventType == 2) {
                    if (name.equalsIgnoreCase("theme")) {
                        cVar = new c();
                        z = true;
                    }
                    if (name.equalsIgnoreCase("data")) {
                        try {
                            String attributeValue = newPullParser.getAttributeValue(0);
                            String attributeValue2 = newPullParser.getAttributeValue(1);
                            OnThemesActivity.setScreensServer(newPullParser.getAttributeValue(2));
                            OnThemesActivity.setWallServer(attributeValue2);
                            OnThemesActivity.setXmlServer(attributeValue);
                        } catch (Exception e) {
                        }
                    }
                } else if (eventType != 3) {
                    if (eventType == 4) {
                        str = newPullParser.getText();
                    }
                } else if (z) {
                    if (name.equalsIgnoreCase("theme")) {
                        this.b.add(cVar);
                        z = false;
                    } else if (name.equalsIgnoreCase("title")) {
                        cVar.a(str);
                        cVar.c();
                    } else if (name.equalsIgnoreCase("date")) {
                        cVar.b(str);
                    }
                }
            }
        } catch (Exception e2) {
        }
    }
}
