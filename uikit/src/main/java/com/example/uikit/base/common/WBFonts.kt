package com.example.uikit.base.common

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.uikit.R

/**
 * Шрифты которые можно использовать в проекте
 */
enum class MyFonts(val fontFamily: FontFamily) {
    SFProDisplay(SFProDisplayFamily),
}

private val SFProDisplayFamily = FontFamily(
    Font(R.font.sf100, FontWeight.Thin),
    Font(R.font.sf100i, FontWeight.Thin, FontStyle.Italic),
    Font(R.font.sf200, FontWeight.ExtraLight),
    Font(R.font.sf200i, FontWeight.ExtraLight, FontStyle.Italic),
    Font(R.font.sf300, FontWeight.Light),
    Font(R.font.sf300i, FontWeight.Light, FontStyle.Italic),
    Font(R.font.sf400, FontWeight.Normal),
    Font(R.font.sf400i, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.sf500, FontWeight.Medium),
    Font(R.font.sf500i, FontWeight.Medium, FontStyle.Italic),
    Font(R.font.sf600, FontWeight.SemiBold),
    Font(R.font.sf600i, FontWeight.SemiBold, FontStyle.Italic),
    Font(R.font.sf700, FontWeight.Bold),
    Font(R.font.sf700i, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.sf800, FontWeight.ExtraBold),
    Font(R.font.sf800i, FontWeight.ExtraBold, FontStyle.Italic),
    Font(R.font.sf900, FontWeight.Black),
    Font(R.font.sf900i, FontWeight.Black, FontStyle.Italic),
)
