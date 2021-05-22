package com.almousa.abod.azkary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private CardView morning_azkar, night_azkar, sleep_azkar, waking_up_azkar, azan_azkar, pray_azkar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        morning_azkar = findViewById(R.id.morning_azkar);
        night_azkar = findViewById(R.id.night_azkar);
        sleep_azkar = findViewById(R.id.sleep_azkar);
        waking_up_azkar = findViewById(R.id.waking_up_azkar);
        azan_azkar = findViewById(R.id.azan_azkar);
        pray_azkar = findViewById(R.id.pray_azkar);

        // For the toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,StartActivity.class);
                startActivity(intent);
                finish();
            }
        });

        morning_azkar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AzkarActivity.class);
                intent.putExtra("category", "morning");
                startActivity(intent);
            }
        });

        night_azkar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AzkarActivity.class);
                intent.putExtra("category", "night");
                startActivity(intent);
            }
        });

        sleep_azkar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AzkarActivity.class);
                intent.putExtra("category", "sleep");
                startActivity(intent);
            }
        });

        waking_up_azkar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AzkarActivity.class);
                intent.putExtra("category", "waking_up");
                startActivity(intent);
            }
        });

        azan_azkar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AzkarActivity.class);
                intent.putExtra("category", "azan");
                startActivity(intent);
            }
        });

        pray_azkar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AzkarActivity.class);
                intent.putExtra("category", "pray");
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(MainActivity.this,StartActivity.class);
        startActivity(intent);
        finish();
    }
}