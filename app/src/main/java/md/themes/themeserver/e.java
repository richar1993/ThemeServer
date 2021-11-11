package md.themes.themeserver;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

import md.themes.R;

final class e extends BaseAdapter {
    private static final int a = R.layout.singleviewitem;
    private static final int b = R.drawable.temp_img;
    private static final int c = R.drawable.ic_action_cancel;
    private Context d;
    private ArrayList e;
    private d f;
    private md.themes.themeserver.a g;

    e(Context var1, ArrayList var2) {
        super();
        this.d = var1;
        this.e = var2;
        this.f = new d(var1);
        this.g = new md.themes.themeserver.a(var1);
    }

    static md.themes.themeserver.a a(e var0) {
        return var0.g;
    }

    private c a(int var1) {
        return (c)this.e.get(var1);
    }

    private void a(c var1, View var2) {
        this.f.a(var1);
    }

    private void a(String var1, View var2) {
        Intent var3 = new Intent(this.d, SingleItemView.class);
        var3.putExtra("url", var1);
        this.d.startActivity(var3);
    }

    private void a(String var1, ImageView var2) {
        File var3 = this.g.a(var1);
        if (var3.exists()) {
            try {
                var2.setImageBitmap(BitmapFactory.decodeFile(var3.getPath()));
            } catch (Exception var4) {
            }

        } else {
            Picasso.get().load(var1).networkPolicy(NetworkPolicy.NO_STORE, new NetworkPolicy[0]).placeholder(b).error(c).into(var2, new e1(this, var2, var1));
        }
    }

    public static void lambda$0WkV9zaOQR_FbaqOpfGg4MrwODI(e var0, String var1, View var2) {
        var0.a(var1, var2);
    }

    public static void lambda$S_m32KjHe2l9zY_lWm9TJl09grI(e var0, c var1, View var2) {
        var0.a(var1, var2);
    }

    final void a(ArrayList var1) {
        this.e = var1;
        this.notifyDataSetChanged();
    }
    @Override
    public final int getCount() {
        return this.e.size();
    }

    @Override
    public Object getItem(int i) {
        return this.a(i);
    }


    @Override
    public final long getItemId(int var1) {
        return (long)var1;
    }
    @Override
    public final View getView(int var1, View var2, ViewGroup var3) {
        c var4 = this.a(var1);
        e.a var5;
        if (var2 == null) {
            View var6 = LayoutInflater.from(this.d).inflate(a, var3, false);
            var5 = new a(var6);
            var6.setTag(var5);
        } else {
            var5 = (e.a)var2.getTag();
        }

        var5.b.setText(var4.a());
        var5.c.setText(var4.b());
        var5.f.setOnClickListener(new _$$Lambda$e$S_m32KjHe2l9zY_lWm9TJl09grI(this, var4));
        var5.d.setOnClickListener(new _$$Lambda$e$0WkV9zaOQR_FbaqOpfGg4MrwODI(this, var4.f()));
        var5.e.setOnClickListener(new _$$Lambda$e$0WkV9zaOQR_FbaqOpfGg4MrwODI(this, var4.g()));
        this.a(var4.d(), var5.d);
        this.a(var4.e(), var5.e);
        return var5.a;
    }

    private static final class a {
        View a;
        TextView b;
        TextView c;
        ImageView d;
        ImageView e;
        Button f;

        a(View var1) {
            this.a = var1;
            this.d = (ImageView)var1.findViewById(R.id.flag);
            this.e = (ImageView)this.a.findViewById(R.id.flag2);
            this.b = (TextView)this.a.findViewById(R.id.rank);
            this.c = (TextView)this.a.findViewById(R.id.country);
            this.f = (Button)this.a.findViewById(R.id.div2);
        }
    }
}
