package io.github.nhths.cryptolist.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import io.github.nhths.cryptolist.R
import io.github.nhths.cryptolist.ui.screens.components.LoadingCryptoErrorScreen
import io.github.nhths.cryptolist.ui.screens.components.ToolBar
import io.github.nhths.cryptolist.ui.theme.ContentTextStyle
import io.github.nhths.cryptolist.ui.theme.TitleTextStyle
import io.github.nhths.cryptolist.vm.CryptoDetailsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CryptoDetailsScreen(
    cryptoId: String,
    viewModel: CryptoDetailsViewModel =
        androidx.lifecycle.viewmodel.compose.viewModel(
            factory = CryptoDetailsViewModel.Factory(cryptoId)
        ),
    onBackClicked: () -> Unit = {}
){
    val state by viewModel.state.observeAsState()
    val cryptoDetails by viewModel.cryptoDetails.observeAsState()

    Scaffold(
        topBar = {
            var title = ""
            cryptoDetails?.let {
                title = it.name?: ""
            }
            ToolBar(
                title = title,
                canNavigateUp = true,
                onClickBack = onBackClicked
            )
        }
    ) {
        Box(modifier = Modifier.padding(it)) {
            when(state){
                CryptoDetailsViewModel.State.SHOWING -> {
                    Listing(
                        icon = rememberAsyncImagePainter(
                            model = cryptoDetails!!.imageUrl
                        ),
                        description = remember{
                            cryptoDetails!!.description.replace("\\<.*?>".toRegex(), "")
                        },
                        categories = cryptoDetails!!.categories
                    )
                }
                CryptoDetailsViewModel.State.ERROR ->{
                    Error(){
                        viewModel.onRefresh()
                    }
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
    icon: Painter,
    description: String,
    categories: String
){
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(
            modifier = Modifier.height(10.dp)
        )
        Icon(
            painter = icon,
            contentDescription = description,
            tint = Color.Unspecified,
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = 16.dp)
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        Paragraph(
            title = stringResource(id = R.string.title_description),
            text = description
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        Paragraph(
            title = stringResource(id = R.string.title_categories),
            text = categories
        )
    }
}

@Composable
private fun Paragraph(
    title: String,
    text: String
){
    Text(
        text = title,
        style = TitleTextStyle,
        modifier = Modifier
            .padding(
                horizontal = 16.dp
            )

    )
    Spacer(
        modifier = Modifier.height(8.dp)
    )
    Text(
        text = text,
        style = ContentTextStyle,
        modifier = Modifier
            .padding(
                horizontal = 16.dp
            )
    )
}

@Composable
private fun Error(
    onTryClick: () -> Unit = {}
){
    LoadingCryptoErrorScreen(
        icon = painterResource(id = R.drawable.crypto_stub),
        message = stringResource(id = R.string.error_message_simple),
        onClick = onTryClick
    )
}

@Preview
@Composable
private fun PreviewListing(){
    Listing(
        icon = painterResource(id = R.drawable.crypto_stub),
        description = ("Lorem ipsum dolor sit amet, consectetur adipiscing elit," +
                " sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
                " Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris" +
                " nisi ut aliquip ex ea commodo consequat." +
                " Duis aute irure dolor in reprehenderit in voluptate " +
                "velit esse cillum dolore eu fugiat nulla pariatur." +
                " Excepteur sint occaecat cupidatat non proident," +
                " sunt in culpa qui officia deserunt mollit anim id est laborum.").repeat(4),
        categories = "Shitcoin, PoW, 2 layer"
    )
}

@Preview
@Composable
private fun PreviewCryptoDetailsScreen(){
    CryptoDetailsScreen(
        cryptoId = ""
    )
}