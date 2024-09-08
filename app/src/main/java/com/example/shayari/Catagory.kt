package com.example.shayari

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.shayari.Model.Routing.ShayariRoutingItems
import com.example.shayari.ui.theme.Pink80
import com.example.shayari.ui.theme.Purple40

@Composable
fun Catagory(navHostController: NavHostController) {
    Surface() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Purple40)
                .padding(top = 35.dp, bottom = 35.dp)
        )
        {
            Column() {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(horizontal = 10.dp, vertical = 5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Card(
                        modifier = Modifier.size(45.dp).clickable {
                            navHostController.navigate("shayariAndQuote")
                        },
                        colors = CardDefaults.cardColors(Color.White),
                        shape = RoundedCornerShape(200.dp)
                    ) {
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 9.dp), contentAlignment = Alignment.Center) {
                            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "back")
                        }
                    }
                    Text(
                        text = "Shayari Category",
                        fontWeight = FontWeight.ExtraBold,
                        fontFamily = FontFamily.Serif,
                        fontSize = 28.sp,
                        modifier = Modifier.padding(start = 15.dp)
                    )
                }

                LazyColumn {
                    items(getList()) { item ->
                        Card(
                            shape = RoundedCornerShape(15.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(90.dp)
                                .padding(start = 10.dp, top = 30.dp, end = 10.dp)
                                .clickable {
                                    navHostController.navigate(ShayariRoutingItems.shayriListScreen.route + "/${item.title.toString()}")
                                },
                            colors = CardDefaults.cardColors(containerColor = Pink80),
                            border = BorderStroke(width = 1.dp, color = Color.White)
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            )
                            {
                                Text(
                                    text = item.title.toString(),
                                    color = Color.White,
                                    fontSize = 20.sp,
                                    fontFamily = FontFamily.Serif,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }

                    }
                }
            }

        }

    }

}