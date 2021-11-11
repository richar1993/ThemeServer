package md.themes.themeserver;


import android.app.ProgressDialog;
import android.widget.Toast;


import java.io.IOException;

import md.themes.R;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

final class OnThemesActivity$2 implements Callback {
    final ProgressDialog a;
    final OnThemesActivity b;

    OnThemesActivity$2(OnThemesActivity var1, ProgressDialog var2) {
        super();
        this.b = var1;
        this.a = var2;
    }

    private void a() {
        this.b.runOnUiThread(new _$$Lambda$OnThemesActivity$2$OZy_zpLQEHCy8GuUnW5R0QzvgxY(this));
    }

    private void a(b var1) {
        this.b.a(var1.a());
    }

    private void b() {
        Toast.makeText(this.b, R.string.register_try_again_later, Toast.LENGTH_SHORT).show();
        this.b.finish();
    }

    public static void lambda$58epTpFLaSqDkudI4K5ZXeUoFOk(OnThemesActivity$2 var0, b var1) {
        var0.a(var1);
    }

    public static void lambda$OZy_zpLQEHCy8GuUnW5R0QzvgxY(OnThemesActivity$2 var0) {
        var0.b();
    }
    @Override
    public final void onFailure(Call var1, IOException var2) {
        if (this.a.isShowing()) {
            this.a.dismiss();
        }

        this.a();
    }
    @Override
    public final void onResponse(Call var1, Response var2) throws IOException {
        if (var2.isSuccessful()) {
            String var3 = var2.body().string();
            if (var3 != null && !var3.isEmpty()) {
                b var4 = new b(var3);
                var4.b();
                this.b.runOnUiThread(new _$$Lambda$OnThemesActivity$2$58epTpFLaSqDkudI4K5ZXeUoFOk(this, var4));
            } else {
                this.a();
            }

            if (this.a.isShowing()) {
                this.a.dismiss();
            }
        }

    }
}
