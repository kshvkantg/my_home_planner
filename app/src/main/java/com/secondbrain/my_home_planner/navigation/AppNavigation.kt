package com.secondbrain.my_home_planner.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.secondbrain.my_home_planner.screens.CartSelectionScreen
import com.secondbrain.my_home_planner.screens.InfoScreen
import com.secondbrain.my_home_planner.screens.SplashScreen

@Composable
fun AppNavigator(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.SplashScreen.route) {
        composable(Screens.SplashScreen.route) { SplashScreen(navController) }
        composable(Screens.InfoScreen.route) { InfoScreen(navController) }
        composable(Screens.CartSelectionScreen.route) {CartSelectionScreen(navController) }
    }
}