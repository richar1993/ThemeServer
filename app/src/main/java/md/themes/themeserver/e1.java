package md.themes.themeserver;


import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.squareup.picasso.Callback;


final class e1 implements Callback {
    final ImageView a;
    final String b;
    final e c;

    e1(e var1, ImageView var2, String var3) {
        super();
        this.c = var1;
        this.a = var2;
        this.b = var3;
    }
@Override
    public final void onError(Exception var1) {
        if (var1.getMessage().equals("HTTP 404")) {
            this.a.setOnClickListener((OnClickListener)null);
        }

    }
    @Override
    public final void onSuccess() {
        Bitmap var1 = ((BitmapDrawable)this.a.getDrawable()).getBitmap();
        e.a(this.c).a(var1, this.b);
    }
}
