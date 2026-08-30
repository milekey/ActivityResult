package com.scaredeer.activityresult.ui.widget

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.scaredeer.activityresult.ui.theme.AppTheme

@Composable
fun TextButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = { onClick() },
        modifier = modifier
    ) {
        Text(
            text,
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TextButtonPreview() {
    AppTheme {
        TextButton(text = "Android", onClick = {})
    }
}