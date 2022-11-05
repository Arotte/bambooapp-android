package com.arotte.bamboo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Insights extends AppCompatActivity
        implements InsightsRVAdapter.ItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insights);

        // set view stats recyclerview
        List<ViewStats> dummyData = dummyViewStats();
        RecyclerView rv = findViewById(R.id.rvTop3);
        rv.setNestedScrollingEnabled(false);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        InsightsRVAdapter rvAdapter = new InsightsRVAdapter(this, dummyData);
        rvAdapter.setClickListener(this);
        rv.setAdapter(rvAdapter);

        // set feeling stats
        List<FeelingStats> dummyData2 = dummyFeelingStats();

        // set values of tvFX, tvFXInfo
        ((TextView)findViewById(R.id.tvF1)).setText(dummyData2.get(0).feeling);
        ((TextView)findViewById(R.id.tvF1Info)).setText(Html.fromHtml(
                "You have felt like this<br/><b>" + dummyData2.get(0).nFeeled + "</b> times using <b>" + dummyData2.get(0).appName + "</b>"
        ));

        ((TextView)findViewById(R.id.tvF2)).setText(dummyData2.get(1).feeling);
        ((TextView)findViewById(R.id.tvF2Info)).setText(Html.fromHtml(
                "You have felt like this<br/><b>" + dummyData2.get(1).nFeeled + "</b> times using <b>" + dummyData2.get(1).appName + "</b>"
        ));
        
        ((TextView)findViewById(R.id.tvF3)).setText(dummyData2.get(2).feeling);
        ((TextView)findViewById(R.id.tvF3Info)).setText(Html.fromHtml(
                "You have felt like this<br/><b>" + dummyData2.get(2).nFeeled + "</b> times using <b>" + dummyData2.get(2).appName + "</b>"
        ));

        ((TextView)findViewById(R.id.tvF4)).setText(dummyData2.get(3).feeling);
        ((TextView)findViewById(R.id.tvF4Info)).setText(Html.fromHtml(
                "You have felt like this<br/><b>" + dummyData2.get(3).nFeeled + "</b> times using <b>" + dummyData2.get(3).appName + "</b>"
        ));

    }

    @Override
    public void onRecItemClick(View view, int position) {
        // aaaaaaaaaaaaaaaaaaaaaaaaaa


        // yes
    }


    // ==================================================================================
    // create dummy data to display

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

    private List<FeelingStats> dummyFeelingStats() {
        List<FeelingStats> dummy = new ArrayList<>();

        dummy.add(new FeelingStats(
                "Happy",
                5,
                "TikTok"
        ));

        dummy.add(new FeelingStats(
                "Sad",
                3,
                "TikTok"
        ));

        dummy.add(new FeelingStats(
                "Happy",
                2,
                "FaceBook"
        ));

        dummy.add(new FeelingStats(
                "Sad",
                1,
                "YouTube"
        ));

        return dummy;
    }
}