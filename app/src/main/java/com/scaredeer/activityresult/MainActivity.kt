package com.scaredeer.activityresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Snackbar.make(
                                findViewById(android.R.id.content),
                                "Result OK",
                                BaseTransientBottomBar.LENGTH_LONG
                        ).show();
                    }
                });

        findViewById(R.id.button).setOnClickListener(view ->
                activityResultLauncher.launch(new Intent(this, SecondActivity.class))
        );
    }
}