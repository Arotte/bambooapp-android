package com.arotte.bamboo.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.arotte.bamboo.MainActivity;
import com.arotte.bamboo.R;
import com.google.android.material.button.MaterialButton;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ChooseImages extends AppCompatActivity {

    List<ImageView> ivs;
    List<Boolean> ivIsSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_images);


        initImgs();
        loadImages();
        selectImgs();



        ((MaterialButton)findViewById(R.id.btnFinishOnboard)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChooseImages.this, MainActivity.class));
            }
        });
    }

    private void initImgs() {
        ivs = new ArrayList<>();
        ivs.add((ImageView)findViewById(R.id.iv1));
        ivs.add((ImageView)findViewById(R.id.iv2));
        ivs.add((ImageView)findViewById(R.id.iv3));
        ivs.add((ImageView)findViewById(R.id.iv4));
        ivs.add((ImageView)findViewById(R.id.iv5));
        ivs.add((ImageView)findViewById(R.id.iv6));
        ivs.add((ImageView)findViewById(R.id.iv7));
        ivs.add((ImageView)findViewById(R.id.iv8));
        ivs.add((ImageView)findViewById(R.id.iv9));
        ivs.add((ImageView)findViewById(R.id.iv10));

        ivIsSelected = new ArrayList<>();
        for (int i = 0; i < ivs.size(); i++) {
            ivIsSelected.add(false);
        }
    }

    private void loadImages() {
        List<String> urls = testImgUrls();

        int i = 0;
        for (ImageView iv : ivs) {
            loadImg(iv, urls.get(i));
            i++;
        }
    }

    private void selectImgs() {
        for (ImageView iv : ivs) {
            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int index = ivs.indexOf(v);
                    
                    if (ivIsSelected.get(index)) {

                        ivIsSelected.set(index, false);

                        // reset alpha and remove border
                        iv.setAlpha(1f);
                        iv.setBackground(null);

                    } else {
                        ivIsSelected.set(index, true);

                        // set alpha and add border
                        iv.setAlpha(0.5f);

                        // iv.setBackgroundResource(R.drawable.border);
                        // iv.setBackgroundDrawable(getResources().getDrawable(R.drawable.border));

                        final int sdk = android.os.Build.VERSION.SDK_INT;
                        if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                            iv.setBackgroundDrawable(getDrawable(R.drawable.border) );
                        } else {
                            iv.setBackground(getDrawable(R.drawable.border));
                        }
                    }
                }
            });
        }
    }

    private void loadImg(ImageView v, String url) {
        Picasso.get()
                .load(url)
                // .resize(600)
                // .onlyScaleDown() // the image will only be resized if it's bigger than 6000x2000 pixels.
                .fit()
                .into(v);
    }

    private List<String> testImgUrls() {
        // return list of 10 random image urls from the net

        List<String> urls = new ArrayList<>();

        urls.add("https://images.unsplash.com/photo-1529778873920-4da4926a72c2?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8Y3V0ZSUyMGNhdHxlbnwwfHwwfHw%3D&w=1000&q=80");
        urls.add("https://picsum.photos/id/1/5000/3333");
        urls.add("https://picsum.photos/id/2/5000/3333");
        urls.add("https://picsum.photos/id/81/5000/3250");
        urls.add("https://picsum.photos/id/82/1500/997");
        urls.add("https://picsum.photos/id/88/1280/1707");
        urls.add("https://picsum.photos/id/89/4608/2592");
        urls.add("https://picsum.photos/id/955/3872/2592");
        urls.add("https://picsum.photos/id/965/5000/3337");
        urls.add("https://picsum.photos/id/970/3264/2448");

        return urls;

    }
}