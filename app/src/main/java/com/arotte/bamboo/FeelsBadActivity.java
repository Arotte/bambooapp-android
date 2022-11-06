package com.arotte.bamboo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class FeelsBadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feels_bad);

        ((TextView)findViewById(R.id.tvBadFeelingTxt)).setText(Html.fromHtml(
                "I have generated an image <br/>of a <b>cute doggo sitting<br/>on the moon</b> to<br/>cheer you up!"));
    }
}