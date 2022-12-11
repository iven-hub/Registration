package com.example.rgistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    Button btn, btn2;
    private EditText username, password,email,comfirmpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        btn = findViewById(R.id.btn);
        btn2 =findViewById(R.id.btn2);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        email = findViewById(R.id.Email);
        comfirmpass = findViewById(R.id.comfirmpass);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Login", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Registration.this, Login.class));
                checkcredencial();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // startActivity(new Intent(Registration.this, MainActivity.class));
                checkcredencial();
            }
        });
    }

    private void checkcredencial() {
        String user= username.getText().toString();
        String emal= email.getText().toString();
        String pass = password.getText().toString();
        String compass = comfirmpass.getText().toString();

        if (user.isEmpty() || user.length() < 7) {
            showError (username, "Your name is not valid!   ");
        } else if (emal.isEmpty() || !emal.contains("@gmail.com")){
            showError(email, "Email is not valid!");
        }else if (pass.isEmpty() || pass.length()<8) {
            showError(password, "Password must be least 8 character");
        }else if (compass.isEmpty() || !compass.equals(pass)){
            showError(comfirmpass, "Password not match!");
        }else{
            Toast.makeText(this,"Welcome "+ user,Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Registration.this, MainActivity.class));
        }

    }

    private void showError(EditText input, String s) {
        input.setError(s);
        input.requestFocus();
    }
}