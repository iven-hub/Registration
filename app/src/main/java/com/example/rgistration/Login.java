package com.example.rgistration;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Login extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com";
    EditText password, email;
    Button btn, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn = findViewById(R.id.btn);
        btn2 = findViewById(R.id.btn2);
        password = findViewById(R.id.edit_password);
        email = findViewById(R.id.name_text);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_SHORT).show();
            //startActivity(new Intent(Login.this, MainActivity.class));
            checkcredencial();

            }
        });

        btn2.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(), "Registration menu", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Login.this, Registration.class));
        });
    }

    private void checkcredencial() {
        String emal = email.getText().toString();
        String pass = password.getText().toString();

        if (!emal.contains("@gmail.com")) {
            showError(email, "Email is not valid!");

        } else if (pass.isEmpty() || pass.length() < 8) {
            showError(password, "Password must be least 8 character");

        } else {

            for (int i = 0; i < Db.Userlist.size(); i++){
                User user = Db.Userlist.get(i);
                String name;
                name = user.getUser();
                if (user.getEmail().equals(emal) && user.getPassword().equals(pass)){
                    Intent login = new Intent(Login.this, MainActivity.class);
                    login.putExtra(EXTRA_MESSAGE, name);
                    startActivity(login);
                    Toast.makeText(getApplicationContext(), "Login succedded", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "You are not registed", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private void showError( EditText input, String s) {
        input.setError(s);
        input.requestFocus();
    }
}

