package com.okas.cross_platform.android.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.okas.cross_platform.android.onboarding.authNavGraph

@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Graph.AUTH
    ) {
        authNavGraph(navController)
    }
}