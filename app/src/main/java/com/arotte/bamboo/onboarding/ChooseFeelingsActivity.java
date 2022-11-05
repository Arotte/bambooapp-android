package com.arotte.bamboo.onboarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.arotte.bamboo.InsightsRVAdapter;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_feelings);

        selectedNegativeFeelings = new ArrayList<>();
        selectedPositiveFeelings = new ArrayList<>();

        

        // set  recyclerview
        List<String> data = getPositiveFeelings();
        RecyclerView rv = findViewById(R.id.rvPositiveFeelings);
        rv.setNestedScrollingEnabled(false);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        positiveAdapter = new FeelingsRVAdapter(this, data);
        positiveAdapter.setClickListener(this);
        rv.setAdapter(positiveAdapter);

        // set  recyclerview
        data = getPositiveFeelings();
        rv = findViewById(R.id.rvNegativeFeelings);
        rv.setNestedScrollingEnabled(false);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        negativeAdapter = new FeelingsRVAdapter(this, data);
        negativeAdapter.setClickListener(this);
        rv.setAdapter(negativeAdapter);

    }

    @Override
    public void onRecItemClick(View view, int position) {

        System.out.println("AAAAAAAAAAAAAAAAAAAAA");

        MaterialButton btn = view.findViewById(R.id.btnFeeling);
        btn.setBackgroundColor(getResources().getColor(R.color.bbgreen));
        btn.setTextColor(getResources().getColor(R.color.bbwhite));


//        String item = positiveAdapter.getItem(position);
//        boolean isPositiveFeeling = getPositiveFeelings().contains(item);
//
//        if (isPositiveFeeling) {
//
//            if (selectedPositiveFeelings.contains(position)) {
//
//
//            } else {
//
//
//                btn.setBackgroundColor(getResources().getColor(R.color.bbgreen));
//                btn.setTextColor(getResources().getColor(R.color.bbwhite));
//            }
//
//
//        } else {
//
//
//            if (selectedNegativeFeelings.contains(position)) {
//
//
//            } else {
//
//
//            }
//
//        }

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