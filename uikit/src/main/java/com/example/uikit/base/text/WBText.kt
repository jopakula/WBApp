package com.example.uikit.base.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.uikit.base.common.BrandColorBlack
import com.example.uikit.base.common.MyFonts

/**
 * Компонент для отображения текста
 *
 * @param overflow Отвечает за то, что делать если текст не помещается в контент(TextOverflow.Clip - обрезан, TextOverflow.Ellipsis - многоточие)
 * @param textDecoration Отвечает за декорации которые будут рисоваться на тексте(подчеркивание или перечеркивание)
 */

@Composable
fun WBText(
    modifier: Modifier = Modifier,
    text: String = "Text",
    color: Color = BrandColorBlack,
    textSize: TextUnit = 14.sp,
    textFamily: MyFonts = MyFonts.SFProDisplay,
    textWeight: FontWeight = FontWeight.Normal,
    textAlign: TextAlign = TextAlign.Start,
    textStyle: FontStyle = FontStyle.Normal,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    textDecoration: TextDecoration? = null,
) {
    Text(
        modifier = modifier,
        fontFamily = textFamily.fontFamily,
        text = text,
        fontWeight = textWeight,
        color = color,
        fontSize = textSize,
        textAlign = textAlign,
        fontStyle = textStyle,
        letterSpacing = letterSpacing,
        overflow = overflow,
        textDecoration = textDecoration,
    )
}

@Composable
@Preview
private fun WBTextPreview(){
    WBText()
}
