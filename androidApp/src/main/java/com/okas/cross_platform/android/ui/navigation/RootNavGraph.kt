package com.okas.cross_platform.android.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.okas.cross_platform.android.ui.onboarding.authNavGraph

@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Graph.AUTH
    ) {
        authNavGraph(
            rootNavController = navController,
            onNavigateToHome = {
                navController.navigate(Graph.HOME) {
                    popUpTo(Graph.AUTH) { inclusive = true }
                }
            }
        )
    }
}