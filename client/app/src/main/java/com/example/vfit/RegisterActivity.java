package com.example.vfit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {
    private TextView warningLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        warningLabel = findViewById(R.id.warningLabel);
        warningLabel.setText("");
        warningLabel.setGravity(Gravity.CENTER);
    }

    public void register(View view) throws JSONException {
        // take user to main screen after registering account details
        EditText username = (EditText) findViewById(R.id.nameInput);
        EditText password = (EditText) findViewById(R.id.passwordInput);
        EditText confirmPassword = (EditText) findViewById(R.id.confirmPasswordInput);

        if (password.getText().toString().equals(confirmPassword.getText().toString())) {
            String url = RequestHelper.url + "/auth/register";
            JSONObject params = new JSONObject();
            params.put("username", username.getText().toString());
            params.put("password", password.getText().toString());

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    Log.d("Response", response.toString());
                    warningLabel.setText("");
                    Intent intent = new Intent(RegisterActivity.this, MyFitnessPlansActivity.class);
                    startActivity(intent);
                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    //Todo: handle error
                    warningLabel.setText("Username already in use");
                    Log.d("error", error.toString());

                }
            });

            VolleySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
        } else {
            Log.d("error", "Passwords don't match");
            warningLabel.setText("Passwords must match");
        }
    }
}
