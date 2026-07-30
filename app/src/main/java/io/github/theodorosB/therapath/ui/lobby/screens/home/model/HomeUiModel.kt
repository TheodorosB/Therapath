package io.github.theodorosB.therapath.ui.lobby.screens.home.model

import androidx.annotation.StringRes

data class HomeUiState(
    val banners: MutableList<BannerUiItem> = mutableListOf()
)

data class BannerUiItem(
    @StringRes val titleResId: Int,
    @StringRes val descriptionResId: Int,
    val rating: Double,
    val imageUrl: String,
)
