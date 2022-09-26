package io.github.nhths.cryptolist.ui.screens.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.nhths.cryptolist.R
import io.github.nhths.cryptolist.ui.theme.IssueTextStyle
import io.github.nhths.cryptolist.ui.theme.OrangeMain

@Composable
fun LoadingCryptoErrorScreen(
    icon: Painter,
    message: String,
    onClick: () -> Unit = {}
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = icon,
            tint = Color.Unspecified,
            contentDescription = "Crypto",
            modifier = Modifier.size(120.dp))

        Spacer(modifier = Modifier.height(13.dp))

        Text(
            text = message,
            style = IssueTextStyle,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(
                    start = 79.dp,
                    end = 79.dp
                )
            )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = onClick,
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = OrangeMain
            )
            ) {
            Text(text = stringResource(id = R.string.button_try))
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun PreviewLoadingCryptoErrorScreen(){
    LoadingCryptoErrorScreen(
        icon = painterResource(id = R.drawable.crypto_stub),
        message = "What's went wrong.... Lorem ipsum dolor sit amet, " +
                "consectetur adipiscing elit. Maecenas gravida tincidunt augue vitae dictum." +
                " Vestibulum suscipit ligula at congue vulputate." +
                " Phasellus aliquam nulla in maximus sollicitudin.",
        onClick = {}
    )
}