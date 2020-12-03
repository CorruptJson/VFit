package com.example.vfit;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private TextView warningLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        warningLabel = findViewById(R.id.warningLabel);
        warningLabel.setText("");
        warningLabel.setGravity(Gravity.CENTER);
    }

    public void login(View view) throws JSONException {
        // check if account details exist
        // on login take user to new screen
        String url = RequestHelper.url + "/auth/login";
        JSONObject params = new JSONObject();

        String username_input = ((EditText) findViewById(R.id.userInput)).getText().toString();
        String password_input = ((EditText) findViewById(R.id.passwordInput)).getText().toString();
        params.put("username", username_input);
        params.put("password", password_input);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("Response", response.toString());
                warningLabel.setText("");
                Intent intent = new Intent(MainActivity.this, MyFitnessPlansActivity.class);
                startActivity(intent);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                //Todo: handle error
                warningLabel.setText("Username/password may not exist!");
                Log.d("error", error.toString());

            }
        });


        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(
                15000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        VolleySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
    }

    public void createAccount(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
