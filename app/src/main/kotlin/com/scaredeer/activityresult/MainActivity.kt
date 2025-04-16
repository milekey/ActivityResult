package com.scaredeer.activityresult

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import com.scaredeer.activityresult.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val activityResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        when (result.resultCode) {
            RESULT_OK -> {
                Snackbar.make(
                    findViewById(android.R.id.content),
                    "Result from SubActivity: OK",
                    BaseTransientBottomBar.LENGTH_LONG
                ).show()
            }
            RESULT_CANCELED -> {
                Snackbar.make(
                    findViewById(android.R.id.content),
                    "Result from SubActivity: CANCELED",
                    BaseTransientBottomBar.LENGTH_LONG
                ).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            activityResultLauncher.launch(
                Intent(this, SubActivity::class.java)
            )
        }
    }
}