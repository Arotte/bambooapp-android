package com.arotte.bamboo.onboarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.arotte.bamboo.InsightsRVAdapter;
import com.arotte.bamboo.MainActivity;
import com.arotte.bamboo.R;
import com.arotte.bamboo.ViewStats;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.shape.MaterialShapeUtils;

import java.util.ArrayList;
import java.util.List;

public class ChooseFeelingsActivity extends AppCompatActivity
        implements FeelingsRVAdapter.ItemClickListener{

    private List<Integer> selectedPositiveFeelings;
    private List<Integer> selectedNegativeFeelings;

    private FeelingsRVAdapter positiveAdapter;
    private FeelingsRVAdapter negativeAdapter;

    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_feelings);

        selectedNegativeFeelings = new ArrayList<>();
        selectedPositiveFeelings = new ArrayList<>();

        

        // set  recyclerview
        List<String> data = getPositiveFeelings();
        rv = findViewById(R.id.rvPositiveFeelings);
        rv.setNestedScrollingEnabled(false);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        positiveAdapter = new FeelingsRVAdapter(this, data);
        positiveAdapter.setClickListener(this);
        rv.setAdapter(positiveAdapter);

        // set  recyclerview
        data = getNegativeFeelings();
        rv = findViewById(R.id.rvNegativeFeelings);
        rv.setNestedScrollingEnabled(false);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        negativeAdapter = new FeelingsRVAdapter(this, data);
        negativeAdapter.setClickListener(this);
        rv.setAdapter(negativeAdapter);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                scrollList();
            }
        }, 200);


        ((MaterialButton)findViewById(R.id.btnNext2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChooseFeelingsActivity.this, ChooseHobbiesActivity.class));
            }
        });

    }

    private void scrollList(){
        rv.post(new Runnable() {
            @Override
            public void run() {
                // Call smooth scroll
                rv.smoothScrollToPosition(2);
            }
        });
    }

    @Override
    public void onRecItemClick(View view, int position) {


        MaterialButton btn = view.findViewById(R.id.btnFeeling);
//        btn.setBackgroundColor(getResources().getColor(R.color.bbgreen));
//        btn.setTextColor(getResources().getColor(R.color.bbwhite));


        String item = positiveAdapter.getItem(position);
        boolean isPositiveFeeling = getPositiveFeelings().contains(item);

        if (isPositiveFeeling) {

            if (selectedPositiveFeelings.contains(position)) {

                selectedPositiveFeelings.remove((Integer) position);
                btn.setBackgroundColor(getResources().getColor(R.color.bbwhite));
                btn.setTextColor(getResources().getColor(R.color.bbgreen));


            } else {

                selectedPositiveFeelings.add(position);
                btn.setBackgroundColor(getResources().getColor(R.color.bbgreen));
                btn.setTextColor(getResources().getColor(R.color.bbwhite));
            }


        } else {


            if (selectedNegativeFeelings.contains(position)) {

                selectedNegativeFeelings.remove((Integer) position);
                btn.setBackgroundColor(getResources().getColor(R.color.bbwhite));
                btn.setTextColor(getResources().getColor(R.color.bbgreen));

            } else {

                selectedNegativeFeelings.add(position);
                btn.setBackgroundColor(getResources().getColor(R.color.bbgreen));
                btn.setTextColor(getResources().getColor(R.color.bbwhite));


            }

        }

    }

    private List<String> getPositiveFeelings() {

        List<String> data = new ArrayList<>();
        
        data.add("Joyful");
        data.add("Loved");
        data.add("Content");
        data.add("Hopeful");
        data.add("Amused");
        data.add("Relaxed");

        return data;
    }

    private List<String> getNegativeFeelings() {

        List<String> data = new ArrayList<>();
        
        data.add("Sad");
        data.add("Angry");
        data.add("Anxious");
        data.add("Ashamed");
        data.add("Guilty");
        data.add("Tired");

        return data;

    }


}