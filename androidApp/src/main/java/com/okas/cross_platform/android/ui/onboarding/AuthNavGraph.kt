package com.okas.cross_platform.android.ui.onboarding

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.okas.cross_platform.android.ui.navigation.Graph
import com.okas.cross_platform.android.ui.onboarding.screen.BuildingSelectionScreen
import com.okas.cross_platform.android.ui.onboarding.screen.GetStartedScreen
import com.okas.cross_platform.android.ui.onboarding.screen.LoginScreen
import com.okas.cross_platform.android.ui.onboarding.screen.OtpVerificationScreen
import com.okas.cross_platform.android.ui.onboarding.screen.SplashScreen

fun NavGraphBuilder.authNavGraph(
    rootNavController: NavHostController,
    onNavigateToHome: () -> Unit,
) {
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreen.Splash.route
    ) {
        composable(AuthScreen.Splash.route) {
            SplashScreen(
                onNavigateToGetStarted = {
                    // Use rootNavController to navigate within the same graph
                    rootNavController.navigate(AuthScreen.GetStarted.route) {
                        popUpTo(AuthScreen.Splash.route) { inclusive = true }
                    }
                }
            )
        }

        composable(AuthScreen.GetStarted.route) {
            GetStartedScreen(onGetStartedClick = {
                rootNavController.navigate(AuthScreen.Login.route)
            })
        }

        composable(AuthScreen.Login.route) {
            LoginScreen(onOtpClick = {
                rootNavController.navigate(AuthScreen.Otp.route)
            })
        }

        composable(AuthScreen.Otp.route) {
            OtpVerificationScreen {
                rootNavController.navigate(AuthScreen.BuildingMember.route)
            }
        }

        composable(AuthScreen.BuildingMember.route) {
            BuildingSelectionScreen(buildings = emptyList()) {
                onNavigateToHome()
            }
        }
    }
}
