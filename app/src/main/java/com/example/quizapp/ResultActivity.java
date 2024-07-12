package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.quizapp.Activity.MainActivitynnn;

public class ResultActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textView = findViewById(R.id.textView);
        int score = getIntent().getIntExtra("Hasil",0);
        textView.setText("Score : " + score);

        findViewById(R.id.btn_restart).setOnClickListener(
                restart->{
                    Intent intent  = new Intent(ResultActivity.this , MainActivitynnn.class);
                    startActivity(intent);
                    finish();

                }
        );
    }
}