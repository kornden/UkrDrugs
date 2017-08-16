package com.kornden.ukrdrugs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView nationalList = (TextView) findViewById(R.id.national_list_link);
        nationalList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent natList = new Intent(MainActivity.this, NationalList.class);
                startActivity(natList);
            }
        });
        TextView availableDrugs = (TextView) findViewById(R.id.affordable_drugs_link);
        availableDrugs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent affordDrugs = new Intent(MainActivity.this, AffordableDrugs.class);
                startActivity(affordDrugs);
            }
        });
    }
}
