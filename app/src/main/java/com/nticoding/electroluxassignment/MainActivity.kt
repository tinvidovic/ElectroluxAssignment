package com.nticoding.electroluxassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.unit.dp
import com.nticoding.electroluxassignment.presentation.components.HorizontalDivider
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