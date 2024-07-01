package com.example.uikit.base.inputField

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.R
import com.example.uikit.base.common.BrandColorBlack
import com.example.uikit.base.common.BrandColorGray
import com.example.uikit.base.common.BrandColorGrayBackground
import com.example.uikit.base.common.MyFonts
import com.example.uikit.base.text.WBText

/**
 * Компонент для отображения текстового поля
 *
 * @param isSingleLine Отвечает за перенос текста
 * @param maxLines Отвечает за максимальное количество отображаемых строк
 */

@Composable
fun WBInputField(
    modifier: Modifier = Modifier,
    buttonHeight: Dp = 36.dp,
    backgroundColor: Color = BrandColorGrayBackground,
    iconSearch: Painter? = null,
    iconClear: Painter? = null,
    iconSize: Dp = 16.61.dp,
    iconColor: Color = BrandColorBlack,
    innerPadding: PaddingValues = PaddingValues(vertical = 6.dp, horizontal = 8.dp),
    roundingSize: Dp = 4.dp,
    text: String? = null,
    textSize: TextUnit = 14.sp,
    textColor: Color = BrandColorBlack,
    fontFamily: MyFonts = MyFonts.SFProDisplay,
    fontWeight: FontWeight = FontWeight.SemiBold,
    fontStyle: FontStyle = FontStyle.Normal,
    onValueChange: (String) -> Unit = {},
    maxLines: Int = 1,
    isSingleLine: Boolean = true,
    hint: String? = null,
    textPadding: PaddingValues = PaddingValues(start = 8.dp, end = 8.dp),
    hintColor: Color = BrandColorGray
) {
    val focusRequester = remember { FocusRequester() }
    val interactionSource = remember { MutableInteractionSource() }

    Row(
        modifier = modifier
            .height(buttonHeight)
            .fillMaxWidth()
            .clickable(
                interactionSource = interactionSource,
                indication = null,
            ) { focusRequester.requestFocus() }
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(roundingSize)
            )
            .padding(innerPadding),
        verticalAlignment = Alignment.CenterVertically
    ) {
        iconSearch?.let { paint ->
            Icon(
                modifier = Modifier
                    .size(iconSize),
                painter = paint,
                tint = iconColor,
                contentDescription = null,
            )
        }
        Box(
            modifier = Modifier.weight(1F),
        ) {
            if (text.isNullOrEmpty() && !hint.isNullOrEmpty()) {
                WBText(
                    modifier = Modifier
                        .padding(textPadding),
                    textSize = textSize,
                    textStyle = fontStyle,
                    textWeight = fontWeight,
                    textFamily = fontFamily,
                    text = hint,
                    color = hintColor
                )
            }
            BasicTextField(
                modifier = Modifier
                    .padding(textPadding)
                    .focusRequester(focusRequester),
                value = text ?: "",
                onValueChange = onValueChange,
                maxLines = maxLines,
                singleLine = isSingleLine,
                textStyle = TextStyle(
                    color = textColor,
                    fontStyle = fontStyle,
                    fontWeight = fontWeight,
                    fontFamily = fontFamily.fontFamily,
                )
            )
        }
        iconClear?.let { paint ->
            if (!text.isNullOrEmpty() )
            Icon(
                modifier = Modifier
                    .size(iconSize)
                    .clickable { onValueChange("") },
                painter = paint,
                tint = iconColor,
                contentDescription = null,
            )
        }
    }
}

@Composable
@Preview
private fun WBInputFieldPreview() {
    WBInputField(
        iconSearch = painterResource(id = R.drawable.ic_glass),
        hint = "Hint"
    )
}

@Composable
@Preview
private fun WBInputFieldPreview2() {
    WBInputField(
        text = "Text",
        iconClear = painterResource(id = R.drawable.ic_clear)
    )
}