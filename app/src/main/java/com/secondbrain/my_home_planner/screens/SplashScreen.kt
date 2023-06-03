package com.secondbrain.my_home_planner.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.secondbrain.my_home_planner.navigation.Screens

@Composable
fun SplashScreen(navController: NavController) {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(vertical = 100.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            CircularIconButton(
                onClick = { navController.navigate(Screens.InfoScreen.route) },
                modifier = Modifier.padding(16.dp) , // Adds padding to the button,
            )
        }
    }
}


@Composable
fun CircularIconButton(
    onClick: () -> Unit, // Function that will be called when the button is clicked
    modifier: Modifier = Modifier // Modifier to be applied to the button
) {
    IconButton(onClick = onClick,
        modifier = modifier
            .size(48.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
    ) {
        Icon(
            imageVector = Icons.Default.ArrowForward,
            contentDescription = "Home Icon",
            tint = MaterialTheme.colorScheme.onSecondary
        )
    }
}