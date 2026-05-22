package io.github.theodorosB.therapath.ui.splash.composable

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.theodorosB.therapath.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
internal fun SplashScreen(
    onAnimationEnd: () -> Unit
) {
    SplashContent(
        onAnimationEnd = onAnimationEnd
    )
}

@Composable
private fun SplashContent(
    modifier: Modifier = Modifier,
    onAnimationEnd: () -> Unit
) {
    val scale = remember {
        Animatable(0.8f)
    }

    val alpha = remember {
        Animatable(0f)
    }

    val textOffset = remember {
        Animatable(40f)
    }

    LaunchedEffect(Unit) {

        launch {
            scale.animateTo(
                1f,
                animationSpec = tween(
                    durationMillis = 1200,
                    easing = FastOutSlowInEasing
                )
            )
        }

        launch {
            alpha.animateTo(
                1f,
                animationSpec = tween(900)
            )
        }

        launch {
            delay(300)

            textOffset.animateTo(
                0f,
                animationSpec = tween(
                    durationMillis = 900,
                    easing = FastOutSlowInEasing
                )
            )
        }

        delay(2200)

        onAnimationEnd()
    }

    Box(
        modifier = modifier.fillMaxSize()
    ) {

        AuroraBackground()

        FloatingBlobs()

        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
                    .graphicsLayer {
                        scaleX = scale.value
                        scaleY = scale.value
                        this.alpha = alpha.value
                    }
            )

            Spacer(Modifier.height(20.dp))

            Text(
                text = stringResource(R.string.app_name),
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.graphicsLayer {
                    translationY = textOffset.value
                    this.alpha = alpha.value
                }
            )
        }
    }
}

@Composable
private fun AuroraBackground() {

    val infinite = rememberInfiniteTransition()

    val offset by infinite.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 10000,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Reverse
        )
    )

    Canvas(
        modifier = Modifier.fillMaxSize()
    ) {

        drawRect(
            brush = Brush.linearGradient(
                colors = listOf(
                    Color(0xFF0F172A),
                    Color(0xFF1E1B4B),
                    Color(0xFF312E81)
                ),
                start = Offset(offset, 0f),
                end = Offset(size.width, size.height)
            )
        )
    }
}

@Composable
private fun FloatingBlobs() {

    val infinite = rememberInfiniteTransition()

    val move by infinite.animateFloat(
        initialValue = -100f,
        targetValue = 100f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                4000,
                easing = EaseInOut
            ),
            repeatMode = RepeatMode.Reverse
        )
    )

    Box(
        Modifier.fillMaxSize()
    ) {

        Box(
            modifier = Modifier
                .offset(x = 40.dp, y = (120 + move).dp)
                .size(220.dp)
                .background(
                    Color(0xFF7C3AED).copy(alpha = 0.4f),
                    CircleShape
                )
                .blur(120.dp)
        )

        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .offset(x = (-40).dp, y = (-80 + move).dp)
                .size(260.dp)
                .background(
                    Color(0xFF06B6D4).copy(alpha = 0.35f),
                    CircleShape
                )
                .blur(140.dp)
        )
    }
}