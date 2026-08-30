package com.scaredeer.activityresult

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.scaredeer.activityresult.ui.theme.AppTheme
import com.scaredeer.activityresult.ui.widget.TextButton
import kotlinx.coroutines.launch

private val TAG = MainActivity::class.simpleName

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v(TAG, "onCreate")
        enableEdgeToEdge()
        setContent {
            val scope = rememberCoroutineScope()
            val snackbarHostState = remember { SnackbarHostState() }
            val launcher = rememberLauncherForActivityResult(
                ActivityResultContracts.StartActivityForResult()
            ) { result: ActivityResult ->
                when (result.resultCode) {
                    RESULT_OK -> {
                        val message = "Result from SubActivity: OK"
                        Log.d(TAG, message)
                        scope.launch {
                            snackbarHostState.showSnackbar(message)
                        }
                    }

                    RESULT_CANCELED -> {
                        val message = "Result from SubActivity: CANCELED"
                        Log.d(TAG, message)
                        scope.launch {
                            snackbarHostState.showSnackbar(message)
                        }
                    }
                }
            }

            AppTheme {
                Scaffold(
                    snackbarHost = {
                        SnackbarHost(hostState = snackbarHostState)
                    },
                    modifier = Modifier.fillMaxSize(),
                ) { innerPadding ->
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    ) {
                        val context = LocalContext.current
                        TextButton(
                            text = "Go to Sub Activity",
                            onClick = {
                                launcher.launch(
                                    Intent(context, SubActivity::class.java)
                                )
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