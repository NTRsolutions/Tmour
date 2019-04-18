package tmour.sismatix.com.tmour;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.WindowManager;

import tmour.sismatix.com.tmour.Activity.Navigation_drawer_activity;

public class Splash_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        getApplicationContext().setTheme(android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if(getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i =new Intent(Splash_screen.this,Navigation_drawer_activity.class);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                startActivity(i);
                finish();

            }
        },3000);}
    }

