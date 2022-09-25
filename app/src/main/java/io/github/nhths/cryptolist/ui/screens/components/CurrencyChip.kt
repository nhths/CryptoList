package io.github.nhths.cryptolist.ui.screens.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import io.github.nhths.cryptolist.ui.theme.ChipTextStyle
import io.github.nhths.cryptolist.ui.theme.GrayMain
import io.github.nhths.cryptolist.ui.theme.OrangeMain
import io.github.nhths.cryptolist.ui.theme.OrangeSecondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CurrencyChip(
    label: String,
    selected: Boolean = false,
    modifier: Modifier = Modifier
        .width(90.dp) //rounded from 89 in figma
        .height(32.dp),
    onClick: () -> Unit = {}
){
    InputChip(
        onClick = onClick,
        label = {
            Text(
                text = label,
                style = ChipTextStyle,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 8.dp),//compensate start padding
                textAlign = TextAlign.Center
            )
        },
        selected = selected,
        shape = RoundedCornerShape(16.dp),
        modifier = modifier,
        colors = InputChipDefaults
            .inputChipColors(
                labelColor = Color.Black,
                selectedLabelColor = OrangeMain,
                containerColor = GrayMain,
                selectedContainerColor = OrangeSecondary
            ),
        border = InputChipDefaults
            .inputChipBorder(
                borderColor = Color.Transparent,
                disabledBorderColor = Color.Transparent
            )
    )
}

private class PreviewParameterProviderCurrencyChip : PreviewParameterProvider<Boolean> {
    override val values = listOf(false, true).asSequence()
}

@Preview
@Composable
private fun PreviewCurrencyChip(
    @PreviewParameter(PreviewParameterProviderCurrencyChip::class) selected: Boolean
){
    var selectedVal = remember{ mutableStateOf(selected)}
    CurrencyChip(selectedVal.value.toString(), selectedVal.value){
        println(selectedVal.value.toString())
        selectedVal.value = selectedVal.value.not()
    }
}