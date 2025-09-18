package com.okas.cross_platform.android.onboarding

sealed class AuthScreen(val route: String) {
    object Splash : AuthScreen("splash")
    object GetStarted : AuthScreen("getStarted")
    object Login : AuthScreen("login")
    object Otp : AuthScreen("otp")
    object BuildingMember : AuthScreen("buildingMember")
}