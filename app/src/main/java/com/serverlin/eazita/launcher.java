package com.serverlin.eazita;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class launcher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        // Set up the login form.
        SharedPreferences sharedpreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String sess = sharedpreferences.getString("status", null);
        if(sess != null) {
            if (sess.equals("logined")) {
                Log.e("Auth", sess);
                Intent intent_name = new Intent();
                intent_name.setClass(this, msgs.class);
                startActivity(intent_name);
                finish();
            }
        } else {
            Intent intent_name = new Intent();
            intent_name.setClass(this, Login.class);
            startActivity(intent_name);
            finish();
        }


    }
}
