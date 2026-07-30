package io.github.theodorosB.therapath.ui.lobby.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import io.github.theodorosB.therapath.ui.lobby.model.BottomNavBarItem
import io.github.theodorosB.therapath.ui.lobby.model.BottomNavEntry
import io.github.theodorosB.therapath.ui.lobby.screens.home.composable.HomeScreen
import io.github.theodorosB.therapath.ui.lobby.viewmodel.LobbyViewModel
import io.github.theodorosB.therapath.ui.theme.ColorLoginBackground1
import io.github.theodorosB.therapath.ui.theme.ColorLoginBackground2
import io.github.theodorosB.therapath.ui.theme.SpacingCustom_12dp
import io.github.theodorosB.therapath.ui.theme.SpacingCustom_20dp
import io.github.theodorosB.therapath.ui.theme.SpacingCustom_36dp
import io.github.theodorosB.therapath.ui.theme.SpacingCustom_6dp
import io.github.theodorosB.therapath.ui.theme.SpacingDefault_16dp
import io.github.theodorosB.therapath.ui.theme.SpacingHalf_8dp
import io.github.theodorosB.therapath.ui.theme.SpacingQuarter_4dp

@Composable
internal fun LobbyNavDisplay() {

    val viewModel: LobbyViewModel = hiltViewModel()
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    BackHandler {
        uiState.value.onNavigateBackClicked()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        ColorLoginBackground1,
                        ColorLoginBackground2
                    )
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(space = SpacingHalf_8dp, alignment = Alignment.Top)
    ) {
        NavDisplay(
            backStack = uiState.value.lobbyBackStack,
            contentAlignment = Alignment.Center,
            transitionSpec = {
                val enter = slideInHorizontally { fullWidth -> fullWidth }
                val exit = slideOutHorizontally { fullWidth -> -fullWidth }
                enter togetherWith exit
            },
            popTransitionSpec = {
                val enter = slideInHorizontally { fullWidth -> -fullWidth }
                val exit = slideOutHorizontally { fullWidth -> fullWidth }
                enter togetherWith exit
            },
            entryProvider = { key ->
                when (key) {
                    BottomNavEntry.Home -> NavEntry(
                        key = key,
                        content = {
                            HomeScreen()
                        }
                    )

                    BottomNavEntry.Search -> NavEntry(
                        key = key,
                        content = {
                        }
                    )
                    BottomNavEntry.Calendar -> NavEntry(
                        key = key,
                        content = {

                        }
                    )


                    BottomNavEntry.Messages -> NavEntry(
                        key = key,
                        content = {

                        }
                    )

                    BottomNavEntry.Profile -> NavEntry(
                        key = key,
                        content = {

                        }
                    )
                }
            }
        )
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            LobbyBottomNavBar(
                items = uiState.value.bottomNavBar,
                onItemClick = uiState.value.onBottomNavClick
            )
        }
    }
}

@Composable
private fun LobbyBottomNavBar(
    items: List<BottomNavBarItem>,
    onItemClick: (BottomNavBarItem) -> Unit,
    modifier: Modifier = Modifier
) {

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = SpacingCustom_20dp, vertical = SpacingDefault_16dp),
        shape = RoundedCornerShape(SpacingCustom_36dp),
        color = Color.White,
        shadowElevation = SpacingCustom_12dp
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = SpacingCustom_12dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {

            items.forEach { item ->

                val color by animateColorAsState(
                    targetValue = if (item.isSelected.value)
                        Color(0xFF6C63FF)
                    else
                        Color.Gray,
                    label = ""
                )

                val scale by animateFloatAsState(
                    targetValue = if (item.isSelected.value) 1.15f else 1f,
                    label = ""
                )

                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(SpacingDefault_16dp))
                        .clickable {
                            onItemClick(item)
                        }
                        .padding(horizontal = SpacingCustom_12dp, vertical = SpacingCustom_6dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = stringResource(item.title),
                        modifier = Modifier.scale(scale),
                        tint = Color.Black
                    )

                    Spacer(modifier = Modifier.height(SpacingQuarter_4dp))

                    Text(
                        text = stringResource( item.title),
                        color = color,
                        fontSize = 12.sp,
                        fontWeight = if (item.isSelected.value)
                            FontWeight.SemiBold
                        else
                            FontWeight.Normal
                    )
                }
            }
        }
    }
}