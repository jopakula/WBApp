package com.example.uikit.elements.avatar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.base.common.BrandColorIconBorder
import com.example.uikit.base.icon.WBIcon

enum class AvatarState {
    View,
    Edit,
}

/**
 * Компонент для отображения (крутой) аватарки
 *
 * @param clickable Отвечает за тип состояние иконки (Clickable/NonClickable)
 * @param isCircle Отвечает за тип вид иконки (круглая/квадратная)
 * @param contentScale Отвечает за как изображение масштабируется и позиционируется в пределах границ своего контейнера
 * @param state Отвечает за вид иконки (View/Edit)
 */

@Composable
fun WBAvatar(
    modifier: Modifier = Modifier,
    icon: Painter = painterResource(id = R.drawable.avatar),
    iconSize: Dp = 100.dp,
    iconSmall: Painter = painterResource(id = R.drawable.plus_sircle),
    iconSmallSize: Dp = 20.dp,
    isCircle: Boolean = true,
    roundingSize: Dp = 16.dp,
    borderWidth: Dp = 2.dp,
    borderColor: Color = BrandColorIconBorder,
    state: AvatarState = AvatarState.View,
    contentScale: ContentScale = ContentScale.Crop,
    clickable: Boolean = false,
    onClickListener: () -> Unit = {},
    clickableIconSmall: Boolean = true,
    onClickListenerIconSmall: () -> Unit = {},
){

    Box(modifier = modifier
        .background(Color.Transparent),
        contentAlignment = Alignment.BottomEnd){
            WBIcon(
                modifier = modifier,
                icon = icon,
                iconSize = iconSize,
                isCircle = isCircle,
                roundingSize = roundingSize,
                borderWidth = borderWidth,
                borderColor = borderColor,
                contentScale = contentScale,
                clickable = clickable,
                onClickListener = onClickListener
            )
        if (state == AvatarState.Edit && isCircle) {
            WBIcon(
                icon = iconSmall,
                iconSize = iconSmallSize,
                clickable = clickableIconSmall,
                onClickListener = onClickListenerIconSmall,
            )
        }
    }
}

@Composable
@Preview
private fun WbAvatarViewPreview(){
    WBAvatar(
        isCircle = false,
        icon = painterResource(id = R.drawable.comunity)
    )
}

@Composable
@Preview(
    showBackground = true,
    backgroundColor = 0xFFD0BCFF
)
private fun WbAvatarEditPreview(){
    WBAvatar(state = AvatarState.Edit,)
}
