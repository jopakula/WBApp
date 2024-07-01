package com.example.wbapp.navigation.screens.otherScreens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.uikit.R
import com.example.uikit.base.chip.WBChip
import com.example.uikit.base.common.BrandColorWhite
import com.example.uikit.base.icon.WBIcon
import com.example.uikit.base.inputField.WBInputField
import com.example.uikit.base.text.WBText
import com.example.uikit.data.Event
import com.example.uikit.elements.event.WBEventList
import com.example.wbapp.navigation.WBTopAppBar
import com.example.wbapp.navigation.screens.Screens

@Composable
fun MyEventsScreen(
    navigationController: NavController,
    label: String = "My events",
    backgroundColor: Color = BrandColorWhite,
) {
    val context = LocalContext.current
    val allEvents = List(10) {
        Event(
            R.drawable.frame,
            cardText = "Developer meeting",
            meetingStateText = "Event has been planned",
            cardHint = "13.09.2024 — Москва",
            chips = listOf(
                { modifier -> WBChip(modifier = modifier, text = "Python") },
                { modifier -> WBChip(modifier = modifier, text = "Junior") },
                { modifier -> WBChip(modifier = modifier, text = "Moscow") }
            )
        )
    }

    val finishedEvents = List(5) {
        Event(
            R.drawable.frame,
            cardText = "Active meeting",
            meetingStateText = "Finished",
            cardHint = "14.09.2024 — Санкт-Петербург",
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
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(
                modifier = Modifier
                    .clickable(
                        onClick = { navigationController.navigate(Screens.Other.screen) }
                    ),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                WBIcon(
                    icon = painterResource(id = R.drawable.arrowback),
                    iconSize = 12.dp,
                    contentScale = ContentScale.Fit,
                )
                Spacer(modifier = Modifier.width(10.dp))
                WBText(
                    text = label,
                    textSize = 18.sp,
                    textWeight = FontWeight.SemiBold,
                )
            }
        }

        WBTopAppBar(tabItems = listOf("Planned", "Finished")) { index ->
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
                    events = finishedEvents,
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
private fun MyEventsScreenPreview() {
    MyEventsScreen(navigationController = rememberNavController())
}