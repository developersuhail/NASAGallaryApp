package com.example.nasapictureapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.nasapictureapp.R;


public class SpalshActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh);


        new Handler().post(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SpalshActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}