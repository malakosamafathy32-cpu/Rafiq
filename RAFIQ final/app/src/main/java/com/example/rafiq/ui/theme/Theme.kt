package com.example.rafiq.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat

private val LuxuryShapes = Shapes(
    small = RoundedCornerShape(12.dp),
    medium = RoundedCornerShape(20.dp),
    large = RoundedCornerShape(28.dp),
    extraLarge = RoundedCornerShape(32.dp)
)

private val DarkColorScheme = darkColorScheme(
    primary = PrimaryGold,
    onPrimary = OnPrimaryDark,
    primaryContainer = PrimaryContainerDark,
    onPrimaryContainer = OnPrimaryContainerDark,
    secondary = SecondaryPeach,
    onSecondary = OnSecondaryDark,
    secondaryContainer = SecondaryContainerDark,
    onSecondaryContainer = OnSecondaryContainerDark,
    background = BackgroundDeepInk,
    onBackground = OnBackgroundOffWhite,
    surface = SurfaceDarkSlate,
    onSurface = OnBackgroundOffWhite,
    surfaceVariant = SurfaceVariantDark,
    onSurfaceVariant = OnSurfaceVariantDark,
    outline = CustomOutlineDark,
    error = ErrorRed
)

private val LightColorScheme = lightColorScheme(
    primary = PrimaryPurple,
    onPrimary = OnPrimaryWhite,
    primaryContainer = PrimaryContainerLight,
    onPrimaryContainer = OnPrimaryContainerLight,
    secondary = SecondaryMagenta,
    onSecondary = OnSecondaryWhite,
    secondaryContainer = SecondaryContainerLight,
    onSecondaryContainer = OnSecondaryContainerLight,
    background = BackgroundWhite,
    onBackground = OnBackgroundCharcoal,
    surface = SurfaceWhite,
    onSurface = OnBackgroundCharcoal,
    surfaceVariant = SurfaceVariantLight,
    onSurfaceVariant = OnSurfaceVariantLight,
    outline = CustomOutline,
    error = ErrorRed
)

@Composable
fun RAFIQTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    fontSize: String = "normal",
    fontFamily: String = "default",
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    val fontScale = FontScale.fromValue(fontSize)
    val fontType = FontType.fromValue(fontFamily)
    val typography = scaledTypography(fontScale, fontType)
    val view = LocalView.current
    if (!view.isInEditMode) {
        try {
            val window = (view.context as Activity).window
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        } catch (_: Exception) { }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = typography,
        shapes = LuxuryShapes,
        content = content
    )
}
