package com.example.collage_first_guide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editTxt_email,editTxt_emial1,editTxt_password,editTxt_password1,editTxt_name;
    Button login_btn,login_btn1,signup_btn,signup_btn1,gujrati,
            panjabi,kathiyavadi,restaurant,fast_food,other,fur_btn,
            fur_not_btn,emt_btn,ful_faci_btn,prvt_btn,gov_btn;
    TextView txt_email,txt_password,txt_email1,txt_password1,txt_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login_btn = (Button) findViewById(R.id.login_btn);
        signup_btn=(Button)findViewById(R.id.signup_btn) ;

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,loge_page.class);
                startActivity(intent);
                                         }
        });
        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,signup_page.class);
                startActivity(intent);
            }
        });


    }
}