package com.scaredeer.activityresult

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.scaredeer.activityresult.ui.theme.AppTheme
import com.scaredeer.activityresult.ui.widget.TextButton

private val TAG = SubActivity::class.simpleName

class SubActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v(TAG, "onCreate")
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(innerPadding).fillMaxSize()
                    ) {
                        TextButton(
                            text = "Yes",
                            onClick = {
                                setResult(RESULT_OK)
                                finish()
                            },
                            modifier = Modifier
                        )
                        TextButton(
                            text = "No",
                            onClick = {
                                setResult(RESULT_CANCELED)
                                finish()
                            },
                            modifier = Modifier
                        )
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        Log.v(TAG, "onDestroy")
        super.onDestroy()
    }
}