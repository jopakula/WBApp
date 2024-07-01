package com.example.uikit.elements.community

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
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
import com.example.uikit.base.common.BrandColorBlack
import com.example.uikit.base.common.BrandColorGray
import com.example.uikit.base.common.BrandColorIconBorder
import com.example.uikit.base.text.WBText

/**
 * Компонент для отображения карточки сообщества
 *
 */

@Composable
fun WBCommunityCard(
    modifier: Modifier = Modifier,
    image: Painter = painterResource(id = R.drawable.comunity),
    innerPadding: PaddingValues = PaddingValues(4.dp),
    spacerPadding: Dp = 12.dp,
    cardHeight: Dp = 68.dp,
    cardText: String = "Text",
    cardTextColor: Color = BrandColorBlack,
    cardTextWeight: FontWeight = FontWeight.SemiBold,
    cardHint: String = "Hint",
    cardHintColor: Color = BrandColorGray,
    cardHintWeight: FontWeight = FontWeight.Normal,
    borderWidth: Dp = 0.dp,
    borderColor: Color = BrandColorIconBorder,
    onClickListener: () -> Unit = {},
) {
    Column(
        modifier = Modifier
            .background(Color.Transparent)
            .height(cardHeight)
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
                borderWidth = borderWidth,
                borderColor = borderColor,
                iconSize = 56.dp
            )
            Spacer(modifier = Modifier.width(spacerPadding))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(2.dp)
            ) {
                WBText(
                    modifier = Modifier
                        .height(24.dp),
                    text = cardText,
                    color = cardTextColor,
                    textWeight = cardTextWeight,
                )
                WBText(
                    modifier = Modifier
                        .height(20.dp),
                    text = cardHint,
                    color = cardHintColor,
                    textWeight = cardHintWeight
                )
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
private fun CommunityCardPreview() {
    WBCommunityCard()
}