package com.example.vfit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void register(View view) {
        // take user to main screen after registering account details
        EditText name = (EditText) findViewById(R.id.nameInput);
        EditText email = (EditText) findViewById(R.id.userInput);
        EditText password = (EditText) findViewById(R.id.passwordInput);
        EditText confirmPassword = (EditText) findViewById(R.id.confirmPasswordInput);

        if (password.getText().toString().equals(confirmPassword.getText().toString())) {
            // register after confirming password and store account details
            //Log.d("Name", name.getText().toString());
            //Log.d("Email", email.getText().toString());
            //Log.d("Password", password.getText().toString());
        }
    }
}
