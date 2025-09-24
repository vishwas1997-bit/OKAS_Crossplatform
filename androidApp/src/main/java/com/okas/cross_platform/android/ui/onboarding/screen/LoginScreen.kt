package com.okas.cross_platform.android.ui.onboarding.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.okas.cross_platform.android.R
import com.okas.cross_platform.android.ui.onboarding.component.topBorder

@Composable
fun LoginScreen(
    onOtpClick: () -> Unit = {},
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg_new_onboarding_png),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .matchParentSize()
                .blur(20.dp)
        )
        Column(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.BottomCenter)

        ) {
            // 🔹 Logo
            Image(
                painter = painterResource(id = R.drawable.okas_logo_horizontal),
                contentDescription = "Logo",
                colorFilter = ColorFilter.tint(Color.White),
                modifier = Modifier
                    .padding(16.dp)
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
                    modifier = Modifier
                        .wrapContentSize()
                ) {

                    Spacer(modifier = Modifier.height(16.dp))

                    // 🔹 Title
                    Text(
                        text = stringResource(R.string.log_in),
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                        fontSize = 22.sp,
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.proxima_nova_semibold))
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // 🔹 Subtitle
                    Text(
                        text = stringResource(R.string.enter_your_phone_number_or_email),
                        fontSize = 12.sp,
                        modifier = Modifier.padding(horizontal = 16.dp),
                        color = Color.White.copy(alpha = 0.8f),
                        fontFamily = FontFamily(Font(R.font.proxima_nova_light))
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    // 🔹 Tabs (Email / Phone)
                    var selectedTab by remember { mutableStateOf(0) }
                    val tabs = listOf(
                        stringResource(R.string.email_address),
                        stringResource(R.string.phone_number)
                    )


                    TabRow(
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .clip(RoundedCornerShape(16.dp)),
                        selectedTabIndex = selectedTab,
                        containerColor = Color(0x26FFFFFF),
                        indicator = { tabPositions ->
                            // Custom indicator with rounded background
                            Box(
                                modifier = Modifier
                                    .tabIndicatorOffset(tabPositions[selectedTab])
                                    .fillMaxHeight()
                                    .background(
                                        color = Color.Blue, // selected tab color
                                        shape = RoundedCornerShape(16.dp)
                                    )
                            )
                        },
                        divider = {}
                    ) {
                        tabs.forEachIndexed { index, title ->
                            Tab(
                                selected = selectedTab == index,
                                onClick = { selectedTab = index },
                                text = { Text(title, color = Color.White) }
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    if (selectedTab == 0) {
                        TextField(
                            value = "",
                            onValueChange = {},
                            placeholder = { Text(stringResource(R.string.email_address)) },
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(R.drawable.ic_email),
                                    contentDescription = null
                                )
                            },
                            singleLine = true,
                            textStyle = TextStyle(
                                fontFamily = FontFamily(Font(R.font.proxima_nova_light)),
                                fontSize = 16.sp
                            ),
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.Transparent,
                                unfocusedContainerColor = Color.Transparent,
                                disabledContainerColor = Color.Transparent,
                                errorContainerColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                disabledIndicatorColor = Color.Transparent,
                                errorIndicatorColor = Color.Transparent
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp) // margin
                                .background(
                                    color = Color.White.copy(alpha = 0.8f),
                                    shape = RoundedCornerShape(16.dp)
                                )
                        )
                    } else {
                        // 🔹 Phone Number Row
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp)
                        ) {
                            // Replace CountryCodePicker with your own dropdown (Compose doesn’t support CCP directly)
                            Text(
                                text = "+91",
                                modifier = Modifier
                                    .background(
                                        Color.White.copy(alpha = 0.8f),
                                        RoundedCornerShape(8.dp)
                                    )
                                    .padding(16.dp),
                                color = Color.White
                            )

                            Spacer(modifier = Modifier.width(20.dp))

                            TextField(
                                value = "",
                                onValueChange = {},
                                placeholder = { Text("Phone number") },
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                                singleLine = true,
                                modifier = Modifier
                                    .weight(1f)
                                    .background(
                                        Color.White.copy(alpha = 0.8f),
                                        RoundedCornerShape(16.dp)
                                    ),
                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = Color.Transparent,
                                    unfocusedContainerColor = Color.Transparent,
                                    disabledContainerColor = Color.Transparent,
                                    errorContainerColor = Color.Transparent,
                                    focusedIndicatorColor = Color.Transparent,
                                    unfocusedIndicatorColor = Color.Transparent,
                                    disabledIndicatorColor = Color.Transparent,
                                    errorIndicatorColor = Color.Transparent
                                ),
                                textStyle = TextStyle(
                                    fontFamily = FontFamily(Font(R.font.proxima_nova_light)),
                                    fontSize = 16.sp
                                )
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(120.dp))

                    // 🔹 Checkbox + Terms
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    ) {
                        var checked by remember { mutableStateOf(false) }
                        Box(
                            modifier = Modifier
                                .size(32.dp)
                                .background(Color.White.copy(alpha = 0.1f), CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Checkbox(
                                checked = checked,
                                onCheckedChange = { checked = it },
                                colors = CheckboxDefaults.colors(
                                    checkedColor = Color.White,
                                    uncheckedColor = Color.Transparent,
                                    checkmarkColor = Color.Black
                                )
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Please agree to the terms of service.",
                            fontSize = 14.sp,
                            color = Color.White,
                            fontFamily = FontFamily(Font(R.font.proxima_nova_regular))
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    // 🔹 Button
                    Button(
                        onClick = onOtpClick,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 32.dp, start = 16.dp, end = 16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                            contentColor = Color(0xFF0F6774)
                        ),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.get_otp),
                            fontSize = 20.sp,
                            color = Color(0XFF0F6774),
                            fontFamily = FontFamily(Font(R.font.proxima_nova_semibold))
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun Prev() {
    LoginScreen()
}