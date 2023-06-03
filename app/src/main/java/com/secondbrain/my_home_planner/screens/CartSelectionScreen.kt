package com.secondbrain.my_home_planner.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.secondbrain.my_home_planner.data.CartItem
import com.secondbrain.my_home_planner.data.generateSampleGroceryItems

@Composable
fun CartSelectionScreen(navController: NavController) {
    Surface(color = MaterialTheme.colorScheme.background) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(1f)
            .padding(vertical = 16.dp, horizontal = 16.dp)
        ) {
            SelectionScreen(
                navController = navController,
                items = generateSampleGroceryItems()
            )
        }
    }
}

@Composable
fun SelectionScreen(
    navController: NavController,
    items: List<CartItem>,
) {
    val selectedItem = remember { mutableStateListOf<CartItem>() }
    Column {
        TopBar(
            screenHeading = "Setup Kitchen",
            navController = navController
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth().padding(top = 4.dp, bottom = 32.dp)) {
            itemsIndexed(items) { index, item ->
                ItemCard(
                    item = item,
                    isSelected = item in selectedItem,
                    onItemSelected = {
                        if (item in selectedItem) selectedItem.remove(it)
                        else selectedItem.add(it)
                    }
                )
            }
        }
    }
}

@Composable
fun TopBar(
    screenHeading: String,
    navController: NavController
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back"
            )
        }
        Text(
            text = screenHeading,
            modifier = Modifier.padding(start = 0.dp),
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemCard(item : CartItem, isSelected: Boolean, onItemSelected: (CartItem) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth() // stretches along the width of the screen
            .padding(horizontal = 12.dp, vertical = 6.dp) // padding at the start and end
            .border(
                width = if (isSelected) 1.dp else 0.dp,
                color = if (isSelected) MaterialTheme.colorScheme.primary else Color.Transparent,
                shape = RoundedCornerShape(8.dp)
            ),// makes the card border glow when clicked,
        elevation = CardDefaults.elevatedCardElevation(), // optional: elevation for the card
        onClick = { onItemSelected(item) }, // optional: click listener for the card
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = item.image,
                contentDescription = null, // replace with appropriate description
                modifier = Modifier.padding(16.dp)
            )
            Column(modifier = Modifier.padding(top = 16.dp, bottom = 16.dp, end = 16.dp).weight(1f)) {
                Text(text = item.name, style = MaterialTheme.typography.bodyMedium)
                Text(text = item.description, style = MaterialTheme.typography.bodySmall)
            }
            if (isSelected){
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    tint = MaterialTheme.colorScheme.primary,
                    contentDescription = null, // replace with appropriate description
                    modifier = Modifier.padding(16.dp)
                )
            }

        }
    }
}

