package md.themes.themeserver.Resources;



import static md.themes.themeserver.Resources.app.initApp;

import android.content.Context;

import android.content.res.Resources;
import android.database.sqlite.SQLiteOpenHelper;


public class yo {
    //public
    public static final String mpack = "md.themes";
    public static final String pname = "MDThemes";

    public static String datafolder;
    private static Context mCtx;
    //init App
    public static void yo(Context ctx) {
        setmCtx(ctx);
        shp.init(ctx);
        others.init();
        initApp(ctx);

    }
    static void setmCtx(Context ctx) {
        mCtx = ctx;
    }
    public static Context getCtx() {
        return mCtx;
    }
    public static Class a() {
        return null;
    }

}