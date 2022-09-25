package io.github.nhths.cryptolist.ui.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
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
        Image(
            painter = item.imagePainter,
            contentDescription = item.name,
            modifier = Modifier
                .width(40.dp)
                .height(40.dp),
            colorFilter = ColorFilter.tint(Color.Black)
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
            Text(text = "${item.currencySymbol} ${decimalFormatPrice.format(item.price)}")
            Text(
                text = "${decimalFormatPercentage.format(item.diffPercentage)}%",
                color = if (item.diffPercentage >= 0) GreenPositive else RedNegative
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
        imagePainter = rememberAsyncImagePainter(
            model = "https://static-00.iconduck.com/assets.00/polkadot-cryptocurrency-icon-512x512-p01ydom1.png",
            placeholder = rememberVectorPainter(image = Icons.Rounded.Info)
        )
    )
    CryptoItem(item)
}