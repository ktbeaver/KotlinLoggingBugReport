package org.example.bugreport

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

object Static {
    init {
        System.setProperty("kotlin-logging-to-android-native", "true")
    }
}

class MainActivity : ComponentActivity() {
    private val static = Static

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            App()
        }

        Log.i("MainActivity", "Creating Android native info log")
        Log.d("MainActivity", "Creating Android native debug log")
        Log.w("MainActivity", "Creating Android native warning log")
        Log.e("MainActivity", "Creating Android native error log")
        Log.wtf("MainActivity", "Creating Android native wtf log")
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}
