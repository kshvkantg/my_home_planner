package com.secondbrain.my_home_planner.navigation

sealed class Screens(val route: String) {
    object SplashScreen : Screens("splash_screen")
    object InfoScreen : Screens("info_screen")
    object CartSelectionScreen : Screens("cart_selection_screen")
}