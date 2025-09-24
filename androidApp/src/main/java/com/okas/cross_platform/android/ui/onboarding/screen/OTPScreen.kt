package com.okas.cross_platform.android.ui.onboarding.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.okas.cross_platform.android.R
import com.okas.cross_platform.android.ui.onboarding.component.topBorder

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OtpVerificationScreen(
    onContinueClick: () -> Unit = {}
) {
    Box(modifier = Modifier.fillMaxSize()) {
        // 🔹 Background Image
        Image(
            painter = painterResource(R.drawable.bg_new_onboarding_png),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.BottomCenter)
        ) {
            // 🔹 Logo
            Image(
                painter = painterResource(R.drawable.okas_logo_horizontal),
                contentDescription = "Logo",
                modifier = Modifier
                    .padding(16.dp)
                    .sizeIn(maxWidth = 200.dp),
                colorFilter = ColorFilter.tint(Color.White)
            )

            Box(
                modifier = Modifier
                    .wrapContentSize()
                    .topBorder(stroke = 1.dp, color = Color(0XFFDDDDDD), cornerRadius = 24.dp)
                    .clip(
                        RoundedCornerShape(
                            topEnd = 24.dp,
                            topStart = 24.dp,
                            bottomStart = 0.dp,
                            bottomEnd = 0.dp
                        )
                    )
            ) {
                Box(
                    modifier = Modifier
                        .matchParentSize()
                        .blur(100.dp)
                        .background(Color.White.copy(alpha = 0.10f))
                )
                Column(
                    modifier = Modifier.wrapContentSize().padding(horizontal = 16.dp, vertical = 8.dp),
                ) {
                    // Title
                    Text(
                        text = stringResource(R.string.otp_verification),
                        fontSize = 22.sp,
                        fontFamily = FontFamily(Font(R.font.proxima_nova_semibold)),
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    // Subtitle
                    Text(
                        text = stringResource(R.string.we_ve_sent_a_verification_code),
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.proxima_nova_light)),
                        color = Color.White.copy(alpha = 0.8f)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // OTP Boxes Row
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        repeat(6) { index ->
                            var otp by remember { mutableStateOf("") }
                            TextField(
                                value = otp,
                                onValueChange = {
                                    if (it.length <= 1) otp = it
                                },
                                singleLine = true,
                                textStyle = TextStyle(
                                    fontSize = 20.sp,
                                    textAlign = TextAlign.Center
                                ),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                modifier = Modifier
                                    .width(48.dp)
                                    .height(56.dp)
                                    .background(
                                        color = Color.White.copy(alpha = 0.2f),
                                        shape = RoundedCornerShape(8.dp)
                                    ),
                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = Color.Transparent,
                                    unfocusedContainerColor = Color.Transparent,
                                    focusedIndicatorColor = Color.Transparent,
                                    unfocusedIndicatorColor = Color.Transparent
                                )
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Resend text + Timer
                    Row {
                        Text(
                            text = "Resend OTP in",
                            fontFamily = FontFamily(Font(R.font.proxima_nova_regular)),
                            color = Color.White.copy(alpha = 0.8f)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "01:00",
                            fontFamily = FontFamily(Font(R.font.proxima_nova_regular)),
                            color = Color.White.copy(alpha = 0.8f)
                        )
                    }

                    Spacer(modifier = Modifier.height(32.dp))

                    // Continue Button
                    Button(
                        onClick = {
                            onContinueClick()
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                            contentColor = Color(0xFF0F6774)
                        ),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.continue_button),
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.proxima_nova_semibold))
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewOtpVerificationScreen() {
    OtpVerificationScreen()
}