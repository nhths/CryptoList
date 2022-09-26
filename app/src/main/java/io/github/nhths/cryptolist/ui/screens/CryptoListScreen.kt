package io.github.nhths.cryptolist.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshState
import io.github.nhths.cryptolist.R
import io.github.nhths.cryptolist.ui.model.CryptoItemModel
import io.github.nhths.cryptolist.ui.screens.components.CryptoItem
import io.github.nhths.cryptolist.ui.screens.components.LoadingCryptoErrorScreen
import io.github.nhths.cryptolist.ui.screens.components.SnackBarError
import io.github.nhths.cryptolist.ui.screens.components.ToolBarCurrency
import io.github.nhths.cryptolist.vm.CryptoListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CryptoListScreen(
    viewModel: CryptoListViewModel = CryptoListViewModel(),
    onCryptoSelected:(cryptoId:String) -> Unit
){
    val state by viewModel.state.observeAsState()
    val currencyList by viewModel.currencyList.observeAsState()
    val cryptoList by viewModel.cryptoList.observeAsState()
    val selectedCurrency by viewModel.selectedCurrency.observeAsState()

    val snackbarHostState by viewModel.snackbarState.observeAsState()
    val swipeRefreshState by viewModel.refreshState.observeAsState()

    Scaffold(
        topBar = {
            ToolBarCurrency(
                title = stringResource(id = R.string.title_crypto_list),
                currencyList = currencyList!!,
                selected = selectedCurrency!!,
                onCurrencyItemClicked = {pos, item -> viewModel.onCurrencySelected(pos, item)})
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState!!){
                SnackBarError(snackbarData = it)
            }
        }
    ) {
        Box(modifier = Modifier.padding(it)) {
            when(state){
                CryptoListViewModel.State.SHOWING -> {
                    Listing(
                        cryptoItems = cryptoList?: listOf(),
                        onRefreshSwiped = {viewModel.onListUpdate()},
                        swipeRefreshState = swipeRefreshState!!,
                        onCryptoSelected = onCryptoSelected
                    )
                }
                CryptoListViewModel.State.ERROR ->{
                    Error()
                }
                else ->{//State loading
                    LoadingScreen()
                }
            }
        }
    }
}

@Composable
private fun Listing(
    cryptoItems: List<CryptoItemModel>,
    onRefreshSwiped: () -> Unit,
    swipeRefreshState: SwipeRefreshState,
    onCryptoSelected:(cryptoId:String) -> Unit
){
    SwipeRefresh(
        state = swipeRefreshState,
        onRefresh = onRefreshSwiped
    ) {
        LazyColumn(){
            items(cryptoItems) {
                CryptoItem(
                    item = it,
                    onClick = {
                        onCryptoSelected(it.id)
                    }
                )
            }
        }
    }
}

@Composable
private fun Error(){
    LoadingCryptoErrorScreen(
        icon = painterResource(id = R.drawable.crypto_stub),
        message = stringResource(id = R.string.error_message_simple)
    )
}

@Preview
@Composable
private fun PreviewCryptoListScreen(){
    CryptoListScreen(){

    }
}