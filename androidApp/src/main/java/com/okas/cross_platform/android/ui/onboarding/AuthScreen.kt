package com.okas.cross_platform.android.ui.onboarding

sealed class AuthScreen(val route: String) {
    data object Splash : AuthScreen("splash")
    data object GetStarted : AuthScreen("getStarted")
    data object Login : AuthScreen("login")
    data object Otp : AuthScreen("otp")
    data object BuildingMember : AuthScreen("buildingMember")
}