package md.themes;

import android.app.Application;
import android.content.Context;

import md.themes.themeserver.Resources.yo;

public class AppShell extends Application {
    private Context context;

    @Override
    protected void attachBaseContext(Context context) {
        yo.yo(context);
        super.attachBaseContext(yo.getCtx());

    }
    @Override
    public void onCreate() {
        super.onCreate();
    }
}
