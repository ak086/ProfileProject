package com.example.profileproject

import PaymentScreen
import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BadgedBox
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.PopUpToBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainEntryPoint(){
    val navController = rememberNavController()

    Scaffold(bottomBar = { MainBottomNavigation(navController = navController)}) {
        MainNavigation(navHostController = navController)
    }
}

@Composable
fun MainNavigation(navHostController: NavHostController){
    NavHost(navController = navHostController, startDestination = BottomNavItem.Profile.route){
        composable(route = BottomNavItem.Home.route){
        }
        composable(route = BottomNavItem.Points.route){
        }
        composable(route = BottomNavItem.Profile.route){
            ProfilePage()
        }
        composable(route = BottomNavItem.Order.route){
            PaymentScreen()
        }
    }
}

@Composable
fun MainBottomNavigation(navController: NavController){
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Points,
        BottomNavItem.Order,
        BottomNavItem.Profile
    )
    BottomNavigation(Modifier.background(brush = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFFF5F6D),
            Color(0xFFFFC371)
        ),
        startY = 0f,
        endY = 400f
    )), contentColor = Color.White) {

        val navStack by navController.currentBackStackEntryAsState()
        val currentRoute = navStack?.destination?.route

        items.forEach { item ->
            BottomNavigationItem(
                label={Text(item.label)},
                selected = currentRoute== item.route,
                onClick = {
                          navController.navigate(item.route)

                },
                icon = {
                    BadgedBox(badge = {
                        if (currentRoute==item.route){
                        Surface(modifier = Modifier.padding(4.dp),shape= CircleShape, color = Color.Red) {
                            Text(text = "*", modifier = Modifier.padding(4.dp))
                        }
                    } }) {
                        Icon(imageVector = item.icon, contentDescription = null, modifier = Modifier.size(20.dp))
                    }
                }, alwaysShowLabel = true,
                selectedContentColor = Color.Red, unselectedContentColor = Color.Black)
        }

    }
}