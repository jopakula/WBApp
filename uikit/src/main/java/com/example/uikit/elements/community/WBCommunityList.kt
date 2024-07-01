package com.example.uikit.elements.community

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.base.common.NeutralLine
import com.example.uikit.base.text.WBText
import com.example.uikit.data.Community

/**
 * Компонент для отображения карточек с сообществами
 *
 * @param lineHeight Отвечает за высоту подчеркивания
 * @param lineWeight Отвечает за толщину подчеркивания
 * @param noCommunityText Отвечает за отображаемый текст при отсутствии карточек
 */

@Composable
fun WBCommunityList(
    communities: List<Community>? = emptyList(),
    onClickListener: (Int) -> Unit = {},
    lineHeight: Dp = 8.dp,
    lineColor: Color = NeutralLine,
    lineWeight: Dp = 1.dp,
    noCommunityText: String = "Create your community",
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        if (communities.isNullOrEmpty()) {
            item {
                WBText(text = noCommunityText)
            }
        } else {
            itemsIndexed(communities) { index, community ->
                WBCommunityCard(
                    image = painterResource(id = community.image),
                    cardText = community.text,
                    cardHint = community.hint,
                    onClickListener = { onClickListener(index) },

                    )
                if (index < communities.size - 1) {
                    Divider(
                        color = lineColor,
                        thickness = lineWeight,
                        modifier = Modifier.padding( vertical = lineHeight)
                    )
                }
            }
        }

    }
}

@Composable
@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
private fun CommunityListPreview() {
    val communities = List(6){
        Community(R.drawable.comunity, "Designa", "10 000 человек")
    }

    WBCommunityList(
        communities = communities
    )
}