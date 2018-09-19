package com.obz.obzregistration;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityRegister extends AppCompatActivity {

    EditText name,mail,password1,password2;
    String Mail,Password1,Password2,Name;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mail = findViewById(R.id.mailId);
        password1 = findViewById(R.id.password1);
        password2 = findViewById(R.id.password2);
        name = findViewById(R.id.name);

    }

    public void BackPressed(View view) {
        super.onBackPressed();
    }

    public void Register(View view) {
        Mail = String.valueOf(mail.getText());
        Password1 = String.valueOf(password1.getText());
        Password2 = String.valueOf(password2.getText());
        Name = String.valueOf(name.getText());

        if(!Password2.equals(Password1)){
            Toast.makeText(this,"The passwords don't match",Toast.LENGTH_SHORT).show();
            password2.setText("");
            password1.setText("");
            name.setText(Name);
            mail.setText(Mail);
            return;

        }

        database = this.openOrCreateDatabase("Users",MODE_PRIVATE,null);
        database.execSQL("CREATE TABLE IF NOT EXISTS Users(name VARCHAR, mail VARCHAR, password VARCHAR)");
        database.execSQL("INSERT INTO Users(name, mail, password) VALUES('"+Name+"','"+Mail+"','"+Password1+"'"+")");

        Intent intent = new Intent(ActivityRegister.this,ActivityWelcome.class);
        Mail = Mail.toLowerCase();
        intent.putExtra("mail",Mail);
        startActivity(intent);
        finish();
    }
}
