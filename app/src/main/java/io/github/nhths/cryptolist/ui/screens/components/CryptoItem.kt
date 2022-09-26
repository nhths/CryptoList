package io.github.nhths.cryptolist.ui.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import io.github.nhths.cryptolist.ui.model.CryptoItemModel
import io.github.nhths.cryptolist.ui.theme.GreenPositive
import io.github.nhths.cryptolist.ui.theme.ItemLabelStyle
import io.github.nhths.cryptolist.ui.theme.ItemSubLabelStyle
import io.github.nhths.cryptolist.ui.theme.RedNegative
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*
import io.github.nhths.cryptolist.R

val decimalFormatPrice = DecimalFormat("#,##0.######", DecimalFormatSymbols(Locale.ENGLISH))
val decimalFormatPercentage = DecimalFormat("#,##0.##")

@Composable
fun CryptoItem(
    item: CryptoItemModel,
    onClick: () -> Unit = {}
){
    Row(
        modifier = Modifier
            .clickable { onClick }
            .fillMaxWidth()
            .padding(
                top = 8.dp,
                bottom = 8.dp,
                start = 16.dp,
                end = 16.dp
            )
    ) {
        val placeholder = painterResource(id = R.drawable.crypto_stub)
        val painter = rememberAsyncImagePainter(
            model = item.imageUrl,
            placeholder = placeholder
        )
        Image(
            painter = painter,
            contentDescription = item.name,
            modifier = Modifier
                .width(40.dp)
                .height(40.dp),
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(
                    start = 8.dp // 64 - 40 - 16 from figma
                )
        ) {
            Text(
                text = item.name,
                style = ItemLabelStyle,
                modifier = Modifier.height(20.dp)
            )
            Text(
                text = item.ticker,
                style = ItemSubLabelStyle,
                modifier = Modifier
                    .padding(
                        top = 2.dp, //30 - 8 - 20 from figma
                    )
                )
        }
        Column(
            horizontalAlignment = Alignment.End
        ) {
            val price = remember{ "${item.currencySymbol} ${decimalFormatPrice.format(item.price)}" }
            val diff = remember{"${decimalFormatPercentage.format(item.diffPercentage)}%"}
            val color = remember{if (item.diffPercentage >= 0) GreenPositive else RedNegative}
            Text(text = price)
            Text(
                text = diff,
                color = color
            )
        }
    }
}

@Preview
@Composable
private fun PreviewCurrencyItem(){
    val item = CryptoItemModel(
        id = "Test",
        name = "Bitok",
        ticker = "BTK",
        currencySymbol = "$",
        price = 6666666.666,
        diffPercentage = -66.666,
        imageUrl = "https://user-images.githubusercontent.com/10561726/68166182-c7833780-ff76-11e9-80ce-0b5a153fcd2c.png"
    )
    CryptoItem(item)
}