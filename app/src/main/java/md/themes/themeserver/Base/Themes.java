package md.themes.themeserver.Base;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import android.widget.Toast;



import java.io.File;

import md.themes.R;
import md.themes.themeserver.OnThemesActivity;
import md.themes.themeserver.Resources.app;

public class Themes extends BaseSettingsActivity {
    public static String yomods_folder = Environment.getExternalStorageDirectory() + "/WhatsApp/YoMods/";
    private File prefsdir = new File(yomods_folder);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yo_settings_yothemes);
    }

    public void theme_download(View var1) {
        if (app.checkInternetNow()) {
            this.startActivity(new Intent(this, OnThemesActivity.class));
        } else {
            Toast.makeText(this, R.string.network_required, Toast.LENGTH_LONG).show();
        }
    }

}
