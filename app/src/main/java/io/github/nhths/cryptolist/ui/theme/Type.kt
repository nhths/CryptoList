package io.github.nhths.cryptolist.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import io.github.nhths.cryptolist.R

// Set of Material typography styles to start with
val Typography = Typography(
/*    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )*/
)

val TitleTextStyle = TextStyle(
    fontFamily = FontFamily(Font(R.font.roboto_medium)),
    fontWeight = FontWeight.W500,
    fontSize = 20.sp,
    lineHeight = 24.sp, //rounded from 23.44px in figma
    color = Color(0xFF000000)
)

val TitleTextToolbarStyle = TitleTextStyle.copy(
    color = Color(0xDE000000)
)

val ContentTextStyle = TextStyle(
    fontFamily = FontFamily(Font(R.font.roboto_regular)),
    fontWeight = FontWeight.W400,
    fontSize = 16.sp,
    lineHeight = 19.sp, //rounded from 18.75 in figma
    color = Color(0xFF000000)
)

val IssueTextStyle = ContentTextStyle.copy(
    fontSize = 14.sp,
    lineHeight = 18.sp //rounded from 17.64 in figma
)

val ChipTextStyle = TextStyle(
    fontFamily = FontFamily(Font(R.font.roboto_regular)),
    fontWeight = FontWeight.W400,
    fontSize = 14.sp,
    lineHeight = 20.sp, //rounded from 18.75 in figma
)

val ItemLabelStyle = TextStyle(
    //fontFamily = FontFamily(Font(R.font.plusjakartasans)), //java.lang.IllegalStateException: Could not load font on android 7.0
    fontWeight = FontWeight.W500,
    fontSize = 16.sp,
    lineHeight = 20.sp, //rounded from 20.16 in figma
    color = Color(0xFF525252)
)

val ItemSubLabelStyle = ItemLabelStyle.copy(
    fontWeight = FontWeight.W400,
    fontSize = 14.sp,
    lineHeight = 18.sp,  //rounded from 17.64 in figma
    color = Color(0xFF9B9B9B)
)