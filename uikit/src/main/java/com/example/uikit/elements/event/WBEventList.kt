package com.example.uikit.elements.event

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.base.chip.WBChip
import com.example.uikit.base.common.NeutralLine
import com.example.uikit.base.text.WBText
import com.example.uikit.data.Event

/**
 * Компонент для отображения карточек со встречами
 *
 * @param lineHeight Отвечает за высоту подчеркивания
 * @param lineWeight Отвечает за толщину подчеркивания
 * @param noEventText Отвечает за отображаемый текст при отсутствии карточек
 */

@Composable
fun WBEventList(
    events: List<Event>? = emptyList(),
    onClickListener: (Int) -> Unit = {},
    lineHeight: Dp = 8.dp,
    lineColor: Color = NeutralLine,
    lineWeight: Dp = 1.dp,
    noEventText: String = "No events available",
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        if (events.isNullOrEmpty()) {
            item {
                WBText(text = noEventText)
            }
        } else {
            itemsIndexed(events) { index, event ->
                WBEventCard(
                    image = painterResource(id = event.image),
                    cardText = event.cardText,
                    cardHint = event.cardHint,
                    meetingStateText = event.meetingStateText,
                    chips = event.chips,
                    onClickListener = { onClickListener(index) },

                    )
                if (index < events.size - 1) {
                    Divider(
                        color = lineColor,
                        thickness = lineWeight,
                        modifier = Modifier.padding(vertical = lineHeight)
                    )
                }
            }
        }

    }
}

@Composable
@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
private fun EventListPreview() {

    val events = List(6) {
        Event(
            R.drawable.frame,
            "Developer meeting",
            "Finished",
            "13.09.2024 — Москва",
            chips = listOf(
                { modifier -> WBChip(modifier = modifier, text = "Python") },
                { modifier -> WBChip(modifier = modifier, text = "Junior") },
                { modifier -> WBChip(modifier = modifier, text = "Moscow") }
            )
        )
    }



    WBEventList(
        events = events
    )
}