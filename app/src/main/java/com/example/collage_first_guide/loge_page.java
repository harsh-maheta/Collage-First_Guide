package com.example.collage_first_guide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

import java.security.PrivateKey;

public class loge_page extends AppCompatActivity {
    private EditText editTxt_email,editTxt_password;
   private String email ;
   private String password ;
    private FirebaseAuth mAuth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loge_page);

        Button login_btn1 = (Button) findViewById(R.id.login_btn1);
        editTxt_email = (EditText) findViewById(R.id.editTxt_email);
        editTxt_password = (EditText) findViewById(R.id.editTxt_password);

        mAuth = FirebaseAuth.getInstance();
//        if (mAuth.getCurrentUser() != null) {
//            finish();
//            return;
//        }
        login_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    login();
            }
        });
   }
 public void login(){


      email= editTxt_email.getText().toString().trim();
      password = editTxt_password.getText().toString().trim();

     if (email.isEmpty() || password.isEmpty()) {
         Toast.makeText(this, "Please fill all fields", Toast.LENGTH_LONG).show();

     }
     else{
         createUser();
     }
 }
    private void createUser() {

                mAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this,new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                            Intent intent1 = new Intent(loge_page.this, three_page.class);
                            startActivity(intent1);
                            Toast.makeText(getApplicationContext(),"successful login",Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
                        }
                        editTxt_email.setText("");
                        editTxt_password.setText("");
                    }
                });
    }
}