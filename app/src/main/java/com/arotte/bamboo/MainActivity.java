package com.arotte.bamboo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener{

    private static final String CHANNEL_ID = "123";

    private BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Notif.createChannel(this);

        List<MaterialButton> positive = new ArrayList<>();
        List<MaterialButton> negative = new ArrayList<>();

        positive.add((MaterialButton)findViewById(R.id.btnHappy));
        positive.add((MaterialButton)findViewById(R.id.btnExcited));
        positive.add((MaterialButton)findViewById(R.id.btnSuprised));

        negative.add((MaterialButton)findViewById(R.id.btnSad));
        negative.add((MaterialButton)findViewById(R.id.btnTired));
        negative.add((MaterialButton)findViewById(R.id.btnAngry));

        for (MaterialButton btn : positive)
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(MainActivity.this, FeelingGoodActivity.class));
                }
            });

        for (MaterialButton btn : negative)
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(MainActivity.this, FeelsBadActivity.class));

                    // Notif.notify(MainActivity.this, "Test", "Test", MainActivity.class);
                }
            });


        // getting bottom navigation view and attaching the listener
        navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        // fix shadow on bottom navbar
//        navigation.setBackground(null);
//        navigation.setSelectedItemId(R.id.bottomNavbarHome);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.bottomNavbarHome:
                // startActivity(new Intent(MainActivity.this, .class));
                return false;

            case R.id.bottomNavbarInsight:
                startActivity(new Intent(MainActivity.this, Insights.class));

            case R.id.bottomNavbarAdvice:
                // startActivity(new Intent(MainActivity.this, AdviceActivity.class));
                return false;

            case R.id.bottomNavbarSettings:
                // startActivity(new Intent(MainActivity.this, SettingsActivity.class));
                return false;

            // case R.id.bottomNavbarUpload:
            //    startActivity(new Intent(MainActivity.this, UploadActivity.class));
            //    break;
        }


        return false;
    }
}