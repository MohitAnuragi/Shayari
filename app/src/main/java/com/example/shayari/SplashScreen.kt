package com.example.shayari

import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.shayari.Model.Routing.ShayariRoutingItems
import com.example.shayari.ui.theme.Pink40
import com.example.shayari.ui.theme.Purple40
import com.example.shayari.ui.theme.Purple80

@Composable
fun SplashScreen(navHostController: NavHostController) {
    Surface {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Purple40)
        )
        {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center)
            {
                Column {
                    Text(text = "SHAYARI",
                        fontSize = 30.sp,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.ExtraBold

                    )
                    Text(text = "& QUOTES",
                        fontSize = 30.sp,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.ExtraBold

                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 50.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.size(35.dp),
                    strokeWidth = 4.dp,
                    color = Purple80
                )
            }
            Handler(Looper.getMainLooper()).postDelayed(Runnable {
                navHostController.navigate(ShayariRoutingItems.shayariAndQuotes.route)
            },3000
            )

        }
    }
}

