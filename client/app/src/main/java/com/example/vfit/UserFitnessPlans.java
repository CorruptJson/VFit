package com.example.vfit;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

@RequiresApi(api = Build.VERSION_CODES.N)
public class UserFitnessPlans extends AppCompatActivity {
    private TextView weekText;
    int weekStart = 1;
    int weekEnd = 4;
    int weekCount = (weekEnd - weekStart) + 1;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_fitness_plans);

        Button returnButton = findViewById(R.id.returnButton);
        Button datePrevious = findViewById(R.id.datePrevious);
        Button dateNext = findViewById(R.id.dateNext);
        weekText = findViewById(R.id.weekText);

        Button mondayRoutineButton = findViewById(R.id.mondayRoutineButton);
        Button tuesdayRoutineButton = findViewById(R.id.tuesdayRoutineButton);
        Button wednesdayRoutineButton = findViewById(R.id.wednesdayRoutineButton);
        Button thursdayRoutineButton = findViewById(R.id.thursdayRoutineButton);
        Button fridayRoutineButton = findViewById(R.id.fridayRoutineButton);
        Button saturdayRoutineButton = findViewById(R.id.saturdayRoutineButton);
        Button sundayRoutineButton = findViewById(R.id.sundayRoutineButton);
        Button mondayMealButton = findViewById(R.id.mondayMealButton);
        Button tuesdayMealButton = findViewById(R.id.tuesdayMealButton);
        Button wednesdayMealButton = findViewById(R.id.wednesdayMealButton);
        Button thursdayMealButton = findViewById(R.id.thursdayMealButton);
        Button fridayMealButton = findViewById(R.id.fridayMealButton);
        Button saturdayMealButton = findViewById(R.id.saturdayMealButton);
        Button sundayMealButton = findViewById(R.id.sundayMealButton);
        printWeek();
        returnButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                returnMenu();
            }
        });

        datePrevious.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                prevWeek();
                printWeek();
            }
        });

        dateNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                nextWeek();
                printWeek();
            }
        });

        mondayRoutineButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserFitnessPlans.this, PopUp.class));
            }
        });

        tuesdayRoutineButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserFitnessPlans.this, PopUp.class));
            }
        });

        wednesdayRoutineButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserFitnessPlans.this, PopUp.class));
            }
        });

        thursdayRoutineButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserFitnessPlans.this, PopUp.class));
            }
        });

        fridayRoutineButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserFitnessPlans.this, PopUp.class));
            }
        });

        saturdayRoutineButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserFitnessPlans.this, PopUp.class));
            }
        });

        sundayRoutineButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserFitnessPlans.this, PopUp.class));
            }
        });

        mondayMealButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserFitnessPlans.this, PopUp.class));
            }
        });

        tuesdayMealButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserFitnessPlans.this, PopUp.class));
            }
        });

        wednesdayMealButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserFitnessPlans.this, PopUp.class));
            }
        });

        thursdayMealButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserFitnessPlans.this, PopUp.class));
            }
        });

        fridayMealButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserFitnessPlans.this, PopUp.class));
            }
        });

        saturdayMealButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserFitnessPlans.this, PopUp.class));
            }
        });

        sundayMealButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserFitnessPlans.this, PopUp.class));
            }
        });
    }

    public void returnMenu() {
        setResult(RESULT_OK);
        finish();
    }

    public void nextWeek() {
        count++;
    }

    public void prevWeek() {
        count--;
    }

    public void printWeek() {
        int week = weekStart + count;
        if(week > weekEnd) {
            week -= weekCount;
            count = 0;
        }
        if(week < weekStart) {
            week += weekCount;
            count = 3;
        }
        weekText.setText("Week " + week);
    }
}
