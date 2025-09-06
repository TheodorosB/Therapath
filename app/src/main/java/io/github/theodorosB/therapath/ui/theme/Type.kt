package io.github.theodorosB.therapath.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import io.github.theodorosB.therapath.R

val fontProvider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)
val googleFont = GoogleFont("Libertinus Serif Display")

val therapathFontFamily = FontFamily(
    Font(
        googleFont = googleFont,
        fontProvider = fontProvider
    )
)
val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = therapathFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = therapathFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
    ),
    titleSmall = TextStyle(
        fontFamily = therapathFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
    ),
    bodyLarge = TextStyle(
        fontFamily = therapathFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = therapathFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp
    ),
    bodySmall = TextStyle(
        fontFamily = therapathFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp
    ),
    labelLarge = TextStyle(
        fontFamily = therapathFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    ),
    labelMedium = TextStyle(
        fontFamily = therapathFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
    ),
    labelSmall = TextStyle(
        fontFamily = therapathFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
    ),
)