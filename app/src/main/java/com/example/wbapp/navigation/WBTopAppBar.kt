package com.example.wbapp.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.base.common.BrandColorDarkGray
import com.example.uikit.base.common.BrandColorDefault
import com.example.uikit.base.common.BrandColorGray
import com.example.uikit.base.common.BrandColorWhite
import com.example.uikit.base.text.WBText

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WBTopAppBar(
    backgroundColor: Color = BrandColorWhite,
    tabItems: List<String>,
    content: @Composable (Int) -> Unit
) {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val pagerState = rememberPagerState {
        tabItems.size
    }
    LaunchedEffect(selectedTabIndex) {
        pagerState.animateScrollToPage(selectedTabIndex)
    }
    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if (!pagerState.isScrollInProgress) {
            selectedTabIndex = pagerState.currentPage
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        TabRow(

            selectedTabIndex = selectedTabIndex,
            divider = {},
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[selectedTabIndex])
                        .height(2.dp),
                    color = BrandColorDefault,
                )
            },
        ) {
            tabItems.forEachIndexed { index, item ->
                Tab(
                    modifier = Modifier
                        .background(backgroundColor),
                    selected = index == selectedTabIndex,
                    onClick = {
                        selectedTabIndex = index
                    },
                    text = {
                        WBText(
                            text = item,
                            textWeight = FontWeight.Medium,
                            color = if (index == selectedTabIndex) BrandColorDefault else BrandColorDarkGray
                        )
                    },
                )
            }
        }
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1F)
        ) { index ->
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                content(index)
            }
        }
    }
}

@Composable
@Preview
private fun WBTopAppBarPreview() {
    WBTopAppBar(
        tabItems = listOf("Tab 1", "Tab 2", "Tab 3")
    )
    { index ->
        Text(text = "Content for Tab ${index + 1}")
    }
}