package com.example.presentation.coin_detail

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.domain.model.CoinDetail
import com.example.domain.model.TeamMember
import com.example.presentation.coin_detail.components.CoinTag
import com.example.presentation.coin_detail.components.TeamListItem

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CoinDetailScreen(
    state: CoinDetailState
) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        //.padding(vertical = 50.dp),

    ) {

        Log.d("TAGS", state.coin?.name ?: "Nothing")

        state.coin?.let { coin ->

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ) {

                items(1) {

                    Spacer(Modifier.height(20.dp))

                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Text(
                            text = "${coin.rank}. ${coin.name} (${coin.symbol})",
                            color = Color.White,
                            style = MaterialTheme.typography.titleLarge
                        )

                        Text(
                            text = if (coin.isActive) "active" else "inactive",
                            color = if (coin.isActive) Color.Green else Color.Red,
                            style = MaterialTheme.typography.bodyMedium,
                            fontStyle = FontStyle.Italic
                        )
                    }

                    Spacer(Modifier.height(10.dp))

                    Text(
                        text = coin.description,
                        color = Color.White,
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Spacer(Modifier.height(20.dp))

                    Text(
                        text = "Tags",
                        color = Color.White,
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(Modifier.height(10.dp))


                    FlowRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        coin.tags.forEach {
                            CoinTag(it)
                        }
                    }

                    Spacer(Modifier.height(20.dp))

                    Text(
                        text = "Team Members",
                        color = Color.White,
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(Modifier.height(10.dp))

                    coin.team.forEach { teamMember ->

                        TeamListItem(teamMember)
                        HorizontalDivider(
                            modifier = Modifier.padding(vertical = 6.dp), color = Color.DarkGray
                        )

                    }


                }


            }

        }

        if (state.error.isNotBlank()) {

            Text(
                text = "Error loading data",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )

        }

        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.size(30.dp)
            )
        }
    }
}


@Preview
@Composable
private fun CoinDetailScreenPreview() {
    CoinDetailScreen(
        CoinDetailState(
            isLoading = false, coin = CoinDetail(
                coinId = "1",
                name = "Bitcoin",
                description = "Best coin, the COAT. It is the first decentralized digital currency, as the" + "system works without a central bank or single administrator",
                symbol = "BTC",
                rank = 1,
                isActive = true,
                tags = listOf("ola", "kase", "Mining", "Sha256"),
                team = listOf(
                    TeamMember(
                        id = "1", name = "Satoshi Nakamoto", position = "Founder"
                    ),
                    TeamMember(
                        id = "1", name = "Satoshi Nakamoto", position = "Founder"
                    ),
                    TeamMember(
                        id = "1", name = "Satoshi Nakamoto", position = "Founder"
                    ),
                )
            ), error = ""
        )
    )
}