package com.example.udf_viewmodel_navigation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.udf_viewmodel_navigation.navigation.routes.addword.AddWordRoute
import com.example.udf_viewmodel_navigation.navigation.routes.home.HomeRoute

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object AddWord : Screen("add_word")
}

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeRoute(
                onNavigateToAdd = {
                    navController.navigate(Screen.AddWord.route)
                },
                onNavigateToLearn = {

                }
            )
        }
        composable(Screen.AddWord.route) {
            AddWordRoute(onBack = { navController.popBackStack() })
        }
    }
}