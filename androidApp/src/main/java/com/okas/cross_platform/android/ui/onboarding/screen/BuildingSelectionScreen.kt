package com.okas.cross_platform.android.ui.onboarding.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.okas.cross_platform.android.R
import com.okas.cross_platform.android.ui.onboarding.component.topBorder

@Composable
fun BuildingSelectionScreen(
    buildings: List<String>, // your data
    onSubmitClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Background image
        Image(
            painter = painterResource(id = R.drawable.bg_new_onboarding_png),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.7f)
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.okas_logo_horizontal),
                contentDescription = "Logo",
                modifier = Modifier
                    .padding(24.dp)
                    .sizeIn(maxHeight = 64.dp),
                colorFilter = ColorFilter.tint(Color.White)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
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
                        .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                        .background(Color.White.copy(alpha = 0.1f))
                        .blur(20.dp)
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp)
                )
                {
                    Text(
                        text = stringResource(id = R.string.choose_your_building),
                        fontSize = 22.sp,
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.proxima_nova_semibold))
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = stringResource(id = R.string.pick_a_building_to_start_managing_your_devices),
                        color = Color.White.copy(alpha = 0.8f),
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.proxima_nova_regular))
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // RecyclerView -> LazyColumn
                    LazyColumn(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                    ) {
                        items(buildings) { building ->
                            BuildingItem(buildingName = building)
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = onSubmitClick,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White
                        )
                    ) {
                        Text(
                            text = "Submit",
                            fontSize = 20.sp,
                            color = Color(0xFF0F6774),
                            fontFamily = FontFamily(Font(R.font.proxima_nova_semibold))
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))
                }
            }
        }
    }
}

@Composable
fun BuildingItem(buildingName: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White.copy(alpha = 0.2f))
            .padding(16.dp)
    ) {
        Text(
            text = buildingName,
            color = Color.White,
            fontSize = 18.sp,
            fontFamily = FontFamily(Font(R.font.proxima_nova_regular))
        )
    }
}

@Composable
@Preview
fun PreviewBuildingSelectionScreen() {
    BuildingSelectionScreen(buildings = emptyList())
}
