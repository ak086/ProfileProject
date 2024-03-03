package com.example.profileproject

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem (
         val route: String,
         val label: String,
         val icon: ImageVector
    ) {

    object Home : BottomNavItem(route = "Home",
        label = "Home", icon = Icons.Default.Home)

    object Order : BottomNavItem(route = "order",
        label = "Order", icon = Icons.Default.ShoppingCart)

    object Points : BottomNavItem(route = "points",
        label = "Points", icon = Icons.Default.Star)

    object Profile : BottomNavItem(route = "Profile",
        label = "Profile", icon = Icons.Default.AccountCircle)

}