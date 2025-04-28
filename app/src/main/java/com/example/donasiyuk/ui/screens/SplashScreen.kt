package com.example.donasiyuk.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import com.example.donasiyuk.R

@Composable
fun SplashScreen(navController: NavController) {
    var logoVisible by remember { mutableStateOf(false) }
    var textVisible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        logoVisible = true
        delay(1200) // tunggu 1.2 detik biar user lihat logonya
        textVisible = true
        delay(1800) // lanjut ke login setelah 3 detik total
        navController.navigate("login") {
            popUpTo("splash") { inclusive = true }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnimatedVisibility(
                visible = logoVisible,
                enter = fadeIn(animationSpec = tween(durationMillis = 1000)),
                exit = fadeOut()
            ) {
                val scale by animateFloatAsState(
                    targetValue = if (logoVisible) 1f else 0.8f,
                    label = "Logo Scale Animation"
                )
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo Donasi Yuk",
                    modifier = Modifier
                        .size(250.dp)
                        .scale(scale)
                )
            }

            Spacer(modifier = Modifier.height(2.dp))

            AnimatedVisibility(
                visible = textVisible,
                enter = fadeIn() + slideInVertically(initialOffsetY = { it / 2 }) // naik dari bawah dikit
            ) {
                Text(
                    text = "Donasi Yuk",
                    fontSize = 28.sp,
                    color = Color(0xFF4CAF50),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

