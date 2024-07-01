package com.example.uikit.base.chip

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.base.common.BrandColorBackground
import com.example.uikit.base.common.BrandColorDark
import com.example.uikit.base.text.WBText

/**
 * Компонент для отображения чипсов
 *
 */

@Composable
fun WBChip(
    modifier: Modifier = Modifier,
    backgroundColor: Color = BrandColorBackground,
    text: String = "Chip",
    textColor: Color = BrandColorDark,
    textSize: TextUnit = 10.sp,
    chipHeight: Dp = 20.dp,
    innerPadding: PaddingValues = PaddingValues(horizontal = 8.dp, vertical = 2.dp),
    onClickListener: () -> Unit = {},
    roundingSize: Dp = 40.dp,
) {
    val interactionSource = remember { MutableInteractionSource() }
    Row(
        modifier = modifier
            .background(
                backgroundColor,
                shape = RoundedCornerShape(roundingSize),
            )
            .height(chipHeight)
            .clip(RoundedCornerShape(roundingSize))
            .clickable(
                interactionSource = interactionSource,
                indication = rememberRipple(),
                onClick = onClickListener,
            )
            .padding(innerPadding),

        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,

        ) {
        WBText(

            text = text,
            textSize = textSize,
            textWeight = FontWeight.SemiBold,
            color = textColor
        )
    }


}

@Preview
@Composable
private fun WBChipPreview() {
    WBChip(text = "Python")
}