package com.example.wbapp.ui.showcase

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.R
import com.example.uikit.base.chip.WBChip
import com.example.uikit.base.text.WBText
import com.example.uikit.data.Community
import com.example.uikit.data.Event
import com.example.uikit.elements.avatar.AvatarState
import com.example.uikit.elements.avatar.WBAvatar
import com.example.uikit.elements.community.WBCommunityCard
import com.example.uikit.elements.community.WBCommunityList
import com.example.uikit.elements.event.WBEventCard
import com.example.uikit.elements.event.WBEventList
import com.example.uikit.elements.row.WBAttendeesRow

@Composable
fun ShowcaseSecond(
    context: Context,
) {
    val images = List(1) { R.drawable.frame }
    val images2 = List(3) { R.drawable.comunity }
    val images3 = List(4) { R.drawable.frame }
    val images4 = List(9) { R.drawable.comunity }

    val communities = List(6) {
        Community(R.drawable.comunity, "Designa", "10 000 человек")
    }

    val events = List(6) {
        Event(
            R.drawable.frame,
            "Developer meeting",
            "Finished",
            "13.09.2024 — Москва",
            chips = listOf(
                { modifier -> WBChip(modifier = modifier, text = "Python") },
                { modifier -> WBChip(modifier = modifier, text = "Junior") },
                { modifier -> WBChip(modifier = modifier, text = "Moscow") }
            )
        )
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        WBText(
            text = "Карточка встречи",
            textSize = 20.sp,
            textWeight = FontWeight.Bold,
            textStyle = FontStyle.Italic,
        )

        WBEventCard(
            image = painterResource(id = R.drawable.frame),
            cardText = "Developer meeting",
            meetingStateText = "Finished",
            cardHint = "13.09.2024 — Москва",
            chips = listOf(
                { modifier -> WBChip(modifier = modifier, text = "Python") },
                { modifier -> WBChip(modifier = modifier, text = "Junior") },
                { modifier -> WBChip(modifier = modifier, text = "Moscow") }
            )
        )

        WBText(
            text = "Лист со встречами",
            textSize = 20.sp,
            textWeight = FontWeight.Bold,
            textStyle = FontStyle.Italic,
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
        ) {
            WBEventList(
                events = events,
                onClickListener = { index ->
                    Toast.makeText(
                        context,
                        "Event ${index + 1} clicked",
                        Toast.LENGTH_SHORT
                    ).show()

                })
        }

        WBText(
            text = "Карточка сообщества",
            textSize = 20.sp,
            textWeight = FontWeight.Bold,
            textStyle = FontStyle.Italic,
        )

        WBCommunityCard(
            image = painterResource(id = R.drawable.comunity),
            cardText = "Designa",
            cardHint = "10 000 человек",
        )

        WBText(
            text = "Лист с сообществами",
            textSize = 20.sp,
            textWeight = FontWeight.Bold,
            textStyle = FontStyle.Italic,
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            WBCommunityList(communities = communities,
                onClickListener = { index ->
                    Toast.makeText(
                        context,
                        "Community ${index + 1} clicked",
                        Toast.LENGTH_SHORT
                    ).show()
                })
        }

        WBText(
            text = "Cтрочка с людьми",
            textSize = 20.sp,
            textWeight = FontWeight.Bold,
            textStyle = FontStyle.Italic,
        )

        WBAttendeesRow(isCircle = false)
        WBAttendeesRow(
            isCircle = false,
            images = images
        )
        WBAttendeesRow(
            isCircle = false,
            images = images2
        )
        WBAttendeesRow(images = images3)
        WBAttendeesRow(images = images4)

        WBText(
            text = "Aватар из профиля",
            textSize = 20.sp,
            textWeight = FontWeight.Bold,
            textStyle = FontStyle.Italic,
        )

        WBAvatar()
        WBAvatar(
            state = AvatarState.Edit,
            onClickListenerIconSmall = {
                Toast.makeText(
                    context,
                    "Small icon pressed in Edit mode",
                    Toast.LENGTH_SHORT
                ).show()
            },
        )
    }
}

@Composable
@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
private fun ShowcaseSecondPreview(){
    ShowcaseSecond(context = LocalContext.current )
}
