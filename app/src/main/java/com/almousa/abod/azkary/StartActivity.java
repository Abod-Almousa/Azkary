package com.almousa.abod.azkary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import static com.almousa.abod.azkary.R.*;

public class StartActivity extends AppCompatActivity {

    private CardView azkar, masbaha;
    private ImageView logo;

    private Animation logo_fade_in, azkar_tran, masbaha_tran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_start);

        azkar = findViewById(R.id.azkar);
        masbaha = findViewById(R.id.masbaha);
        logo = findViewById(R.id.logo);

        // animation for the logo
        logo_fade_in = AnimationUtils.loadAnimation(this,R.anim.logo_fade_in);
        logo.setAnimation(logo_fade_in);

        // animation for the buttons
        azkar_tran = AnimationUtils.loadAnimation(this, anim.azkar_tran);
        azkar.setAnimation(azkar_tran);
        masbaha_tran = AnimationUtils.loadAnimation(this, anim.masbaha_tran);
        masbaha.setAnimation(masbaha_tran);

        azkar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        masbaha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this, MasbahaActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}