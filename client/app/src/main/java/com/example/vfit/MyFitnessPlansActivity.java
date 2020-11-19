package com.example.vfit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MyFitnessPlansActivity extends AppCompatActivity {

    LinearLayout planList;
    ImageButton addButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fitness_plans2);

        planList = findViewById(R.id.PlanList);
        addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newPlan();
            }
        });
    }

    public void newPlan(){
        planList.addView(new TrainerPlansView(this, "crusher"));
    }
}