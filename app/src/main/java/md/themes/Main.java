package md.themes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import md.themes.themeserver.Base.Themes;
import md.themes.themeserver.Resources.yo;

public class Main extends AppCompatActivity {
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(yo.getCtx());
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Thread timerThread = new Thread() {
            public void run() {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(Main.this, Themes.class);
                    startActivity(intent);
                    finish();

                }
            }
        };
        timerThread.start();
    }
    @Override
    protected void onResume() {
        super.onResume();
    }
}
