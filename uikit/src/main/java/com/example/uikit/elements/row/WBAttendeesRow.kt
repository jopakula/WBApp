package com.example.uikit.elements.row

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.base.icon.WBIcon
import com.example.uikit.base.common.BrandColorDefault
import com.example.uikit.base.common.BrandColorIconBorder
import com.example.uikit.base.row.WBOverlappingRow
import com.example.uikit.base.text.WBText

/**
 * Компонент для отображения иконок в ряд
 *
 * @param overlappingPercentage Отвечает за процент перекрытия между элементами
 * @param firstOnTop Отвечает за наложение картинок элементов (true, первый элемент будет сверху/false, первый элемент будет снизу)
 * @param showAvatarsNum Отвечает за кол-во отображаемых иконок
 */


@Composable
fun WBAttendeesRow(
    modifier: Modifier = Modifier,
    images: List<Int>? = null,
    imageSize: Dp = 50.dp,
    showAvatarsNum: Int = 5,
    firstOnTop: Boolean = true,
    isCircle: Boolean = true,
    roundingSize: Dp = 16.dp,
    borderWidth: Dp = 2.dp,
    borderColor: Color = BrandColorIconBorder,
    overlappingPercentage: Float = 0.35f,
) {
    Row(
        modifier = modifier
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (images.isNullOrEmpty()) {
            WBText(
                text = "Be the first!"
            )
        } else {
            WBOverlappingRow(
                overlappingPercentage = overlappingPercentage,
                firstOnTop = firstOnTop
            ) {
                for (i in images.take(showAvatarsNum)) {
                    WBIcon(
                        icon = painterResource(id = i),
                        iconSize = imageSize,
                        isCircle = isCircle,
                        roundingSize = roundingSize,
                        borderColor = borderColor,
                        borderWidth = borderWidth,

                        )
                }
            }
            if (images.size > showAvatarsNum) {
                Spacer(modifier = Modifier.width(10.dp))
                WBText(
                    text = "+${images.size - showAvatarsNum}"
                )
            }
        }

    }
}

@Composable
@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
private fun AttendeesRowPreview(){
    val images = List(9) { R.drawable.comunity }
    WBAttendeesRow(images = images)
}

@Composable
@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
private fun AttendeesRowPreview2(){
    val images = List(9) { R.drawable.comunity }
    WBAttendeesRow(images = images,
        firstOnTop = false,
        isCircle = false,
        borderColor = BrandColorDefault)
}
