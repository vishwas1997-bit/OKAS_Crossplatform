package com.okas.cross_platform.android.ui.onboarding.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.okas.cross_platform.android.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onNavigateToGetStarted: ()-> Unit) {
    LaunchedEffect(Unit) {
        delay(1000)
        onNavigateToGetStarted()
    }

    Box(modifier = Modifier.fillMaxSize()) {
        // background image
        Image(
            painter = painterResource(R.drawable.bg_new_onboarding_png),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // place logo ~88% down the screen using Spacer weights
        Column(modifier = Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.weight(0.90f))
            Image(
                painter = painterResource(R.drawable.okas_logo_horizontal),
                contentDescription = "Logo",
                colorFilter = ColorFilter.tint(Color.White),
                modifier = Modifier
                    .wrapContentSize()
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.weight(0.10f))
        }
    }
}
