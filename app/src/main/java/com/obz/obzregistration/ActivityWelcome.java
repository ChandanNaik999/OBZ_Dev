package com.obz.obzregistration;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityWelcome extends AppCompatActivity {
    SQLiteDatabase database;
    TextView textView_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String mail;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        textView_name = findViewById(R.id.textView_name);

        mail = getIntent().getStringExtra("mail");

        database = this.openOrCreateDatabase("Users",MODE_PRIVATE,null);
        Cursor db_cursor = database.rawQuery("SELECT * FROM Users" ,null);
        int mailIndex = db_cursor.getColumnIndex("mail");
        int nameIndex = db_cursor.getColumnIndex("name");
        db_cursor.moveToFirst();
        int i=0;
        while(i <= db_cursor.getCount()){
            if(db_cursor.getString(mailIndex).equals(mail)){
                textView_name.setText(db_cursor.getString(nameIndex));
                break;
            }
            i++;
            db_cursor.moveToNext();
        }

    }


    public void LogOut(View view) {
        finish();
    }

    @Override
    public void onBackPressed() {}
}
