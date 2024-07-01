package com.example.wbapp.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.uikit.base.common.BrandColorWhite
import com.example.uikit.base.icon.WBIcon
import com.example.uikit.base.text.WBText
import com.example.wbapp.navigation.screens.Screens
import com.example.wbapp.navigation.screens.communitiesScreens.CommunitiesScreen
import com.example.wbapp.navigation.screens.eventsScreens.EventsScreen
import com.example.wbapp.navigation.screens.otherScreens.MyEventsScreen
import com.example.wbapp.navigation.screens.otherScreens.OtherScreen
import com.example.wbapp.navigation.screens.otherScreens.PersonalScreen

@Composable
fun MyBottomAppBar(
    barHeight: Dp = 64.dp,
    innerPadding: PaddingValues = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
) {
    val navigationController = rememberNavController()
    val selected = remember {
        mutableStateOf(com.example.uikit.R.drawable.event)
    }

    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .height(barHeight),
                containerColor = BrandColorWhite
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(innerPadding),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (selected.value == com.example.uikit.R.drawable.event){
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(4.dp),
                        ) {
                            WBText(
                                text = "Events",
                                textWeight = FontWeight.SemiBold
                            )
                            WBIcon(
                                icon = painterResource(id = com.example.uikit.R.drawable.point),
                                iconSize = 4.dp
                            )
                        }

                    } else {
                        WBIcon(
                            icon = painterResource(id = com.example.uikit.R.drawable.event),
                            iconSize = 32.dp,
                            isCircle = false,
                            roundingSize = 0.dp,
                            contentScale = ContentScale.Fit,
                            borderColor = BrandColorWhite,
                            clickable = true,
                            onClickListener = {
                                selected.value = com.example.uikit.R.drawable.event
                                navigationController.navigate(Screens.Events.screen) {
                                    popUpTo(0)
                                }
                            },
                            indication = null,
                        )
                    }

                    if (selected.value == com.example.uikit.R.drawable.communities){
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(4.dp),
                        ) {
                            WBText(
                                text = "Communities",
                                textWeight = FontWeight.SemiBold
                            )
                            WBIcon(
                                icon = painterResource(id = com.example.uikit.R.drawable.point),
                                iconSize = 4.dp
                            )
                        }

                    } else {
                        WBIcon(
                            icon = painterResource(id = com.example.uikit.R.drawable.communities),
                            iconSize = 32.dp,
                            isCircle = false,
                            roundingSize = 0.dp,
                            borderColor = BrandColorWhite,
                            contentScale = ContentScale.Fit,
                            clickable = true,
                            onClickListener = {
                                selected.value = com.example.uikit.R.drawable.communities
                                navigationController.navigate(Screens.Communities.screen) {
                                    popUpTo(0)
                                }
                            },
                            indication = null,
                        )
                    }

                    if (selected.value == com.example.uikit.R.drawable.other){
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(4.dp),
                        ) {
                            WBText(
                                text = "Other",
                                textWeight = FontWeight.SemiBold
                            )
                            WBIcon(
                                icon = painterResource(id = com.example.uikit.R.drawable.point),
                                iconSize = 4.dp
                            )
                        }
                    } else {
                        WBIcon(
                            icon = painterResource(id = com.example.uikit.R.drawable.other),
                            iconSize = 32.dp,
                            isCircle = false,
                            roundingSize = 0.dp,
                            borderColor = BrandColorWhite,
                            contentScale = ContentScale.Fit,
                            clickable = true,
                            onClickListener = {
                                selected.value = com.example.uikit.R.drawable.other
                                navigationController.navigate(Screens.Other.screen) {
                                    popUpTo(0)
                                }
                            },
                            indication = null,
                        )
                    }
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navigationController,
            startDestination = Screens.Events.screen,
            modifier = Modifier
                .padding(paddingValues)
        ) {
            composable(Screens.Events.screen) { EventsScreen() }
            composable(Screens.Communities.screen) { CommunitiesScreen() }
            composable(Screens.Other.screen) { OtherScreen(navigationController = navigationController) }
            composable(Screens.Personal.screen) { PersonalScreen(navigationController = navigationController)}
            composable(Screens.MyEvents.screen) { MyEventsScreen(navigationController = navigationController) }
        }
    }
}

@Composable
@Preview
private fun MyBottomAppBarPreview() {
    MyBottomAppBar()
}