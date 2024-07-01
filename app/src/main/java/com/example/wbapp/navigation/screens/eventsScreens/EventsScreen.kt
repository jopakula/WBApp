package com.example.wbapp.navigation.screens.eventsScreens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.R
import com.example.uikit.base.chip.WBChip
import com.example.uikit.base.common.BrandColorWhite
import com.example.uikit.base.icon.WBIcon
import com.example.uikit.base.inputField.WBInputField
import com.example.uikit.base.text.WBText
import com.example.uikit.data.Event
import com.example.uikit.elements.event.WBEventList
import com.example.wbapp.navigation.WBTopAppBar


@Composable
fun EventsScreen(
    label: String = "Events",
    backgroundColor: Color = BrandColorWhite,
) {
    var text by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current
    val allEvents = List(10) {
        Event(
            R.drawable.frame,
            cardText = "Developer meeting",
            meetingStateText = null,
            cardHint = "13.09.2024 — Москва",
            chips = listOf(
                { modifier -> WBChip(modifier = modifier, text = "Python") },
                { modifier -> WBChip(modifier = modifier, text = "Junior") },
                { modifier -> WBChip(modifier = modifier, text = "Moscow") }
            )
        )
    }

    val activeEvents = List(5) {
        Event(
            R.drawable.frame,
            "Active meeting",
            "Ongoing",
            "14.09.2024 — Санкт-Петербург",
            chips = listOf(
                { modifier -> WBChip(modifier = modifier, text = "Kotlin") },
                { modifier -> WBChip(modifier = modifier, text = "Senior") },
                { modifier -> WBChip(modifier = modifier, text = "St. Petersburg") }
            )
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 14.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            WBText(
                text = label,
                textSize = 18.sp,
                textWeight = FontWeight.SemiBold
            )
            WBIcon(
                modifier = Modifier.padding(5.dp),
                icon = painterResource(id = R.drawable.plus),
                iconSize = 14.dp
            )
        }

        WBInputField(
            iconSearch = painterResource(id = R.drawable.ic_glass),
            iconClear = painterResource(id = R.drawable.ic_clear),
            hint = "Search",
            text = text,
            onValueChange = { text = it }
        )

        WBTopAppBar(tabItems = listOf("All events", "Active")) { index ->
            when (index) {
                0 -> WBEventList(
                    events = allEvents,
                    onClickListener = { idx ->
                        Toast.makeText(
                            context,
                            "Event ${idx + 1} clicked",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                )

                1 -> WBEventList(
                    events = activeEvents,
                    onClickListener = { idx ->
                        Toast.makeText(
                            context,
                            "Event ${idx + 1} clicked",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                )
            }
        }
    }
}

    @Composable
    @Preview(
        showBackground = true,
        backgroundColor = 0xFFFFFFFF,
    )
    private fun EventsScreenPreview() {
        EventsScreen()
    }