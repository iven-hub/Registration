package com.example.rgistration;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText  password,email;
    Button btn,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn = findViewById(R.id.btn);
        password = findViewById(R.id.password);
        email = findViewById(R.id.Email);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_SHORT).show();
                //startActivity(new Intent(Login.this, MainActivity.class));
                checkcredencial();

            }
        });
        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Registration menu", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Login.this, Registration.class));
            }
        });

    }

    private void checkcredencial() {
        String emal= email.getText().toString();
        String pass = password.getText().toString();

        if (emal.isEmpty() || !emal.contains("@gmail.com")){
            showError(email, "Email is not valid!");
        }else if (pass.isEmpty() || pass.length()<8) {
            showError(password, "Password must be least 8 character");
        }else{
            //Toast.makeText(this,"Welcome "+ user,Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Login.this, MainActivity.class));
        }

    }

    private void showError(EditText input, String s) {
        input.setError(s);
        input.requestFocus();
    }
}
