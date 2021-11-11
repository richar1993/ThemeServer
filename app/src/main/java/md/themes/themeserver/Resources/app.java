package md.themes.themeserver.Resources;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;


public class app extends Application {
    static boolean a = false;
    private static ConnectivityManager b = null;
    private static OkHttpClient c = null;
    public static String dli = "WVVoU01HTklUVFpNZVRsdFlqTldhRnBITVhaYVNFMTFXVEk1ZEV3eVduWmtWMFpyVEZoa2IxbFlVbnBaV0VKM1RIYw";

    public static final class AddHeaderInterceptor implements Interceptor {
        @Override
        public final Response intercept(Chain chain) {
            try {
                return chain.proceed(chain.request().newBuilder().addHeader("User-Agent", "Chrome/94.0.4606.81").build());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    private static int a() {
        return ("YYYYY" + "YYYY").length();
    }

    private static void a(Context context) {
        if (dli.length() / a() <= 10) {
            shp.init(context);
        }
    }

    public static void checkInternet() {
        ConnectivityManager connectivityManager = b;
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            a = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
    }

    public static boolean checkInternetNow() {
        checkInternet();
        return isInternetActive();
    }

    public static OkHttpClient getOkHttpClient() {
        return c;
    }

    public static void initApp(Context context) {
        if (utils.vs() == 107) {
            a(context);
            StringBuilder sb = new StringBuilder();
            sb.append(yo.getCtx().getFilesDir().getAbsolutePath());
            sb.append(File.separator);
            yo.datafolder = sb.toString().replace("files/", "");
            c = new OkHttpClient.Builder().addInterceptor(new AddHeaderInterceptor()).cache(new Cache(new File(yo.getCtx().getCacheDir() + File.separator + "okHttpCache.tmp"), 10485760)).build();
            Picasso.setSingletonInstance(new Picasso.Builder(yo.getCtx()).downloader(new OkHttp3Downloader(c)).build());
        } else {
            a(null);
        }
        b = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        checkInternet();
    }

    public static boolean isInternetActive() {
        return a;
    }
}