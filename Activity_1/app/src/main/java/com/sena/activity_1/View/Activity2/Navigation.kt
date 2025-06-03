package com.sena.activity_1.view.ActivityTwo

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sena.activity_1.HorizontalPages
import com.sena.activity_1.View.Activity1.Login

@Composable
fun AppNavigator() {
    val navController = rememberNavController()

    NavHost(navController = navController,
        startDestination = "HorizontalNavigation"
    )
    {
        composable("HorizontalNavigation")
        {
            HorizontalPages(navController = navController)
        }
        composable("registro") {
            RegisterScreen(navController)
        }
        composable("Login") {
            Login(navController)
        }
    }
}