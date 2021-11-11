package md.themes.themeserver;


import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;



import java.io.File;

import md.themes.R;
import md.themes.themeserver.Base.Themes;
import md.themes.themeserver.Resources.yo;


final class d {
    private String a;
    private Context b;
    private c c;

    d(Context var1) {
        super();
        this.a = Themes.yomods_folder;
        this.b = var1;
    }
    private void a(DialogInterface var1, int var2) {
        String var10 = this.c.a();
        File var3 = new File(this.a);
        if (!var3.exists()) {
            try {
                var3.mkdir();
            } catch (SecurityException var9) {
                Toast.makeText(this.b, R.string.permission_storage_need_write_access_request, Toast.LENGTH_SHORT).show();
            }
        }

        try {
            StringBuilder var11 = new StringBuilder();
            var11.append(OnThemesActivity.a);
            var11.append(var10);
            var11.append(".xml");
            String var12 = var11.toString();
            StringBuilder var4 = new StringBuilder();
            var4.append(OnThemesActivity.b);
            var4.append(var10);
            var4.append("_w.jpg");
            String var13 = var4.toString();
            StringBuilder var5 = new StringBuilder();
            var5.append(OnThemesActivity.b);
            var5.append(var10);
            var5.append("_homeW.jpg");
            String var15 = var5.toString();
            ThemeDownloadAsync var6 = new ThemeDownloadAsync(var10, var12, var13, var15);
            var6.executeOnExecutor(ThemeDownloadAsync.THREAD_POOL_EXECUTOR, new Void[0]);
            Context var14 = this.b;
            var11 = new StringBuilder();
            var11.append(R.string.gdpr_report_downloading);
            var11.append(var10);
            Toast.makeText(var14, var11.toString(), Toast.LENGTH_LONG).show();
        } catch (SecurityException var7) {
            Toast.makeText(this.b, R.string.permission_storage_need_write_access_request, Toast.LENGTH_LONG).show();
            return;
        } catch (Exception var8) {
        }

    }

    private static void b(DialogInterface var0, int var1) {
        var0.dismiss();
    }
    public static void lambda$_UCEly48umqTn5OZGFyCsejVMr8(d var0, DialogInterface var1, int var2) {
        var0.a(var1, var2);
    }

    public static void lambda$nMohA1Jk6IMjVKfppRACiDT3FTg(DialogInterface var0, int var1) {
        b(var0, var1);
    }

    final void a(c var1) {
        this.c = var1;
        (new Builder(this.b, R.style.Theme_AppCompat_Light_Dialog_Alert)).setTitle(this.c.a()).setMessage(R.string.themes_alert_lightdarkInfo).setNegativeButton(R.string.cancel, _$$Lambda$d$nMohA1Jk6IMjVKfppRACiDT3FTg.INSTANCE).setPositiveButton(R.string.ok, new _$$Lambda$d$_UCEly48umqTn5OZGFyCsejVMr8(this)).create().show();
    }
}
