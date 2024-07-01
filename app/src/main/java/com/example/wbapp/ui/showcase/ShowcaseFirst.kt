package com.example.wbapp.ui.showcase

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.R
import com.example.uikit.base.icon.WBIcon
import com.example.uikit.base.button.ButtonType
import com.example.uikit.base.button.WBButton
import com.example.uikit.base.chip.WBChip
import com.example.uikit.base.inputField.WBInputField
import com.example.uikit.base.text.WBText

@Composable
fun ShowcaseFirst(
    context: Context,
    text: String = "",
) {
    var text by remember { mutableStateOf(text) }


    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        WBText(
            text = "Кнопки в разных статусах",
            textSize = 20.sp,
            textWeight = FontWeight.Bold,
            textStyle = FontStyle.Italic,
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {

            Column(
                modifier = Modifier
                    .weight(1F)
            ) {
                WBButton(
                    onClickListener = {
                        Toast.makeText(
                            context,
                            "Default button pressed",
                            Toast.LENGTH_SHORT
                        ).show()
                    },
                )
                WBButton(enabled = false)
            }
            Column(
                modifier = Modifier
                    .weight(1F)
            ) {
                WBButton(type = ButtonType.Outline)
                WBButton(
                    type = ButtonType.Outline,
                    enabled = false,
                )
            }
            Column(
                modifier = Modifier
                    .weight(1F)
            ) {
                WBButton(type = ButtonType.Ghost)
                WBButton(
                    type = ButtonType.Ghost,
                    enabled = false,
                )
            }
        }

        WBText(
            text = "Текстовые поля",
            textSize = 20.sp,
            textWeight = FontWeight.Bold,
            textStyle = FontStyle.Italic,
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            WBText(
                text = "The quick brown fox jumps over the lazy dog",
                textWeight = FontWeight.Bold,
                textSize = 32.sp
            )
            Spacer(modifier = Modifier.size(10.dp))
            WBText(
                text = "The quick brown fox jumps over the lazy dog",
                textWeight = FontWeight.Bold,
                textSize = 24.sp
            )
            Spacer(modifier = Modifier.size(10.dp))
            WBText(
                text = "The quick brown fox jumps over the lazy dog",
                textWeight = FontWeight.SemiBold,
                textSize = 18.sp
            )
            Spacer(modifier = Modifier.size(10.dp))
            WBText(
                text = "The quick brown fox jumps over the lazy dog",
                textWeight = FontWeight.SemiBold,
                textSize = 16.sp
            )
            Spacer(modifier = Modifier.size(10.dp))
            WBText(
                text = "The quick brown fox jumps over the lazy dog",
                textWeight = FontWeight.SemiBold,
                textSize = 14.sp
            )
            Spacer(modifier = Modifier.size(10.dp))
            WBText(
                text = "The quick brown fox jumps over the lazy dog",
                textWeight = FontWeight.Normal,
                textSize = 14.sp
            )
            Spacer(modifier = Modifier.size(10.dp))
            WBText(
                text = "The quick brown fox jumps over the lazy dog",
                textWeight = FontWeight.Normal,
                textSize = 12.sp
            )
            Spacer(modifier = Modifier.size(10.dp))
            WBText(
                text = "The quick brown fox jumps over the lazy dog",
                textWeight = FontWeight.Normal,
                textSize = 10.sp
            )
            Spacer(modifier = Modifier.size(10.dp))
            WBText(
                text = "The quick brown fox jumps over the lazy dog",
                textWeight = FontWeight.SemiBold,
                textSize = 10.sp
            )
        }

        WBText(
            text = "Аватар (обычный, встречи)",
            textSize = 20.sp,
            textWeight = FontWeight.Bold,
            textStyle = FontStyle.Italic,
        )
        Row {
            WBIcon()
            WBIcon(icon = painterResource(id = R.drawable.frame), isCircle = false)
        }

        WBText(
            text = "Строка поиска",
            textSize = 20.sp,
            textWeight = FontWeight.Bold,
            textStyle = FontStyle.Italic,
        )

        WBInputField(
            iconSearch = painterResource(id = R.drawable.ic_glass),
            hint = "Hint",
            text = text,
            onValueChange = { text = it },
            iconClear = painterResource(id = R.drawable.ic_clear)
        )
        WBText(text = text)


        WBText(
            text = "Чипсы",
            textSize = 20.sp,
            textWeight = FontWeight.Bold,
            textStyle = FontStyle.Italic,
        )
        Row(
            modifier = Modifier
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            WBChip(
                text = "Python"
            )
            WBChip(
                text = "Junior"
            )
            WBChip(
                text = "Moscow"
            )
        }
Spacer(modifier = Modifier.size(10.dp))
    }
}

@Composable
@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
private fun ShowcaseFirstPreview(){
    ShowcaseSecond(context = LocalContext.current)
}