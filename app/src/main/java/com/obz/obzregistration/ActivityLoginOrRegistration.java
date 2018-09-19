package com.obz.obzregistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ActivityLoginOrRegistration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_or_registration);
    }

    public void LogIn(View view) {
        startActivity(new Intent(ActivityLoginOrRegistration.this,ActivityLogin.class));
    }

    public void Register(View view) {
        startActivity(new Intent(ActivityLoginOrRegistration.this,ActivityRegister.class));
    }
}
