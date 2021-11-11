package md.themes.themeserver;

import android.text.Editable;
import android.text.TextWatcher;

import java.util.ArrayList;
import java.util.Iterator;

final class OnThemesActivity$1 implements TextWatcher {
    // $FF: synthetic field
    final OnThemesActivity a;

    OnThemesActivity$1(OnThemesActivity var1) {
        super();
        this.a = var1;
    }

    public final void afterTextChanged(Editable var1) {
    }

    public final void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
    }
    @Override
    public final void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
        if (var1.length() <= 0) {
            OnThemesActivity.b(this.a).a(OnThemesActivity.a(this.a));
        } else {
            ArrayList var5 = new ArrayList();
            Iterator var6 = OnThemesActivity.a(this.a).iterator();

            while(var6.hasNext()) {
                c var7 = (c)var6.next();
                if (var7.a().toLowerCase().contains(var1.toString().toLowerCase())) {
                    var5.add(var7);
                    OnThemesActivity.b(this.a).a(var5);
                }
            }
        }

        OnThemesActivity.c(this.a);
    }
}
