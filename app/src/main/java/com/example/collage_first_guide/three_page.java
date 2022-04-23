package com.example.collage_first_guide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class three_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_page);
        Button tiffin=(Button) findViewById(R.id.tiffin);
        Button stationery=(Button) findViewById(R.id.stationery);
        Button paying_guest=(Button) findViewById(R.id.paying_guest);

        tiffin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(three_page.this,tiffin_page.class);
                startActivity(intent2);
            }
        });
        paying_guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(three_page.this,paying_guest.class);
                startActivity(intent3);
            }
        });
        stationery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4=new Intent(three_page.this,stationery.class);
                startActivity(intent4);
            }
        });
    }
}