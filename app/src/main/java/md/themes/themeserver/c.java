package md.themes.themeserver;

public final class c {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private boolean f;

    c() {
    }

    public final String a() {
        return this.a;
    }

    public final void a(String str) {
        this.a = str;
        this.f = str.contains("-HW");
    }

    public final String b() {
        return this.b;
    }

    public final void b(String str) {
        this.b = str;
    }

    public final void c() {
        this.e = OnThemesActivity.c;
        this.c = this.e + this.a + "1.jpg";
        this.d = this.e + this.a + "2.jpg";
    }

    public final String d() {
        return this.c;
    }

    public final String e() {
        return this.d;
    }

    public final String f() {
        return this.e + "full/" + this.a + "1.jpg";
    }

    public final String g() {
        return this.e + "full/" + this.a + "2.jpg";
    }

    public final String toString() {
        return this.a + "\n" + this.b;
    }
}