package com.hcdc.cc106_finalproject_montera;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {

    ArrayList<String> session ,caloriesBurn, stepsCount, distance, date, duration;

    RecyclerView rviewmain;
    TextView accidmain;
    SQLiteDatabase myDB;
    String name,extractedid;
    Button addsessionmain;
    int countindex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ///////////////////////////////////////////////////////////////////////////
        addsessionmain = findViewById(R.id.addsession);
        accidmain = findViewById(R.id.accid);
        rviewmain = findViewById(R.id.rview);
        ///////////////////////////////////////////////////////////////////////////
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        accidmain.setText(name);
        ///////////////////////////////////////////////////////////////////////////
        myDB = openOrCreateDatabase("cc106_pedometer.db", 0, null);
        Cursor extractid = myDB.rawQuery("SELECT user_id AS user_id FROM useracc where useracc.name = ?;", new String[] {name});
        while (extractid.moveToNext()){
            countindex = extractid.getColumnIndex("user_id");
            extractedid = extractid.getString(countindex);
        }
        extractid.close();
        myDB.close();
        ///////////////////////////////////////////////////////////////////////////

        session = new ArrayList<>();
        caloriesBurn = new ArrayList<>();
        stepsCount = new ArrayList<>();
        distance = new ArrayList<>();
        date = new ArrayList<>();
        duration = new ArrayList<>();

        LinearLayoutManager layout = new LinearLayoutManager(this);
        rviewmain.setLayoutManager(layout);
        rviewmain.setAdapter
                (new AnotherDataAdapter(this,
                        session,
                        caloriesBurn,
                        stepsCount,
                        distance,
                        date,
                        duration));

        Display(); //Display Data on RecyclerView
        ///////////////////////////////////////////////////////////////////////////
        addsessionmain.setOnClickListener(view ->{
            try{
                Intent addsession = new Intent(DashboardActivity.this, inputpage.class);
                addsession.putExtra("name", name);
                startActivity(addsession);
            } catch (Exception e){
                Toast.makeText(this, "Error Occurred! Please Try Again Later ", Toast.LENGTH_SHORT).show();
            }
        });
        ///////////////////////////////////////////////////////////////////////////

    }


    private void Display(){
        myDB = openOrCreateDatabase("cc106_pedometer.db", 0, null);
        Cursor cursor = myDB.query("usersessionstats", null, null, null, null, null, "session_id");

        while( cursor.moveToNext()){
            session.add(cursor.getString(0));
            caloriesBurn.add(cursor.getString(2));
            stepsCount.add(cursor.getString(3));
            distance.add(cursor.getString(4));
            date.add(cursor.getString(5));
            duration.add(cursor.getString(6));

        }
        cursor.close();
        myDB.close();
    }
}