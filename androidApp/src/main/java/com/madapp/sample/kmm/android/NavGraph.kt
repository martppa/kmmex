package com.madapp.sample.kmm.android

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.madapp.sample.kmm.HomeViewModel

const val HomeRoute = "home"
const val WifiRoute = "wifi"

@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String = HomeRoute,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        composable(HomeRoute) {
            HomeScreen(navController, HomeViewModel())
        }
        composable(WifiRoute) {
            WifiScreen()
        }
    }
}