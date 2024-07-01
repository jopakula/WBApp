package com.example.uikit.base.icon

import androidx.compose.foundation.Image
import androidx.compose.foundation.Indication
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.base.common.BrandColorBlack
import com.example.uikit.base.common.BrandColorIconBorder

/**
 * Компонент для отображения аватарки
 *
 * @param clickable Отвечает за тип состояние иконки (Clickable/NonClickable)
 * @param isCircle Отвечает за тип вид иконки (круглая/квадратная)
 * @param contentScale Отвечает за как изображение масштабируется и позиционируется в пределах границ своего контейнера
 */


@Composable
fun WBIcon(
    modifier: Modifier = Modifier,
    icon: Painter = painterResource(id = R.drawable.avatar),
    iconSize: Dp = 50.dp,
    iconColor: Color? = null,
    isCircle: Boolean = true,
    roundingSize: Dp = 16.dp,
    borderWidth: Dp = 0.dp,
    borderColor: Color = BrandColorIconBorder,
    clickable: Boolean = false,
    contentScale: ContentScale = ContentScale.Crop,
    onClickListener: () -> Unit = {},
    indication: Indication? = LocalIndication.current,
) {

    val interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
    val clickModifier = if (clickable) {
        Modifier.clickable(
            interactionSource = interactionSource,
            indication = indication,
            onClick = onClickListener
        )
    } else {
        Modifier
    }

    Column {
        Box(
            modifier = modifier
                .size(iconSize)
                .clip(RoundedCornerShape(if (isCircle) iconSize else roundingSize))
                .background(color = Color.Transparent)
                .then(
                    if (!isCircle) Modifier.border(
                        shape = RoundedCornerShape(roundingSize),
                        width = borderWidth,
                        color = borderColor
                    ) else Modifier
                )
                .then(clickModifier)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize(),
                painter = icon,
                contentScale = contentScale,
                contentDescription = null,
                colorFilter = iconColor?.let { ColorFilter.tint(it) }
            )
        }
    }
}

@Composable
@Preview
private fun WBIconPreview() {
    WBIcon()
}

@Composable
@Preview
private fun WBAIconPreview2() {
    WBIcon(
        iconSize = 50.dp,
        icon = painterResource(id = R.drawable.frame),
        isCircle = false,
        borderWidth = 2.dp
    )
}

@Composable
@Preview
private fun WBAIconPreview3() {
    WBIcon(
        icon = painterResource(id = R.drawable.event),
        iconSize = 100.dp,
        isCircle =false ,
        roundingSize = 0.dp,
        contentScale = ContentScale.Fit,
        iconColor = BrandColorBlack
    )
}
