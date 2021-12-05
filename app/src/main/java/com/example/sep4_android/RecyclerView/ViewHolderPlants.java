package com.example.sep4_android.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sep4_android.R;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

public class ViewHolderPlants extends RecyclerView.ViewHolder {
    TextView timeDis,nameDis;

    public ViewHolderPlants(@NonNull @NotNull View itemView) {
        super(itemView);
    }

    public void setItem(Activity activity, String startDate, int wateringFrequency, String time, double waterPerYards,
                        double amountOfLand, double harvestAfterMonths, String plantName){
        timeDis = itemView.findViewById(R.id.time_item_tv);
        nameDis = itemView.findViewById(R.id.name_item_tv);

        timeDis.setText(time);
        nameDis.setText(plantName);

    }
    public void destroy(){
        itemView.setVisibility(View.GONE);
    }
}

