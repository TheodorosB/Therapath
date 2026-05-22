package io.github.theodorosB.therapath.ui.login.screens.onboarding.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import io.github.theodorosB.therapath.ui.login.screens.onboarding.model.OnBoardingUiState
import io.github.theodorosB.therapath.ui.login.screens.onboarding.viewmodel.OnBoardingViewModel
import io.github.theodorosB.therapath.ui.theme.SpacingCustom_100dp
import io.github.theodorosB.therapath.ui.theme.SpacingCustom_10dp
import io.github.theodorosB.therapath.ui.theme.SpacingCustom_14dp
import io.github.theodorosB.therapath.ui.theme.SpacingCustom_20dp
import io.github.theodorosB.therapath.ui.theme.SpacingCustom_36dp
import io.github.theodorosB.therapath.ui.theme.SpacingDefault_16dp
import io.github.theodorosB.therapath.ui.theme.SpacingQuarter_4dp
import kotlinx.coroutines.launch

@Composable
fun OnBoardingScreen() {
    val viewModel: OnBoardingViewModel = hiltViewModel()
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    OnBoardingContent(
        uiState = uiState,
        onFinish = {}
    )
}

@Composable
fun OnBoardingContent(
    uiState: State<OnBoardingUiState>,
    onFinish: () -> Unit
) {

    val pagerState = rememberPagerState(
        pageCount = { uiState.value.pages.size }
    )

    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF0F172A),
                        Color(0xFF1E1B4B)
                    )
                )
            )
    ) {

        HorizontalPager(
            state = pagerState,
        ) { page ->

            val item = uiState.value.pages[page]

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(SpacingCustom_36dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                /*Icon(
                    imageVector = item.icon,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(SpacingCustom_100dp)
                )*/

                Spacer(Modifier.height(SpacingCustom_36dp))

                Text(
                    text = stringResource(item.titleResId),
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.height(SpacingCustom_36dp))

                Text(
                    text = stringResource(item.descriptionResId),
                    color = Color.White.copy(alpha = 0.7f),
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center
                )
            }
        }

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = SpacingCustom_100dp),
            horizontalArrangement = Arrangement.Center
        ) {

            repeat(uiState.value.pages.size) { index ->

                val selected = pagerState.currentPage == index

                Box(
                    modifier = Modifier
                        .padding(SpacingQuarter_4dp)
                        .size(
                            if (selected) SpacingCustom_14dp else SpacingCustom_10dp
                        )
                        .clip(CircleShape)
                        .background(
                            if (selected)
                                Color.White
                            else
                                Color.White.copy(alpha = 0.3f)
                        )
                )
            }
        }

        Button(
            onClick = {

                if (pagerState.currentPage == uiState.value.pages.lastIndex) {
                    onFinish()
                } else {
                    scope.launch {
                        pagerState.animateScrollToPage(
                            pagerState.currentPage + 1
                        )
                    }
                }
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(SpacingCustom_36dp)
        ) {

            Text(
                if (pagerState.currentPage == uiState.value.pages.lastIndex)
                    "Get Started"
                else
                    "Next"
            )
        }
    }
}