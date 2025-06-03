package com.sena.activity_1.View.Transition

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun AppAnimation() {
    val navController = rememberNavController()

    NavHost(navController = navController,
        startDestination = "pagina1",
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = {it}
            )+ fadeIn(
                animationSpec = tween(800)
            )
        }
    )
    {
        composable(route = "pagina2/{nombre}", arguments = listOf(navArgument("nombre"){
            defaultValue = "sin valor"
            type = NavType.StringType
        } )
        )
        {data->
            val nombre = data.arguments?.getString("nombre")

            Pagina2(
                navController,
                nombre = nombre
            )
        }
        composable("pagina1") {
            Pagina1(navController)
        }

    }
}