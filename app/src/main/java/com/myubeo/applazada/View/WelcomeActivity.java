package com.myubeo.applazada.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.myubeo.applazada.R;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        getSupportActionBar().hide();
        startLogin();
    }

    private void startLogin() {
        Thread bamgio = new Thread(){
            public void run()
            {
                try {
                    sleep(2000);
                } catch (Exception e) {

                }
                finally
                {
                    Intent activityLogin = new Intent(WelcomeActivity.this, LoginActivity.class);
                    startActivity(activityLogin);
                }
            }
        };
        bamgio.start();
    }

    protected void onPause(){
        super.onPause();
        finish();
    }
}
