package com.example.android.shahniz_1202150279_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private static EditText username, password;
    private static Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginButton();
    }

    public void LoginButton(){
        username = (EditText)findViewById(R.id.editText_user);
        password = (EditText)findViewById(R.id.editText_password);
        login = (Button)findViewById(R.id.button_login);

        login.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        validate(username.getText().toString(), password.getText().toString());
                    }
                }
        );
    }
    private void validate (String uname,String pass) {
        if ((uname.equals("EAD")) && (pass.equals("MOBILE"))) {
            Toast.makeText(Login.this,"You're Logged In!",
                    Toast.LENGTH_SHORT).show();
            Intent intent = new Intent (Login.this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(Login.this,"Username and password is NOT correct",
                    Toast.LENGTH_SHORT).show();
        }
    }

}


