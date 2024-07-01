package com.example.uikit.elements.event

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.base.icon.WBIcon
import com.example.uikit.base.chip.WBChip
import com.example.uikit.base.common.BrandColorBlack
import com.example.uikit.base.common.BrandColorGray
import com.example.uikit.base.text.WBText

/**
 * Компонент для отображения карточки встречи
 *
 * @param meetingStateText Отвечает за статус встречи
 */

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun WBEventCard(
    modifier: Modifier = Modifier,
    image: Painter = painterResource(id = R.drawable.frame),
    innerPadding: PaddingValues = PaddingValues(4.dp),
    spacerPadding: Dp = 12.dp,
    cardText: String = "Text",
    cardTextColor: Color = BrandColorBlack,
    cardTextWeight: FontWeight = FontWeight.SemiBold,
    meetingStateText: String? = null,
    cardHint: String = "Hint",
    cardHintColor: Color = BrandColorGray,
    cardHintWeight: FontWeight = FontWeight.Normal,
    onClickListener: () -> Unit = {},
    chips: List<@Composable (Modifier) -> Unit> = emptyList(),
) {
    Column(
        modifier = Modifier
            .background(Color.Transparent)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .clickable(onClick = onClickListener)
                .padding(innerPadding)
        ) {
            WBIcon(
                isCircle = false,
                icon = image,
                borderWidth = 0.dp,
                iconSize = 56.dp,
            )
            Spacer(modifier = Modifier.width(spacerPadding))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(2.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    WBText(
                        modifier = Modifier
                            .height(24.dp),
                        text = cardText,
                        color = cardTextColor,
                        textWeight = cardTextWeight,
                    )
                    if (meetingStateText != null) {
                        WBText(
                            modifier = Modifier
                                .height(24.dp),
                            text = meetingStateText,
                            color = BrandColorGray,
                        )
                    }
                }

                WBText(
                    modifier = Modifier
                        .height(20.dp),
                    text = cardHint,
                    color = cardHintColor,
                    textWeight = cardHintWeight
                )
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    chips.forEach { chip ->
                        chip(Modifier.padding(vertical = 4.dp))
                    }
                }

            }
        }
        Spacer(modifier = Modifier.height(spacerPadding))
    }
}

@Composable
@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
private fun EventyCardPreview() {

    val chips = listOf<(@Composable (Modifier) -> Unit)>(
        { modifier -> WBChip(modifier = modifier, text = "Chip 1") },
        { modifier -> WBChip(modifier = modifier, text = "Chip 2") },
        { modifier -> WBChip(modifier = modifier, text = "Chip 3") },
        { modifier -> WBChip(modifier = modifier, text = "Chip 4") },
    )

    WBEventCard(
        meetingStateText = "Finished",
        chips = chips
    )
}