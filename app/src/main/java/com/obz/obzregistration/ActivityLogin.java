package com.obz.obzregistration;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityLogin extends AppCompatActivity {
    EditText  mail,password;
    String Mail,Password;
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mail = findViewById(R.id.mailId);
        password = findViewById(R.id.password);

    }

    public void LogIn(View view) {
        Mail = String.valueOf(mail.getText());
        Password = String.valueOf(password.getText());


        database = this.openOrCreateDatabase("Users",MODE_PRIVATE,null);
        @SuppressLint("Recycle") Cursor db_cursor = database.rawQuery("SELECT * FROM Users" ,null);
        int mailIndex = db_cursor.getColumnIndex("mail");
        int passwordIndex = db_cursor.getColumnIndex("password");
        db_cursor.moveToFirst();
        int i=0,flag = 0;
        while(i < db_cursor.getCount()){
            if(db_cursor.getString(mailIndex).equals(Mail) && db_cursor.getString(passwordIndex).equals(Password) ){
                Intent intent = new Intent(ActivityLogin.this,ActivityWelcome.class);
                Mail = Mail.toLowerCase();
                flag = 1;
                intent.putExtra("mail",Mail);
                startActivity(intent);
                finish();
            }
            i++;
            db_cursor.moveToNext();
        }
        if(flag == 0){
            Toast.makeText(this,"Invalid Data",Toast.LENGTH_SHORT).show();
            mail.setText("");
            password.setText("");
        }

    }
    public void BackPressed(View view) {
        super.onBackPressed();
    }
}
