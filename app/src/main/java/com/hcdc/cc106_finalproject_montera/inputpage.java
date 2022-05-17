package com.hcdc.cc106_finalproject_montera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class inputpage extends AppCompatActivity {

    Button nextbuttonmain;
    EditText inputgoalmain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputpage);

        nextbuttonmain = findViewById(R.id.nextbutton);
        inputgoalmain = findViewById(R.id.inputgoal);

        Intent myname = getIntent();
        String name = myname.getStringExtra("name");

        nextbuttonmain.setOnClickListener(view ->{
            try{
            Intent addsession = new Intent(inputpage.this, MainActivity.class);
            addsession.putExtra("name", name);
            addsession.putExtra("goalkm", inputgoalmain.getText().toString());
            startActivity(addsession);
            finish();
            } catch (Exception e){
                Toast.makeText(this, "Error Occurred! Please Try Again Later ", Toast.LENGTH_SHORT).show();
            }
        });

    }
}