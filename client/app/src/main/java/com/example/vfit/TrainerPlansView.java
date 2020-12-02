package com.example.vfit;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

public class TrainerPlansView extends ConstraintLayout {
    String planName;
    TextView planNameView;
    ImageView trainerView;
    public TrainerPlansView(Context context, String viewText)
    {
        super(context);

        inflate(getContext(), R.layout.trainer_my_fitness_plans_view,this);
        planName = viewText;
        planNameView = findViewById(R.id.textView);
        planNameView.setText(planName);
        trainerView = findViewById(R.id.imageView);
        trainerView.setImageResource(R.drawable.ic_launcher_background);
    }
}
