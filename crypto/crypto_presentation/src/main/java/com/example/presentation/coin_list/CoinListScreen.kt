package com.example.presentation.coin_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.domain.model.Coin

import com.example.presentation.coin_list.components.CoinListItem

@Composable
fun CoinListScreen(
    onClick: (coinId: String) -> Unit,
    state: CoinListState
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        //.padding(vertical = 50.dp),
        contentAlignment = Alignment.Center
    ) {

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {

            items(state.coins){ coin ->
                CoinListItem(coin = coin, onItemClick = { onClick(coin.id) })
            }

        }

        if (state.error.isNotBlank()) {

            Text(
                text = "Error loading data",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.displayMedium,
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


@Preview(showSystemUi = true)
@Composable
private fun CoinListScreenPreview() {
    CoinListScreen(
        onClick = {}, state = CoinListState(
            isLoading = false, coins = listOf(
                Coin(
                    id = "1", isActive = true, name = "Bitcoin", rank = 1, symbol = "BTC"
                )
            )
        )
    )
}
