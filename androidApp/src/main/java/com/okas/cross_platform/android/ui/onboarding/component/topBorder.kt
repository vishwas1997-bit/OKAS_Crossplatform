package com.okas.cross_platform.android.ui.onboarding.component

import android.annotation.SuppressLint
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@SuppressLint("SuspiciousModifierThen")
fun Modifier.topBorder(
    stroke: Dp = 1.dp,
    color: Color = Color.Gray,
    cornerRadius: Dp = 16.dp,
) = this.then(
    drawBehind {
        val strokeWidth = stroke.toPx()
        val topLeftRadius = cornerRadius.toPx()
        val topRightRadius = cornerRadius.toPx()

        val path = Path().apply {
            // Start at bottom-left of top border
            moveTo(0f, 0f)
            // Top-left corner
            arcTo(
                rect = Rect(0f, 0f, topLeftRadius * 2, topLeftRadius * 2),
                startAngleDegrees = 180f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )
            // Top edge
            lineTo(size.width - topRightRadius, 0f)
            // Top-right corner
            arcTo(
                rect = Rect(size.width - 2 * topRightRadius, 0f, size.width, topRightRadius * 2),
                startAngleDegrees = 270f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )
        }

        drawPath(
            path = path,
            color = color,
            style = Stroke(width = strokeWidth)
        )
    }
)