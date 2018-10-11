package com.example.yuezehou.gymui1;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.yuezehou.gymui1.R;


public class LoginActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView tv_register = (TextView) findViewById(R.id.register);
        tv_register.setClickable(true);
        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent2);
            }});

        TextView tv_login = (TextView) findViewById(R.id.login);
        tv_login.setClickable(true);
        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent3);
            }});



    }
}
