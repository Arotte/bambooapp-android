package com.arotte.bamboo.onboarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.arotte.bamboo.R;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class ChooseHobbiesActivity extends AppCompatActivity
        implements FeelingsRVAdapter.ItemClickListener{


    private FeelingsRVAdapter rvAdapter1;
    private FeelingsRVAdapter rvAdapter2;
    private FeelingsRVAdapter rvAdapter3;

    private RecyclerView rv;

    private List<String> selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_hobbies);


        selected = new ArrayList<>();


        // set  recyclerview row 1
        List<String> data = getHobbiesRow1();
        rv = findViewById(R.id.rvHobbies1);
        rv.setNestedScrollingEnabled(false);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvAdapter1 = new FeelingsRVAdapter(this, data);
        rvAdapter1.setClickListener(this);
        rv.setAdapter(rvAdapter1);


        // set  recyclerview row 2
        data = getHobbiesRow2();
        rv = findViewById(R.id.rvHobbies2);
        rv.setNestedScrollingEnabled(false);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvAdapter2 = new FeelingsRVAdapter(this, data);
        rvAdapter2.setClickListener(this);
        rv.setAdapter(rvAdapter2);

        // set  recyclerview row 3
        data = getHobbiesRow3();
        rv = findViewById(R.id.rvHobbies3);
        rv.setNestedScrollingEnabled(false);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvAdapter3 = new FeelingsRVAdapter(this, data);
        rvAdapter3.setClickListener(this);
        rv.setAdapter(rvAdapter3);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                scrollList();
            }
        }, 200);


        ((MaterialButton)findViewById(R.id.btnNext3)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChooseHobbiesActivity.this, ChooseImages.class));
            }
        });

    }



    private void scrollList(){
        rv.post(new Runnable() {
            @Override
            public void run() {
                // Call smooth scroll
                rv.smoothScrollToPosition(3);
            }
        });
    }


    private List<String> getHobbiesRow1() {
        List<String> data = new ArrayList<>();
        data.add("Reading");
        data.add("Writing");
        data.add("Drawing");
        data.add("Painting");
        return data;
    }

    private List<String> getHobbiesRow2() {
        List<String> data = new ArrayList<>();
        data.add("Gardening");
        data.add("Walking");
        data.add("Running");
        data.add("Cycling");
        return data;
    }

    private List<String> getHobbiesRow3() {
        List<String> data = new ArrayList<>();
        data.add("Swimming");
        data.add("Cooking");
        data.add("Dancing");
        data.add("Singing");
        return data;
    }

    @Override
    public void onRecItemClick(View view, int position) {
        MaterialButton btn = view.findViewById(R.id.btnFeeling);

        String hobby = getHobby(position);

        if (selected.contains(hobby)) {

            // un-select
            selected.remove(hobby);
            btn.setBackgroundColor(getResources().getColor(R.color.bbwhite));
            btn.setTextColor(getResources().getColor(R.color.bbgreen));
            

        } else {

            // select
            selected.add(hobby);
            btn.setBackgroundColor(getResources().getColor(R.color.bbgreen));
            btn.setTextColor(getResources().getColor(R.color.bbwhite));

            
        }
    }


    private String getHobby(int p) {

        String ret = rvAdapter1.getItem(p);

        if (ret != null)
            return ret;

        ret = rvAdapter2.getItem(p);

        if (ret != null)
            return ret;

        ret = rvAdapter3.getItem(p);

        if (ret != null)
            return ret;

        return null;
    }
}