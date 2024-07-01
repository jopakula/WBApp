package com.example.wbapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.wbapp.navigation.MyBottomAppBar
import com.example.wbapp.ui.showcase.ShowcaseFirst
import com.example.wbapp.ui.showcase.ShowcaseSecond

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface {
                MyBottomAppBar()
//                LazyColumn(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(Color.White)
//                    .padding(10.dp)
//
//            ) {
//                item {
//                    ShowcaseFirst(context = this@MainActivity)
//                }
//                item {
//                    ShowcaseSecond(context = this@MainActivity)
//                }
//
//            }
            }
        }
    }
}

