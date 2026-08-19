package uz.rozimbay.courier.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val RozimbayColorScheme = darkColorScheme(
    primary = Violet,
    secondary = Pink,
    tertiary = Cyan,
    background = Ink,
    surface = Ink,
    onPrimary = TextPrimary,
    onBackground = TextPrimary,
    onSurface = TextPrimary,
)

@Composable
fun RozimbayTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = RozimbayColorScheme,
        typography = RozimbayTypography,
        content = content
    )
}
