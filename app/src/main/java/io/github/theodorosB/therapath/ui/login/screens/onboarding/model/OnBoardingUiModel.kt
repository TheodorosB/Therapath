package io.github.theodorosB.therapath.ui.login.screens.onboarding.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import io.github.theodorosB.therapath.R

data class OnBoardingUiState(
    val onNextClicked: () -> Unit = {},
    val pages: List<OnboardingPageUiItem> = onBoardingPages,
) {

    companion object {
        val onBoardingPages = listOf(
            OnboardingPageUiItem(
                titleResId = R.string.onboarding_discover_the_approach_title,
                descriptionResId = R.string.onboarding_discover_the_approach_description,
                buttonTextResId =  R.string.onboarding_button_next
            ),
            OnboardingPageUiItem(
                titleResId = R.string.onboarding_connect_with_professionals_title,
                descriptionResId = R.string.onboarding_connect_with_professionals_description,
                buttonTextResId =  R.string.onboarding_button_next
            ),
            OnboardingPageUiItem(
                titleResId = R.string.onboarding_build_your_journey_title,
                descriptionResId = R.string.onboarding_build_your_journey_description,
                buttonTextResId =  R.string.onboarding_button_get_started
            )
        )
    }
}

data class OnboardingPageUiItem(
    @StringRes val descriptionResId: Int,
    @StringRes val titleResId: Int,
    @StringRes val buttonTextResId: Int,
    @DrawableRes val icon: Int = 0
)
