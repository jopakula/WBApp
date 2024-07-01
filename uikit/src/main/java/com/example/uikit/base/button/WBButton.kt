package com.example.uikit.base.button

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.R
import com.example.uikit.base.common.BrandColorDark
import com.example.uikit.base.common.BrandColorDefault
import com.example.uikit.base.common.BrandColorWhite
import com.example.uikit.base.icon.WBIcon
import com.example.uikit.base.text.WBText

enum class ButtonType {
    Default,
    Outline,
    Ghost,
}

/**
 * Компонент для отображения текста
 *
 * @param innerPadding Отвечает за внутренние отступы, можно задавать как PaddingValues(horizontal: Dp = 0.dp, vertical: Dp = 0.dp)
 * @param type Отвечает за тип кнопки может быть Default, Outline, Ghost
 * @param enabled Отвечает за тип состояние кнопки (активна/неактивна)
 */

@Composable
fun WBButton(
    modifier: Modifier = Modifier,
    type: ButtonType = ButtonType.Default,
    text: String = "Button",
    textSize: TextUnit = 16.sp,
    textWeight: FontWeight = FontWeight.SemiBold,
    buttonHeight: Dp = 52.dp,
    innerPadding: PaddingValues = PaddingValues(12.dp),
    onClickListener: () -> Unit = {},
    roundingSize: Dp = 30.dp,
    borderWidth: Dp = 2.dp,
    enabled: Boolean = true,
    icon: Painter? = null,

    ) {

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed = interactionSource.collectIsPressedAsState().value

    val color = when (type) {
        ButtonType.Default -> BrandColorWhite
        ButtonType.Outline -> if (isPressed) BrandColorDark else BrandColorDefault
        ButtonType.Ghost -> if (isPressed) BrandColorDark else BrandColorDefault
    }

    val rowModifier =
        when (type) {
            ButtonType.Default ->
                modifier
                    .graphicsLayer {
                        alpha = if (enabled) 1f else 0.5f
                    }
                    .background(
                        if (isPressed) BrandColorDark else BrandColorDefault,
                        shape = RoundedCornerShape(roundingSize),
                    )
                    .height(buttonHeight)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(roundingSize))
                    .clickable(
                        interactionSource = interactionSource,
                        indication = rememberRipple(),
                        enabled = enabled,
                        onClick = onClickListener,
                    )
                    .padding(innerPadding)

            ButtonType.Outline ->
                modifier
                    .graphicsLayer {
                        alpha = if (enabled) 1f else 0.5f
                    }
                    .background(
                        Color.Transparent,
                        shape = RoundedCornerShape(roundingSize)
                    )
                    .height(buttonHeight)
                    .fillMaxWidth()
                    .border(
                        shape = RoundedCornerShape(roundingSize),
                        width = borderWidth,
                        color = color,
                    )
                    .clip(RoundedCornerShape(roundingSize))
                    .clickable(
                        interactionSource = interactionSource,
                        indication = rememberRipple(),
                        enabled = enabled,
                        onClick = onClickListener,
                    )
                    .padding(innerPadding)

            ButtonType.Ghost ->
                modifier
                    .graphicsLayer {
                        alpha = if (enabled) 1f else 0.5f
                    }
                    .background(
                        Color.Transparent,
                        shape = RoundedCornerShape(roundingSize)
                    )
                    .height(buttonHeight)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(roundingSize))
                    .clickable(
                        interactionSource = interactionSource,
                        indication = rememberRipple(),
                        enabled = enabled,
                        onClick = onClickListener,
                    )
                    .padding(innerPadding)
        }
    Row(
        modifier = rowModifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,

        ) {
        if (icon != null) {
            WBIcon(
                icon = icon,
                iconSize = 20.dp,
                roundingSize = 0.dp,
                borderColor = BrandColorWhite,
                isCircle = false,
                contentScale = ContentScale.Fit
            )
        } else {
            WBText(
                text = text,
                textSize = textSize,
                textWeight = textWeight,
                color = color
            )
        }
    }
}

@Composable
@Preview
private fun WBButtonDefaultPreview() {
    Column {
        WBButton(type = ButtonType.Default)
        Spacer(modifier = Modifier.size(4.dp))
        WBButton(
            type = ButtonType.Default,
            enabled = false,
        )
    }

}

@Composable
@Preview
private fun WBButtonOutlinePreview() {
    Column {
        WBButton(type = ButtonType.Outline)
        Spacer(modifier = Modifier.size(4.dp))
        WBButton(
            type = ButtonType.Outline,
            enabled = false,
        )
    }
}

@Composable
@Preview
private fun WBButtonGhostPreview() {
    Column {
        WBButton(type = ButtonType.Ghost)
        Spacer(modifier = Modifier.size(4.dp))
        WBButton(
            type = ButtonType.Ghost,
            enabled = false,
        )
    }
}

@Composable
@Preview
private fun WBButtonIconPreview() {
    Column {
        WBButton(
            type = ButtonType.Outline,
            icon = painterResource(id = R.drawable.avatar)
        )
    }
}

