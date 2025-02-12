package com.example.presentation.coin_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.domain.model.Coin


@Composable
fun CoinListItem(
    coin: Coin,
    onItemClick: (Coin) -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(coin) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = "${coin.rank}. ${coin.name} (${coin.symbol})",
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge,
            overflow = TextOverflow.Ellipsis
        )

        Text(
            text = if (coin.isActive) "active" else "inactive",
            color = if (coin.isActive) Color.Green else Color.Red,
            style = MaterialTheme.typography.bodyMedium,
            fontStyle = FontStyle.Italic
        )

    }

}

@Preview(backgroundColor = 0x0F000000, showBackground = true)
@Composable
fun CoinListItemPreview() {
    CoinListItem(
        coin = Coin(
            id = "1",
            isActive = true,
            name = "Bitcoin",
            rank = 1,
            symbol = "BTC"
        ),
        onItemClick = {}
    )
}