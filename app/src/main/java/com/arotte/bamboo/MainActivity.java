package com.arotte.bamboo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                }
            });
    }
}