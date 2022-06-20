package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity3 extends AppCompatActivity {
    TextInputLayout Femail;
    private String femail;
    Button Fb1, b2;
//    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main3);
//        mAuth = FirebaseAuth.getInstance();
        b2 = findViewById(R.id.b2);
        Fb1 = findViewById(R.id.fb1);
        Femail = findViewById(R.id.femail);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity3.this, login.class);
                startActivity(intent);
            }
        });
    }

    private Boolean validateEmail() {
        String val = Femail.getEditText().getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()) {
            Femail.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(emailPattern)) {
            Femail.setError("Invalid email address");
            return false;
        } else {
            Femail.setError(null);
            Femail.setErrorEnabled(false);
            return true;
        }
    }

    public void register(View view) {

        if (!validateEmail()) {

            return;
        }
    }
//    public void onClick(View view) {
//            mAuth.sendPasswordResetEmail(femail).addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                if (task.isSuccessful()) {
//                    Toast.makeText(MainActivity3.this,"check your mail",Toast.LENGTH_LONG).show();
//                    startActivity(new Intent(MainActivity3.this,login.class));
//                    finish();
//                } else {
//                    Toast.makeText(MainActivity3.this,"Error:"+task.getException().getMessage(),Toast.LENGTH_LONG).show();
//                }
//            }
//        });
//    }
}