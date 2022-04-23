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
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.BreakIterator;

public class signup_page extends AppCompatActivity {

    private  EditText editTxt_name;
   private EditText editTxt_email1;
  private  EditText editTxt_password1;
    private FirebaseAuth mAuth;
    private String name;
    private String email;
    private String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);
        Button signup_btn1 = (Button) findViewById(R.id.signup_btn1);
        editTxt_name=(EditText)findViewById(R.id.editTxt_name);
        editTxt_email1=(EditText)findViewById(R.id.editTxt_emial1);
        editTxt_password1=(EditText) findViewById(R.id.editTxt_password1);

        mAuth=FirebaseAuth.getInstance();
//        if(mAuth.getCurrentUser()!=null){
//            finish();
//            return;
//        }
        signup_btn1.setOnClickListener(new View.OnClickListener() {
            @SuppressWarnings("JoinDeclarationAndAssignmentJava")

            @Override
            public void onClick(View v) {

                sign();
            }
        });
    }


    private void sign() {

         name = editTxt_name.getText().toString().trim();
         email= editTxt_email1.getText().toString().trim();
         password = editTxt_password1.getText().toString().trim();

//        Dataholder dataholder=new Dataholder(email,password);
//
//        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
//        DatabaseReference root=firebaseDatabase.getReference("user");
//
//        root.child(name).setValue(dataholder);
//        editTxt_email1.setText("");
//        editTxt_name.setText("");
//        editTxt_password1.setText("");
//        Toast.makeText(getApplicationContext(),"data successful insert!",Toast.LENGTH_LONG).show();

        if(name.isEmpty()||email.isEmpty()||password.isEmpty()){
            Toast.makeText(this,"please fill all fields",Toast.LENGTH_LONG).show();
            return;
        }
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){

                            Dataholder dataholder =new Dataholder(name,email,password);
                            FirebaseDatabase.getInstance().getReference("user")
//                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .child(name)
                                    .setValue(dataholder).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    Intent intent1=new Intent(signup_page.this,three_page.class);
                                    startActivity(intent1);

                                    Toast.makeText(getApplicationContext(),"data successful insert!",Toast.LENGTH_LONG).show();
                                    editTxt_email1.setText("");
                                     editTxt_name.setText("");
                                      editTxt_password1.setText("");
                                }
                            });
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"data Not sccessful insert!",Toast.LENGTH_LONG).show();
                            editTxt_email1.setText("");
                            editTxt_name.setText("");
                            editTxt_password1.setText("");
                    }

                    }
                });
    }
}