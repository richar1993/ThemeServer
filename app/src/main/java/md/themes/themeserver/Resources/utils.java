package md.themes.themeserver.Resources;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.core.content.ContextCompat;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

import md.themes.R;


public class utils {
    private static String a = null;
    public static Window setStatusNavColors(Activity activity, int statColour, int navColour) {
        Window mywind = setWindowFlags(activity, statColour, navColour);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (statColour != -11) mywind.setStatusBarColor(statColour);
            setNavBarColor(mywind, navColour);
        }
        return mywind;
    }

    public static void setNavBarColor(Window window, int navColour) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setNavigationBarColor(navColour);
        }
    }

    private static Window setWindowFlags(Activity activity, int statColour, int navColour) {
        Window mywind = activity.getWindow();
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) return mywind;

        mywind.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        mywind.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        int flags = mywind.getDecorView().getSystemUiVisibility();
        if (statColour != -11 && Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (isColorBright(statColour, 0.5)) flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            else flags &= ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if (isColorBright(navColour, 0.5)) flags |= View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR;
            else flags &= ~View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR;
        }

        mywind.getDecorView().setSystemUiVisibility(flags);
        return mywind;
    }

    public static boolean isColorBright(int color, double percentage) {
        double darkness = 1 - (0.299 * Color.red(color) + 0.587 * Color.green(color) + 0.114 * Color.blue(color)) / 255;
        return (darkness < percentage);
    }

    public static void copyFile(String filepath, String storefilepath) {
        try {
            File f1 = new File(filepath);
            File f2 = new File(storefilepath);
            InputStream in = new FileInputStream(f1);

            OutputStream out = new FileOutputStream(f2);

            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static boolean isStorageGranted() {
        return checkPermissionGranted(Manifest.permission.WRITE_EXTERNAL_STORAGE) &&
                checkPermissionGranted(Manifest.permission.READ_EXTERNAL_STORAGE);
    }

    private static boolean checkPermissionGranted(String permission) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                int result = ContextCompat.checkSelfPermission(yo.getCtx(), permission);
                return result == PackageManager.PERMISSION_GRANTED;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    ///-------------- Themes utils --------------//
    public static File getShpXML() {
        String wname = yo.pname; //don't put inline. makes problem with cloning
        File shpXML = new File(yo.datafolder + "shared_prefs" + File.separator + wname + ".xml");
        if (shpXML.isDirectory()) {
            shpXML.delete();
        }
        return shpXML;
    }


    public static int vs() {
        if (a == null) {
            a = yo.getCtx().getString(R.string.jo_mods);
        }
        String a2 = a(bsf(a, 1));
        String dbsf = dbsf("WVVoU01HTkViM1pNTTFaM1drZEdNRnBUTlcxaU0xWm9Xa2N4ZGxwSVRYVlpNamww", 3);
        int length = a2.length() + dbsf.length();
        String bsf = bsf(dbsf, 2);
        if (bsf(bsf, 1).equals("WVVoU01HTkViM1pNTTFaM1drZEdNRnBUTlcxaU0xWm9Xa2N4ZGxwSVRYVlpNamww")) {
            return length + bsf.length();
        }
       // yo.Homeac.runOnUiThread(-$.Lambda.utils.hsURf7E5P7AmNLL15hj5T5Ehp9w.INSTANCE);
        return length;
    }

    public static String dbsf(String digest, int ti) {
        if (ti == 0) return digest;
        try {
            byte[] data = Base64.decode(digest, Base64.NO_WRAP);
            return dbsf(new String(data, StandardCharsets.UTF_8), (ti - 1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "yousef";
    }

    private static String a(String bsf) {
        return bsf;
    }

    public static String bsf(String str, int i) {
        if (i == 0) {
            return str;
        }
        try {
            return bsf(Base64.encodeToString(str.getBytes(), 2), i - 1);
        } catch (Exception unused) {
            return "yousef";
        }
    }

    public static void a(File var3) {

    }
}
