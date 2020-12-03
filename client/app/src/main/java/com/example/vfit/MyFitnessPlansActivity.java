package com.example.vfit;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MyFitnessPlansActivity extends AppCompatActivity {

    LinearLayout planList;
    ImageButton addButton;
    private static final int CREATE_FITNESS_PLAN = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fitness_plans2);

        planList = findViewById(R.id.PlanList);
        configureAddButton();
    }

    private void configureAddButton(){
        addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MyFitnessPlansActivity.this, CreateFitnessPlan.class),CREATE_FITNESS_PLAN);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CREATE_FITNESS_PLAN && resultCode == RESULT_OK){
            newPlan(data.getStringExtra("Routine Name"));
        }
        Log.d("Request Code", "R= " + requestCode);
        System.out.println("Hello");
    }

    public void newPlan(String text){
        TrainerPlansView plan = new TrainerPlansView(this,text);
        plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyFitnessPlansActivity.this,UserFitnessPlans.class));
            }
        });
        planList.addView(plan);
    }
}
