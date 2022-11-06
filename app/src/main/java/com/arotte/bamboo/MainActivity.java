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
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;


//        switch (item.getItemId()) {
//            case R.id.bottomNavbarHome:
//                fragment = new HomeFragment();
//                break;
//
//            case R.id.bottomNavbarProfile:
//                fragment = new ProfileFragment();
//                break;
//
//            case R.id.bottomNavbarSearch:
//                fragment = new SearchFragment();
//                break;
//
//
//            case R.id.bottomNavbarCookbook:
//                fragment = new CookbookFragment();
//                break;
//
//            // case R.id.bottomNavbarUpload:
//            //    startActivity(new Intent(MainActivity.this, UploadActivity.class));
//            //    break;
//        }
    }
}