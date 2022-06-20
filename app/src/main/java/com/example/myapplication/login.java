package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


public class login extends AppCompatActivity {
    TextInputLayout Username,Password;
    Button b2;
    TextView b3;
    FirebaseDatabase rootNode;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        b3 = findViewById(R.id.b3);
        b2 = findViewById(R.id.b2);
        Username = findViewById(R.id.username);
        Password = findViewById(R.id.password);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this, signup.class);
                startActivity(intent);

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this, MainActivity3.class);
                startActivity(intent);

            }
        });
    }






        private Boolean validateUsername() {
            String val = Username.getEditText().getText().toString();

            if (val.isEmpty()) {
                Username.setError("Field cannot be empty");
                return false;
            }
            else {
                Username.setError(null);
                Username.setErrorEnabled(false);
                return true;
            }
        }
    private Boolean validatePassword() {
        String val = Password.getEditText().getText().toString();

        if (val.isEmpty()) {
            Password.setError("Enter proper password!");
            return false;
        }
        else {
            Password.setError(null);
            Password.setErrorEnabled(false);
            return true;
        }
    }

    public void register(View view) {

        if(!validateUsername() | !validatePassword()){
            return;
        }
        String _Username = Username.getEditText().getText().toString().trim();
        String _Password = Password.getEditText().getText().toString().trim();

        Query checkUser = FirebaseDatabase.getInstance().getReference("users").orderByChild("username");

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    Username.setError(null);
                    Username.setErrorEnabled(false);

                    String systemPassword = dataSnapshot.child("password").getValue(String.class);
                    if (systemPassword.equals(_Password)) {
                        Password.setError(null);
                        Password.setErrorEnabled(false);
                    }
                    else{
                        Toast.makeText(login.this, "password does not exists", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(login.this, "data does not exists", Toast.LENGTH_SHORT).show();

            }
        });
    }

}
