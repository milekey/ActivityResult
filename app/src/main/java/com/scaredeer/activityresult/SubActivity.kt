package com.scaredeer.activityresult

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.scaredeer.activityresult.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonYes.setOnClickListener {
            setResult(RESULT_OK)
            finish()
        }
        binding.buttonNo.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }
    }
}