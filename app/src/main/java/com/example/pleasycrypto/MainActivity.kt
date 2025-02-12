package com.example.pleasycrypto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pleasycrypto.screens.Screen
import com.example.pleasycrypto.ui.theme.PLEasyCryptoTheme
import com.example.presentation.coin_detail.CoinDetailScreen
import com.example.presentation.coin_detail.CoinDetailViewModel
import com.example.presentation.coin_list.CoinListScreen
import com.example.presentation.coin_list.CoinListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            PLEasyCryptoTheme {
                val coinListViewModel : CoinListViewModel = hiltViewModel()
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.CoinListScreen
                ) {
                    composable<Screen.CoinListScreen>() {
                        CoinListScreen(
                            onClick = { coinId ->
                                navController.navigate(Screen.CoinDetailScreen(coinId))
                            }, state = coinListViewModel.state
                        )

                    }
                    composable<Screen.CoinDetailScreen>() {
                        val coinDetailViewModel: CoinDetailViewModel = hiltViewModel()
                        CoinDetailScreen(coinDetailViewModel.state)
                    }
                }
            }
        }
    }
}
