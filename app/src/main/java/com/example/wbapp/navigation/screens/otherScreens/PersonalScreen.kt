package com.example.wbapp.navigation.screens.otherScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.uikit.R
import com.example.uikit.base.button.ButtonType
import com.example.uikit.base.button.WBButton
import com.example.uikit.base.common.BrandColorGray
import com.example.uikit.base.common.BrandColorWhite
import com.example.uikit.base.icon.WBIcon
import com.example.uikit.base.text.WBText
import com.example.uikit.elements.avatar.WBAvatar
import com.example.wbapp.navigation.screens.Screens

@Composable
fun PersonalScreen(
    navigationController: NavController,
    label: String = "Personal",
    backgroundColor: Color = BrandColorWhite,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 14.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(
                modifier = Modifier
                    .clickable(
                        onClick = { navigationController.navigate(Screens.Other.screen) }
                    ),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                WBIcon(
                    icon = painterResource(id = R.drawable.arrowback),
                    iconSize = 12.dp,
                    contentScale = ContentScale.Fit,
                )
                Spacer(modifier = Modifier.width(10.dp))
                WBText(
                    text = label,
                    textSize = 18.sp,
                    textWeight = FontWeight.SemiBold,
                )
            }
            WBIcon(
                icon = painterResource(id = R.drawable.pen),
                iconSize = 24.dp,
                clickable = true,
            )
        }

        WBAvatar(
            iconSize = 200.dp,
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            WBText(
                text = "Иван Иванов",
                textSize = 24.sp,
                textWeight = FontWeight.SemiBold,
            )
            WBText(
                text = "+7 999 999-99-99",
                textSize = 16.sp,
                color = BrandColorGray,
            )
        }

        Row{
            WBButton(
                modifier = Modifier
                    .weight(1F),
                type = ButtonType.Outline,
                icon = painterResource(id = R.drawable.twitter),
            )
            WBButton(
                modifier = Modifier
                    .weight(1F),
                type = ButtonType.Outline,
                icon = painterResource(id = R.drawable.instagram),
            )
            WBButton(
                modifier = Modifier
                    .weight(1F),
                type = ButtonType.Outline,
                icon = painterResource(id = R.drawable.linkedin),
            )
            WBButton(
                modifier = Modifier
                    .weight(1F),
                type = ButtonType.Outline,
                icon = painterResource(id = R.drawable.facebook),
            )
        }

    }

}


@Composable
@Preview(showBackground = true)
private fun PersonalScreenPreview() {
    PersonalScreen(navigationController = rememberNavController())
}