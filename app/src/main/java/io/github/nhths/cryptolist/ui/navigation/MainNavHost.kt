package io.github.nhths.cryptolist.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.github.nhths.cryptolist.ui.screens.CryptoDetailsScreen
import io.github.nhths.cryptolist.ui.screens.CryptoListScreen

@Composable
fun MainNavHost(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = HomeDestinations.CRYPTO_LIST
    ){
        composable(route = HomeDestinations.CRYPTO_LIST){
            CryptoListScreen(
                onCryptoSelected = { navController.navigate(HomeDestinations.CRYPTO_DETAILS) }
            )
        }
        composable(route = HomeDestinations.CRYPTO_DETAILS){
            CryptoDetailsScreen()
        }
    }
}