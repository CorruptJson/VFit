package com.example.vfit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateFitnessPlan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_fitness_plan);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button create = findViewById(R.id.create);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPlan();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return super.onOptionsItemSelected(item);
    }

    public void createPlan(){
        String fitnessPlanName = ((EditText) findViewById(R.id.routine_name)).getText().toString();

        Intent intent = new Intent(this, MyFitnessPlansActivity.class);
        intent.putExtra("Routine Name", fitnessPlanName);
        setResult(RESULT_OK, intent);
        finish();
    }

}
