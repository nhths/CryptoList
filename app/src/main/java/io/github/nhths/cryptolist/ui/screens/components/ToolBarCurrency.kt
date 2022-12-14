package io.github.nhths.cryptolist.ui.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.github.nhths.cryptolist.ui.model.CurrencyItemModel

//Figma surface seems like currency chips used into toolbar
@Composable
fun ToolBarCurrency(
    title: String,
    currencyList: List<CurrencyItemModel>,
    selected: Int,
    backgroundColor: Color = Color(0xFFFFFFFF), //No any idea how get color from toolbar, all fields private
    shadow: Dp = 3.dp,
    canNavigateUp: Boolean = false,
    onClickBack: () -> Unit = {},
    onCurrencyItemClicked: (Int, CurrencyItemModel) -> Unit,
){
    Box(//only for correct displaying shadow
        modifier = Modifier.shadow(shadow).padding(bottom = shadow)
    ){
        Column(
            modifier = Modifier
                .background(backgroundColor)
        ) {

            ToolBar(
                title = title,
                canNavigateUp = canNavigateUp,
                onClickBack = onClickBack,
                backgroundColor = backgroundColor,
                shadow = 0.dp
            )
            Row(
                modifier = Modifier.padding(
                    top = 13.dp,
                    bottom = 13.dp,
                    start = 16.dp,
                    end = 16.dp
                ),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                for (i in currencyList.indices){
                    val item = currencyList[i]
                    CurrencyChip(
                        label = item.ticker,
                        selected = selected == i,
                        onClick = {
                            onCurrencyItemClicked(i, item)
                        }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun PreviewToolBarCurrency(){
    val currencyList = listOf(
        CurrencyItemModel(
            id = "test1",
            ticker = "USD",
            symbol = "$"
        ),
        CurrencyItemModel(
            id = "test2",
            ticker = "EUR",
            symbol = "$$"
        )
    )
    ToolBarCurrency(
        title = "Test",
        currencyList = currencyList,
        selected = 0,
        onCurrencyItemClicked = {pos, item ->})
}