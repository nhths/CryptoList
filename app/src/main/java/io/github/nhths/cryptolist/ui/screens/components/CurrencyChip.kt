package io.github.nhths.cryptolist.ui.screens.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import io.github.nhths.cryptolist.ui.theme.GrayMain
import io.github.nhths.cryptolist.ui.theme.OrangeMain
import io.github.nhths.cryptolist.ui.theme.OrangeSecondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CurrencyChip(
    onClick: () -> Unit,
    enabled: Boolean = false
){
    SuggestionChip(
        onClick = onClick,
        label = { Text(text = "test")},
        enabled = enabled,
        shape = RoundedCornerShape(16.dp),
        colors = SuggestionChipDefaults
            .suggestionChipColors(
                labelColor = OrangeMain,
                disabledLabelColor = Color.Black,
                containerColor = OrangeSecondary,
                disabledContainerColor = GrayMain
            ),
        border = SuggestionChipDefaults
            .suggestionChipBorder(
                borderColor = Color.Transparent,
                disabledBorderColor = Color.Transparent
            )
    )
}

class PreviewParameterProviderCurrencyChip : PreviewParameterProvider<Boolean> {
    override val values = listOf(false, true).asSequence()
}

@Preview
@Composable
fun PreviewCurrencyChip(
    @PreviewParameter(PreviewParameterProviderCurrencyChip::class) enabled: Boolean
){
    CurrencyChip(onClick = {}, enabled = enabled)
}