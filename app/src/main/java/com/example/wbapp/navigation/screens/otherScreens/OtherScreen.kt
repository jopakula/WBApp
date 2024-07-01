package com.example.wbapp.navigation.screens.otherScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.uikit.R
import com.example.uikit.base.common.BrandColorBlack
import com.example.uikit.base.common.BrandColorGray
import com.example.uikit.base.common.BrandColorWhite
import com.example.uikit.base.common.NeutralLine
import com.example.uikit.base.icon.WBIcon
import com.example.uikit.base.text.WBText
import com.example.wbapp.navigation.screens.Screens

@Composable
fun OtherScreen(
    label: String = "Other",
    backgroundColor: Color = BrandColorWhite,
    navigationController: NavController,
    lineColor: Color = NeutralLine,
    lineWeight: Dp = 1.dp,

) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 14.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            WBText(
                text = label,
                textSize = 18.sp,
                textWeight = FontWeight.SemiBold
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = { navigationController.navigate(Screens.Personal.screen) })
                .padding(PaddingValues(vertical = 8.dp)),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            WBIcon(
                icon = painterResource(id = R.drawable.avatar),
                iconSize = 50.dp
            )
            Spacer(modifier = Modifier.width(20.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier

                        .padding(2.dp)
                ) {
                    WBText(
                        modifier = Modifier
                            .height(24.dp),
                        textWeight = FontWeight.SemiBold,
                        text = "Иван Иванов",
                    )
                    WBText(
                        modifier = Modifier
                            .height(20.dp),
                        text = "+7 999 999-99-99",
                        color = BrandColorGray,
                    )

                }
                WBIcon(
                    icon = painterResource(id = R.drawable.arrow),
                    iconSize = 12.dp,
                    contentScale = ContentScale.Fit
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(PaddingValues(vertical = 8.dp))
                .clickable(onClick = { navigationController.navigate(Screens.MyEvents.screen) }),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            WBIcon(
                icon = painterResource(id = R.drawable.event),
                iconSize = 24.dp,
                iconColor = BrandColorBlack,
                isCircle = false,
                roundingSize = 0.dp,
                borderColor = BrandColorWhite,
                contentScale = ContentScale.Fit,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier

                        .padding(2.dp)
                ) {
                    WBText(
                        modifier = Modifier,
                        textWeight = FontWeight.SemiBold,
                        text = "Мои встречи",
                    )
                }
                WBIcon(
                    icon = painterResource(id = R.drawable.arrow),
                    iconSize = 12.dp,
                    contentScale = ContentScale.Fit
                )
            }
        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(PaddingValues(vertical = 8.dp)),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            WBIcon(
                icon = painterResource(id = R.drawable.sun),
                iconSize = 24.dp,
                iconColor = BrandColorBlack,
                isCircle = false,
                roundingSize = 0.dp,
                borderColor = BrandColorWhite,
                contentScale = ContentScale.Fit,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier

                        .padding(2.dp)
                ) {
                    WBText(
                        modifier = Modifier,
                        textWeight = FontWeight.SemiBold,
                        text = "Тема",
                    )
                }
                WBIcon(
                    icon = painterResource(id = R.drawable.arrow),
                    iconSize = 12.dp,
                    contentScale = ContentScale.Fit
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(PaddingValues(vertical = 8.dp)),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            WBIcon(
                icon = painterResource(id = R.drawable.bell),
                iconSize = 24.dp,
                iconColor = BrandColorBlack,
                isCircle = false,
                roundingSize = 0.dp,
                borderColor = BrandColorWhite,
                contentScale = ContentScale.Fit,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier

                        .padding(2.dp)
                ) {
                    WBText(
                        modifier = Modifier,
                        textWeight = FontWeight.SemiBold,
                        text = "Уведомления",
                    )
                }
                WBIcon(
                    icon = painterResource(id = R.drawable.arrow),
                    iconSize = 12.dp,
                    contentScale = ContentScale.Fit
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(PaddingValues(vertical = 8.dp)),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            WBIcon(
                icon = painterResource(id = R.drawable.shield),
                iconSize = 24.dp,
                iconColor = BrandColorBlack,
                isCircle = false,
                roundingSize = 0.dp,
                borderColor = BrandColorWhite,
                contentScale = ContentScale.Fit,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier

                        .padding(2.dp)
                ) {
                    WBText(
                        modifier = Modifier,
                        textWeight = FontWeight.SemiBold,
                        text = "Безопасность",
                    )
                }
                WBIcon(
                    icon = painterResource(id = R.drawable.arrow),
                    iconSize = 12.dp,
                    contentScale = ContentScale.Fit
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(PaddingValues(vertical = 8.dp)),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            WBIcon(
                icon = painterResource(id = R.drawable.folder),
                iconSize = 24.dp,
                iconColor = BrandColorBlack,
                isCircle = false,
                roundingSize = 0.dp,
                borderColor = BrandColorWhite,
                contentScale = ContentScale.Fit,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier

                        .padding(2.dp)
                ) {
                    WBText(
                        modifier = Modifier,
                        textWeight = FontWeight.SemiBold,
                        text = "Память и ресурсы",
                    )
                }
                WBIcon(
                    icon = painterResource(id = R.drawable.arrow),
                    iconSize = 12.dp,
                    contentScale = ContentScale.Fit
                )
            }
        }
        Divider(
            color = lineColor,
            thickness = lineWeight,
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(PaddingValues(vertical = 8.dp)),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            WBIcon(
                icon = painterResource(id = R.drawable.question),
                iconSize = 24.dp,
                iconColor = BrandColorBlack,
                isCircle = false,
                roundingSize = 0.dp,
                borderColor = BrandColorWhite,
                contentScale = ContentScale.Fit,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier

                        .padding(2.dp)
                ) {
                    WBText(
                        modifier = Modifier,
                        textWeight = FontWeight.SemiBold,
                        text = "Помощь",
                    )
                }
                WBIcon(
                    icon = painterResource(id = R.drawable.arrow),
                    iconSize = 12.dp,
                    contentScale = ContentScale.Fit
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(PaddingValues(vertical = 8.dp)),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            WBIcon(
                icon = painterResource(id = R.drawable.message),
                iconSize = 24.dp,
                iconColor = BrandColorBlack,
                isCircle = false,
                roundingSize = 0.dp,
                borderColor = BrandColorWhite,
                contentScale = ContentScale.Fit,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier

                        .padding(2.dp)
                ) {
                    WBText(
                        modifier = Modifier,
                        textWeight = FontWeight.SemiBold,
                        text = "Пригласи друга",
                    )
                }
                WBIcon(
                    icon = painterResource(id = R.drawable.arrow),
                    iconSize = 12.dp,
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}

@Composable
@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
)
private fun OtherScreenPreview() {
    OtherScreen(navigationController = rememberNavController())
}