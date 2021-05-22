package com.almousa.abod.azkary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.robinhood.ticker.TickerUtils;
import com.robinhood.ticker.TickerView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MasbahaActivity extends AppCompatActivity {

    private CircleImageView tasbih;
    private TickerView counter;
    private ImageView clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masbaha);

        tasbih = findViewById(R.id.tasbih);
        counter = findViewById(R.id.counter);
        clear = findViewById(R.id.clear);

        counter.setCharacterLists(TickerUtils.provideNumberList());
        counter.setText("0");

        // To increase the number of TASBIH
        tasbih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int current = Integer.parseInt(counter.getText().toString());

                current++;

                counter.setText(current+"");
            }
        });

        // To clear the current number
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter.setText("0");

                Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    v.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    v.vibrate(200);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(MasbahaActivity.this,StartActivity.class);
        startActivity(intent);
        finish();
    }
}