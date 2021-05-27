package com.almousa.abod.azkary;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AzkarAdapter extends RecyclerView.Adapter<AzkarAdapter.ViewHolder>{

    private Context context;
    private List<AzkarModel> azkars;

    public AzkarAdapter(Context context, List<AzkarModel> azkars) {
        this.context = context;
        this.azkars = azkars;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.azkar_item,parent,false);
        return new AzkarAdapter.ViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull AzkarAdapter.ViewHolder holder, int position) {

        AzkarModel azkar = azkars.get(position);

        holder.tv_azkar_text.setText(azkar.getText());
        holder.tv_azkar_desc.setText(azkar.getDesc());
        holder.tv_limit.setText(azkar.getLimit()+"");
        holder.tv_current_num.setText("0");

        // Click on repeat button to increase the current number and stop when equal the limit
        holder.repeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int limit = Integer.parseInt(holder.tv_limit.getText().toString());
                int current = Integer.parseInt(holder.tv_current_num.getText().toString());

                if(limit != current) {
                    current++;
                    if(limit == current){

                        //holder.bottom.setTag("limit");
                        //checkDarkMode(view, holder.bottom);

                        Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            v.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
                        } else {
                            v.vibrate(200);
                        }
                    }
                }

                holder.tv_current_num.setText(current+"");
            }
        });

        // Click on clear button to reset the current num to 0
        holder.clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.tv_current_num.setText("0");

                holder.bottom.setTag("clear");
                checkDarkMode(view, holder.bottom);
            }
        });
    }

    // When dark mode is enabled, do not change the bottom color for the item
    private void checkDarkMode(View view, RelativeLayout bottom) {

        int nightModeFlags =
                view.getResources().getConfiguration().uiMode &
                        Configuration.UI_MODE_NIGHT_MASK;
        switch (nightModeFlags) {
            case Configuration.UI_MODE_NIGHT_NO:
                if(bottom.getTag().equals("limit")) {
                    bottom.setBackgroundColor(view.getResources().getColor(R.color.red));
                }
                else {
                    bottom.setBackgroundColor(view.getResources().getColor(R.color.azkar_bottom));
                }
                break;
        }
    }

    @Override
    public int getItemCount() {
        return azkars.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_azkar_text;
        public TextView tv_azkar_desc;
        public TextView tv_current_num;
        public TextView tv_limit;
        public ImageView repeat;
        public ImageView clear;
        public RelativeLayout bottom;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_azkar_text = itemView.findViewById(R.id.tv_azkar_text);
            tv_azkar_desc = itemView.findViewById(R.id.tv_azkar_desc);
            tv_current_num = itemView.findViewById(R.id.tv_current_num);
            tv_limit = itemView.findViewById(R.id.tv_limit);
            repeat = itemView.findViewById(R.id.repeat);
            clear = itemView.findViewById(R.id.clear);
            bottom = itemView.findViewById(R.id.bottom);
        }
    }
}
