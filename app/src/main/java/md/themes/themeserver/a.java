package md.themes.themeserver;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.webkit.URLUtil;


import java.io.File;
import java.io.FileOutputStream;

import md.themes.themeserver.Resources.utils;

public final class a {
    private static final String a = utils.dbsf("aHR0cHM6Ly9tZHdhZ3JhbS5jb20vVGhlbWVzL3NjcmVlbnMv", 1);
    private File b;

    a(Context context) {
        this.b = Environment.getExternalStorageState().equals("mounted") ? new File(Environment.getExternalStorageDirectory(), "/WhatsApp/Cache") : context.getCacheDir();
        if (!this.b.exists()) {
            this.b.mkdirs();
        }
    }

    private File b(String str) {
        return new File(this.b, String.valueOf(str.hashCode()));
    }

    public final File a(String str) {
        String guessFileName = URLUtil.guessFileName(str, null, null);
        File b2 = b(a + guessFileName);
        return b2.exists() ? b2 : b(str);
    }

    public final void a(Bitmap bitmap, String str) {
        int hashCode = str.hashCode();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(this.b + File.separator + String.valueOf(hashCode));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
        }
    }
}