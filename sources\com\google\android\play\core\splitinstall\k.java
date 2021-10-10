package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.util.Log;
import com.google.android.play.core.splitcompat.p;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class k {
    private static m a;

    private k() {
    }

    public static synchronized m a(Context context) {
        m mVar;
        synchronized (k.class) {
            if (a == null) {
                b bVar = new b(null);
                bVar.b(new y(p.c(context)));
                a = bVar.a();
            }
            mVar = a;
        }
        return mVar;
    }

    static h b(XmlPullParser xmlPullParser, g gVar) {
        String c;
        while (xmlPullParser.next() != 1) {
            try {
                if (xmlPullParser.getEventType() == 2) {
                    if (xmlPullParser.getName().equals("splits")) {
                        while (xmlPullParser.next() != 3) {
                            if (xmlPullParser.getEventType() == 2) {
                                if (!xmlPullParser.getName().equals("module") || (c = c("name", xmlPullParser)) == null) {
                                    d(xmlPullParser);
                                } else {
                                    while (xmlPullParser.next() != 3) {
                                        if (xmlPullParser.getEventType() == 2) {
                                            if (xmlPullParser.getName().equals("language")) {
                                                while (xmlPullParser.next() != 3) {
                                                    if (xmlPullParser.getEventType() == 2) {
                                                        if (xmlPullParser.getName().equals("entry")) {
                                                            String c2 = c("key", xmlPullParser);
                                                            String c3 = c("split", xmlPullParser);
                                                            d(xmlPullParser);
                                                            if (!(c2 == null || c3 == null)) {
                                                                gVar.b(c, c2, c3);
                                                            }
                                                        } else {
                                                            d(xmlPullParser);
                                                        }
                                                    }
                                                }
                                            } else {
                                                d(xmlPullParser);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        d(xmlPullParser);
                    }
                }
            } catch (IOException | IllegalStateException | XmlPullParserException e) {
                Log.e("SplitInstall", "Error while parsing splits.xml", e);
                return null;
            }
        }
        return gVar.a();
    }

    private static String c(String str, XmlPullParser xmlPullParser) {
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            if (xmlPullParser.getAttributeName(i).equals(str)) {
                return xmlPullParser.getAttributeValue(i);
            }
        }
        return null;
    }

    private static void d(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        int i = 1;
        while (i != 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }
}
