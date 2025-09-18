package com.okas.cross_platform.android.onboarding

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.okas.cross_platform.android.navigation.Graph
import com.okas.cross_platform.android.onboarding.screen.SplashScreen

fun NavGraphBuilder.authNavGraph(rootNavController: NavHostController) {
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreen.Splash.route
    ) {
        composable(AuthScreen.Splash.route) {
            SplashScreen(

            )
        }
        composable(AuthScreen.GetStarted.route) {
//            GetStartedScreen(
//                onLoginClick = { rootNavController.navigate(AuthScreen.Login.route) }
//            )
        }
        composable(AuthScreen.Login.route) {
//            LoginScreen(
//                onOtpNavigate = { rootNavController.navigate(AuthScreen.Otp.route) }
//            )
        }
        composable(AuthScreen.Otp.route) {
//            OtpScreen(
//                onBuildingMemberNavigate = {
//                    rootNavController.navigate(AuthScreen.BuildingMember.route) {
//                        popUpTo(AuthScreen.Login.route) { inclusive = false }
//                    }
//                }
//            )
        }
        composable(AuthScreen.BuildingMember.route) {
//            BuildingMemberScreen(
//                onAuthFinished = {
//                    // Move to Home graph
//                    rootNavController.navigate(Graph.HOME) {
//                        popUpTo(Graph.AUTH) { inclusive = true }
//                    }
//                }
//            )
        }
    }
}
