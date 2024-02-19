package com.nticoding.electroluxassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.invisibleToUser
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.nticoding.electroluxassignment.data.ProgramDataStore
import com.nticoding.electroluxassignment.domain.mapper.toSelectableOption
import com.nticoding.electroluxassignment.presentation.components.SelectableItemList
import com.nticoding.electroluxassignment.presentation.components.Surface
import com.nticoding.electroluxassignment.presentation.program_list.ProgramListScreen
import com.nticoding.electroluxassignment.ui.theme.ElectroluxAssignmentTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalComposeUiApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            ElectroluxAssignmentTheme {
                Surface(
                    onClick = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .semantics {
                            // Mark home surface as invisible to talkback
                            this.invisibleToUser()
                        }
                ) {
                    ProgramListScreen()
                }

            }
        }
    }
}