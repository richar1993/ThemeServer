package md.themes.themeserver.Base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.widget.Toolbar;

import md.themes.R;
import md.themes.themeserver.Resources.utils;
import md.themes.themeserver.Resources.yo;


public class BaseSettingsActivity extends Activity {

    @Override
    protected void attachBaseContext(Context base) {
        if (yo.getCtx() == null) {
            yo.yo(base);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            Configuration conf = yo.getCtx().getResources().getConfiguration();
            super.attachBaseContext(base.createConfigurationContext(conf));
        } else {
            super.attachBaseContext(base);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Colors.statusNavCol(this);
    }


    @Override
    public void onPostCreate (Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Toolbar acjtoolbar = findViewById(R.id.acjtoolbar);
        acjtoolbar.setTitleTextColor(true ? Color.LTGRAY : Color.DKGRAY);
        acjtoolbar.setNavigationOnClickListener(e -> onBackPressed());

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            boolean requestTitle = bundle.containsKey("title");
            String title = bundle.getString("title");
            if (requestTitle && title != null && !title.equals("null")) acjtoolbar.setTitle(title);
        }
    }


    public static void configToolbar(Toolbar toolbar, Activity ac) {
        int bkColor = Color.parseColor(true ? "#080808" : "#f2f2f2");
        utils.setStatusNavColors(ac, bkColor, bkColor);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}
