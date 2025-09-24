package com.okas.cross_platform.android.ui.onboarding.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter

import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.okas.cross_platform.android.R


@Composable
fun GetStartedScreen(
    onGetStartedClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.bg_new_onboarding_png),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier.height(80.dp))

            // Logo
            Image(
                painter = painterResource(id = R.drawable.okas_logo_vertical),
                contentDescription = "Logo",
                modifier = Modifier
                    .wrapContentSize()
                    .padding(top = 40.dp),
                colorFilter = ColorFilter.tint(Color.White)
            )

            // Text
            Text(
                text = stringResource(id = R.string.welcome_to_experience_control_with_exclusivity),
                fontFamily = FontFamily(Font(R.font.proxima_nova_light)),
                fontSize = 18.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 32.dp)
                    .fillMaxWidth(0.9f)
            )

            // Button
            Button(
                onClick = onGetStartedClick,
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(bottom = 32.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.get_started),
                    fontFamily = FontFamily(Font(R.font.proxima_nova_regular)),
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
