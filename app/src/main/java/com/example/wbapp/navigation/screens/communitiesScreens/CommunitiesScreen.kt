package com.example.wbapp.navigation.screens.communitiesScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.base.common.BrandColorWhite
import com.example.uikit.base.text.WBText

@Composable
fun CommunitiesScreen(
    label: String = "Communities",
    backgroundColor: Color = BrandColorWhite,
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()) {

            WBText(text = label)
        }

    }

}

@Composable
@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
)
private fun CommunitiesScreenPreview(){
    CommunitiesScreen()
}