package com.nticoding.electroluxassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.nticoding.electroluxassignment.ui.theme.ElectroluxAssignmentTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ElectroluxAssignmentTheme {
            }
        }
    }
}