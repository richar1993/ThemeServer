package md.themes.themeserver.Resources;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xer on 4/7/17.
 */

public class shp {
    public static SharedPreferences prefs = null;
    public static SharedPreferences.Editor prefsEditor;

    public static SharedPreferences stockPrefsLight = null;
    public static SharedPreferences.Editor stockEditLight;
    public static SharedPreferences.Editor a;

    static SharedPreferences.Editor stockEdit;

    static SharedPreferences priv = null;
    private static SharedPreferences.Editor privEditor;

    public static String privprefsname;


    public static void init(Context ctx) {
        Context uCtx = yo.getCtx();
        if (uCtx == null) {
            uCtx = ctx;
        }
        prefs = uCtx.getSharedPreferences(yo.pname, Context.MODE_PRIVATE);
        prefsEditor = prefs.edit();
        stockEdit = uCtx.getSharedPreferences(yo.mpack + "_preferences", Context.MODE_PRIVATE).edit();

        stockPrefsLight = uCtx.getSharedPreferences(yo.mpack + "_preferences_light", Context.MODE_PRIVATE);
        stockEditLight = stockPrefsLight.edit();

        privprefsname = "WhatsAppriv";
        priv = uCtx.getSharedPreferences(privprefsname, 0);
        privEditor = priv.edit();
    }



    public static void setStringPriv(String str, String val) {
        privEditor.putString(str, val).commit();
    }







}
