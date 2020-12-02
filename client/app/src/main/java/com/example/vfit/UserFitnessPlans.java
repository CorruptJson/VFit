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
    private Button returnButton;
    private Button datePrevious;
    private Button dateNext;
    private TextView weekText;
    int weekStart = 1;
    int weekEnd = 4;
    int weekCount = (weekEnd - weekStart) + 1;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_fitness_plans);

        returnButton = findViewById(R.id.returnButton);
        datePrevious = findViewById(R.id.datePrevious);
        dateNext = findViewById(R.id.dateNext);
        weekText = findViewById(R.id.weekText);
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
    }

    public void returnMenu() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
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
