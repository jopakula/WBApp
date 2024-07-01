package com.example.uikit.data

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

data class Event(
    val image: Int,
    val cardText: String,
    val meetingStateText: String?,
    val cardHint: String,
    val chips: List<@Composable (Modifier) -> Unit> = emptyList()
)