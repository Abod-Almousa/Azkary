package com.almousa.abod.azkary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class AzkarActivity extends AppCompatActivity {

    private RecyclerView rv_azkar;
    private AzkarAdapter azkarAdapter;
    private ArrayList<AzkarModel> azkarList;
    private DatabaseAccess db;

    private String category;
    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_azkar);

        // We got this data from Main activity
        Intent intent = getIntent();
        category = intent.getStringExtra("category");

        // To set the title based on the category
        switch (category) {

            case "morning":
                title = "أذكار الصباح";
                break;

            case "night":
                title = "أذكار المساء";
                break;

            case "sleep":
                title = "أذكار النوم";
                break;

            case "waking_up":
                title = "أذكار الإستيقاظ";
                break;

            case "azan":
                title = "أذكار الأذان";
                break;

            case "pray":
                title = "أذكار بعد الصلاة";
                break;
        }

        // For the toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Open connection to the database and get the data based on the category
        db = DatabaseAccess.getInstance(this);
        db.open();
        azkarList = db.getAzkars(category);
        db.close();

        rv_azkar = findViewById(R.id.rv_azkar);
        azkarAdapter = new AzkarAdapter(this,azkarList);
        rv_azkar.setAdapter(azkarAdapter);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rv_azkar.setLayoutManager(lm);
        rv_azkar.setHasFixedSize(true);
    }
}