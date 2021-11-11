package md.themes.themeserver;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.io.File;

import md.themes.R;


public class SingleItemView extends Activity {
    private static final int a = R.drawable.temp_img;
    private static final int b = R.drawable.ic_action_cancel;
    private a c;

    public SingleItemView() {
    }

    public void onCreate(Bundle var1) {
        super.onCreate(var1);
        this.setContentView(R.layout.pic);
        this.c = new a(this);
        final String var2 = this.getIntent().getStringExtra("url");
        final ImageView var5 = (ImageView)this.findViewById(R.id.seeeme);
        Toast.makeText(this, R.string.media_loading, Toast.LENGTH_LONG).show();
        File var3 = this.c.a(var2);
        if (var3.exists()) {
            try {
                var5.setImageBitmap(BitmapFactory.decodeFile(var3.getPath()));
            } catch (Exception var4) {
            }

        } else {
            Picasso.get().load(var2).networkPolicy(NetworkPolicy.NO_STORE, new NetworkPolicy[0]).placeholder(a).error(b).into(var5, new Callback() {
                public final void onError(Exception var1) {
                }

                public final void onSuccess() {
                    Bitmap var1 = ((BitmapDrawable)var5.getDrawable()).getBitmap();
                    SingleItemView.this.c.a(var1, var2);
                }
            });
        }
    }
}