package md.themes.themeserver;


import android.content.Intent;
import android.os.AsyncTask;



import java.io.File;

import md.themes.themeserver.Base.Themes;
import md.themes.themeserver.Resources.app;
import md.themes.themeserver.Resources.others;
import md.themes.themeserver.Resources.utils;
import md.themes.themeserver.Resources.yo;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okio.BufferedSink;
import okio.Okio;


public class ThemeDownloadAsync extends AsyncTask<Void, Void, Void> {
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final OkHttpClient e;

    public ThemeDownloadAsync(String var1, String var2, String var3, String var4) {
        this.d = var1;
        this.a = var2;
        this.b = var3;
        this.c = var4;
        this.e = (new OkHttpClient.Builder()).addInterceptor(new app.AddHeaderInterceptor()).build();
    }
    @Override
    protected Void doInBackground(Void... var1) {
        String var2;
        StringBuilder var3;
        boolean var4;
        StringBuilder var7;
        String var8;
        label20: {
            String var5 = this.d;
            var2 = Themes.yomods_folder;
            var3 = new StringBuilder();
            var3.append(var5);
            var3.append(".xml");
            if ((new File(var2, var3.toString())).exists()) {
                var8 = this.d;
                var5 = Themes.yomods_folder;
                var7 = new StringBuilder();
                var7.append(var8);
                var7.append("_w.jpg");
                if ((new File(var5, var7.toString())).exists()) {
                    var4 = true;
                    break label20;
                }
            }

            var4 = false;
        }

        if (!var4) {
            File var6 = new File(Themes.yomods_folder);
            if (!var6.exists()) {
                var6.mkdirs();
            }

            var8 = this.a;
            var7 = new StringBuilder();
            var7.append(this.d);
            var7.append(".xml");
            this.downloadFile(var8, new File(var6, var7.toString()));
            var8 = this.b;
            var7 = new StringBuilder();
            var7.append(this.d);
            var7.append("_w.jpg");
            this.downloadFile(var8, new File(var6, var7.toString()));
            var2 = this.c;
            var3 = new StringBuilder();
            var3.append(this.d);
            var3.append("_homeW.jpg");
            this.downloadFile(var2, new File(var6, var3.toString()));
        }

        return null;
    }

    public void downloadFile(String var1, File var2) {
        try {
            Request.Builder var3 = new Request.Builder();
            Request var5 = var3.url(var1).build();
            Response var6 = this.e.newCall(var5).execute();
            BufferedSink var7 = Okio.buffer(Okio.sink(var2));
            var7.writeAll(var6.body().source());
            var7.close();
        } catch (Exception var4) {
        }

    }

    protected void onPostExecute(Void var1) {
        String var7 = this.d;

        try {
            File var2 = new File(Themes.yomods_folder);
            File var3 = utils.getShpXML();
            StringBuilder var4 = new StringBuilder();
            var4.append(var2);
            var4.append(File.separator);
            var4.append(var7);
            var4.append(".xml");
            utils.copyFile(var4.toString(), var3.getPath());
            var4 = new StringBuilder();
            var4.append(yo.datafolder);
            var4.append("files/wallpaper.jpg");
            var3 = new File(var4.toString());
            File var11 = new File(others.homeBK_path);
            StringBuilder var9 = new StringBuilder();
            var9.append(Themes.yomods_folder);
            var9.append(var7);
            var9.append("_w.jpg");
            File var5 = new File(var9.toString());
            if (var5.exists() && var3.exists()) {
                var3.delete();
                utils.copyFile(var5.getPath(), var3.getPath());
                utils.a(var3);
            }

            StringBuilder var10 = new StringBuilder();
            var10.append(Themes.yomods_folder);
            var10.append(var7);
            var10.append("_homeW.jpg");
            var2 = new File(var10.toString());
            if (var2.exists() && var11.exists()) {
                var11.delete();
                utils.copyFile(var2.getPath(), var11.getPath());
            }

            Intent var8 = new Intent(yo.getCtx(), OnThemesActivity.class);
            var8.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            yo.getCtx().startActivity(var8);
            System.exit(0);
        } catch (Exception var6) {
        }

    }
}
