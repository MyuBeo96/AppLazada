package com.myubeo.applazada.View;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.myubeo.applazada.R;
import com.myubeo.applazada.Until.AppData;

import java.util.Locale;

public class LoginActivity extends AppCompatActivity {

    public static Configuration newConfig;
    TextView txt_Language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        initView();
        initListener();
    }

    private void initView(){
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        if (newConfig == null) {
            newConfig = new Configuration();
            newConfig.locale = new Locale(AppData.getInstance().LOCALE_VI);
        }

        getBaseContext().getResources().updateConfiguration(newConfig,
                getBaseContext().getResources().getDisplayMetrics());

        txt_Language = findViewById(R.id.txt_Language);
    }


    private void initListener() {
        txt_Language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txt_Language.getText().equals("VIE")){
                    changeLanguage(AppData.LOCALE_EN);
                }else {
                    changeLanguage(AppData.LOCALE_VI);
                }
            }
        });
    }

    public void changeLanguage(String lang) {
        if (AppData.LOCALE_VI.equals(lang)) {
            AppData.language = AppData.LOCALE_VI_VN;
        } else {
            AppData.language = AppData.LOCALE_EN;
        }
        newConfig.locale = new Locale(lang);
        onConfigurationChanged(newConfig);
        Intent refresh = new Intent(this, LoginActivity.class);
        finish();
        startActivity(refresh);
    }


}
