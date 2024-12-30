package com.example.pleasycrypto.presentation.coin_detail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pleasycrypto.data.remote.dto.TeamMember

@Composable
fun TeamListItem(
    teamMember: TeamMember
) {

    Column(
        Modifier.fillMaxWidth()
    ) {

        Text(
            text = teamMember.name,
            color = Color.White,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = teamMember.position,
            color = Color.White,
            style = MaterialTheme.typography.bodySmall,
            fontStyle = FontStyle.Italic,
        )
    }

}


@Preview
@Composable
private fun TeamListItemPreview() {
    TeamListItem(
        TeamMember(
            id = "1",
            name = "Satoshi Nakamoto",
            position = "Founder"
        )
    )
}