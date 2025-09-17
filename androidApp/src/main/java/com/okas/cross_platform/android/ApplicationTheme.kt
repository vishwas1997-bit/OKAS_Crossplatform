package com.okas.cross_platform.android

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.okas.cross_platform.android.theme.ProximaNova

@Composable
fun ApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colors = if (darkTheme) {
        darkColorScheme(
            primary = Color(0xFF0094AD)
//            secondary = Color(0xFF03DAC5),
//            tertiary = Color(0xFF3700B3)
        )
    } else {
        lightColorScheme(
            primary = Color(0xFF0094AD)
//            secondary = Color(0xFF03DAC5),
//            tertiary = Color(0xFF3700B3)
        )
    }
    val shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dp)
    )

    val typography = Typography(
        bodySmall = TextStyle(
            fontFamily = ProximaNova,
            fontWeight = FontWeight.Light
        ),
        bodyMedium = TextStyle(
            fontFamily = ProximaNova,
            fontWeight = FontWeight.Normal
        ),
        bodyLarge = TextStyle(
            fontFamily = ProximaNova,
            fontWeight = FontWeight.SemiBold
        ),
        titleLarge = TextStyle(
            fontFamily = ProximaNova,
            fontWeight = FontWeight.ExtraBold
        )
    )

    MaterialTheme(
        colorScheme = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}
