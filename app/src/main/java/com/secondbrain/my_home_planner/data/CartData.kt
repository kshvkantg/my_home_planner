package com.secondbrain.my_home_planner.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

// The data class to represent a grocery item
data class CartItem(
    val id: Int,
    val name: String,
    val description: String,
    val image: ImageVector
)

// The function to generate a sample list of grocery items
public fun generateSampleGroceryItems(): List<CartItem> {
    val icons = listOf(Icons.Default.Face, Icons.Default.Person, Icons.Default.Place, Icons.Default.MoreVert)

    return listOf(
        CartItem(id = 1, name = "Bread", description = "Whole grain bread", image = icons.random()),
        CartItem(id = 2, name = "Cheese", description = "Cheddar cheese", image = icons.random()),
        CartItem(id = 3, name = "Apple", description = "Red apples", image = icons.random()),
        CartItem(id = 4, name = "Orange", description = "Fresh oranges", image = icons.random()),
        CartItem(id = 5, name = "Milk", description = "Whole milk", image = icons.random()),
        CartItem(id = 6, name = "Bread", description = "Whole grain bread", image = icons.random()),
        CartItem(id = 7, name = "Cheese", description = "Cheddar cheese", image = icons.random()),
    )
}
