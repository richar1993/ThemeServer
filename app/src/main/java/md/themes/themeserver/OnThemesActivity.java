package md.themes.themeserver;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import md.themes.R;
import md.themes.themeserver.Base.BaseSettingsActivity;
import md.themes.themeserver.Resources.app;
import md.themes.themeserver.Resources.utils;
import md.themes.themeserver.Resources.yo;
import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Request.Builder;

public class OnThemesActivity extends Activity {
    static String a;
    static String b;
    static String c;
    private e d;
    private ArrayList e = new ArrayList();
    private boolean f;

    public OnThemesActivity() {
        super();
    }

    // $FF: synthetic method
    static ArrayList a(OnThemesActivity var0) {
        return var0.e;
    }

    private void a() {
        TextView var1 = (TextView)this.findViewById(R.id.count);
        StringBuilder var2 = new StringBuilder("Total themes: ");
        var2.append(this.d.getCount());
        var1.setText(var2.toString());
    }

    // $FF: synthetic method
    static e b(OnThemesActivity var0) {
        return var0.d;
    }

    // $FF: synthetic method
    static void c(OnThemesActivity var0) {
        var0.a();
    }


    public static void setScreensServer(String var0) {
        c = var0;
    }

    public static void setWallServer(String var0) {
        b = var0;
    }

    public static void setXmlServer(String var0) {
        a = var0;
    }

    final void a(ArrayList var1) {
        if (var1 != null) {
            this.e.addAll(var1);
            this.d.a(this.e);
            this.a();
        }
    }

    protected void attachBaseContext(Context var1) {
        if (VERSION.SDK_INT >= 17) {
            super.attachBaseContext(var1.createConfigurationContext(yo.getCtx().getResources().getConfiguration()));
        } else {
            super.attachBaseContext(var1);
        }
    }

    protected void onCreate(Bundle var1) {
        super.onCreate(var1);
        this.setContentView(R.layout.listview);
        boolean var2 = true;
        this.f = var2;
        String var3 = "#080808";
        String var11;
        if (var2) {
            var11 = "#080808";
        } else {
            var11 = "#f2f2f2";
        }

        int var4 = Color.parseColor(var11);
        utils.setStatusNavColors(this, var4, var4);
        int var5;
        if (this.f) {
            var5 = -3355444;
        } else {
            var5 = -12303292;
        }

        Toolbar var12 = (Toolbar)this.findViewById(R.id.acjtoolbar);
        var12.setBackgroundColor(var4);
        var12.setTitleTextColor(var5);
        BaseSettingsActivity.configToolbar(var12, this);
        var12.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        EditText var13 = (EditText)this.findViewById(R.id.searchbox);
        var13.setBackgroundColor(var4);
        var13.setTextColor(var5);
        var13.setHintTextColor(var5);
        var13.setInputType(1);
        var13.setImeOptions(6);
        var13.setMaxLines(1);
        var13.addTextChangedListener(new OnThemesActivity$1(this));

        try {
            Picasso.get();
        } catch (IllegalStateException var9) {
            this.finishAffinity();
        } catch (Exception var10) {
            ;
        }

        String var6 = utils.dbsf("YUhSMGNITTZMeTl0WkhkaFozSmhiUzVqYjIwdlZHaGxiV1Z6TDB4cGMzUlVhR1Z0WlhNdWVHMXM=", 2);

        try {
            ProgressDialog var14 = new ProgressDialog(this);
            var14.setTitle(R.string.register_preparing);
            var14.setMessage("Loading");
            var14.setIndeterminate(false);
            var14.show();
            Builder var7 = new Builder();
            Request var15 = var7.url(var6).build();
            Call var16 = app.getOkHttpClient().newCall(var15);
            OnThemesActivity$2 var18 = new OnThemesActivity$2(this, var14);
            var16.enqueue(var18);
        } catch (Exception var8) {
            ;
        }

        if (!utils.isStorageGranted()) {
            Toast.makeText(this, R.string.permission_storage_need_write_access_on_msg_download, Toast.LENGTH_SHORT).show();
        }

        this.d = new e(this, this.e);
        ListView var17 = (ListView)this.findViewById(R.id.listview);
        var17.setAdapter(this.d);
        if (this.f) {
            var11 = var3;
        } else {
            var11 = "#f2f2f2";
        }

        var17.setBackgroundColor(Color.parseColor(var11));
    }
}
