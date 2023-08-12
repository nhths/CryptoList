package io.github.nhths.cryptolist.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.github.nhths.cryptolist.ui.screens.CryptoDetailsScreen
import io.github.nhths.cryptolist.ui.screens.CryptoListScreen

@Composable
fun MainNavHost(){
    val navController = rememberNavController()
    MainNavHost(
        navController = navController,
        startDestination = MainRoutes.CRYPTO_LIST
    ){
        composable(route = MainRoutes.CRYPTO_LIST){
            CryptoListScreen(
                onCryptoSelected = {
                    navController.navigate("${MainRoutes.CRYPTO_DETAILS}/${it}") }
            )
        }
        composable(
            route = "${MainRoutes.CRYPTO_DETAILS}/{key}",
            arguments = listOf(navArgument("key") { type = NavType.StringType })
        ){
            val cryptoId = it.arguments!!.getString("key")!!
            CryptoDetailsScreen(
                cryptoId = cryptoId,
                onBackClicked = {navController.popBackStack()}
            )
        }
    }
}

private fun NavController.navigate(mainRoutes: MainRoutes) {
    navigate(mainRoutes.toString())
}

/*@SuppressLint("ComposableDestinationInComposeScope")
@Composable
fun NavGraphBuilder.composable(
    route: MainRoutes,
    arguments: List<NamedNavArgument> = emptyList(),
    content: @Composable (NavBackStackEntry) -> Unit
) {
    composable(route = route.toString(), content = content)
}*/

@Composable
fun MainNavHost(navController: NavHostController,
            startDestination: MainRoutes,
            builder: NavGraphBuilder.() -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = startDestination.toString(),
        builder = builder
    )
}

