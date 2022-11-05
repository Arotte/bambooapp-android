package com.arotte.bamboo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Insights extends AppCompatActivity
        implements InsightsRVAdapter.ItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insights);


        List<ViewStats> dummyData = dummyViewStats();
        RecyclerView rv = findViewById(R.id.rvTop3);
        rv.setNestedScrollingEnabled(false);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        InsightsRVAdapter rvAdapter = new InsightsRVAdapter(this, dummyData);
        rvAdapter.setClickListener(this);
        rv.setAdapter(rvAdapter);
    }

    private List<ViewStats> dummyViewStats() {
        List<ViewStats> dummy = new ArrayList<>();


        dummy.add(new ViewStats(
                "TikTok"
        ));

        dummy.add(new ViewStats(
                "FaceBook"
        ));

        return dummy;
    }

    @Override
    public void onRecItemClick(View view, int position) {
        // aaaaaaaaaaaaaaaaaaaaaaaaaa


        // yes
    }
}