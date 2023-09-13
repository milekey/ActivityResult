package com.scaredeer.activityresult;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setResult(RESULT_OK);

        setContentView(R.layout.activity_second);
        findViewById(R.id.button).setOnClickListener(view -> finish());
    }
}