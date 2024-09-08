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
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.shayari.Model.Routing.ShayariRoutingItems
import com.example.shayari.ui.theme.Pink80
import com.example.shayari.ui.theme.Purple40
import com.example.shayari.ui.theme.Purple80
import com.example.shayari.ui.theme.PurpleGrey80

@Composable
fun QuoteListItem(navHostController: NavHostController? = null, value: String?) {
    Surface() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Purple40)
                .padding(top = 35.dp, bottom = 35.dp)
        ) {
            Column() {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(horizontal = 10.dp, vertical = 5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Card(
                        modifier = Modifier
                            .size(45.dp)
                            .clickable {
                                navHostController?.navigate("quote")
                            },
                        colors = CardDefaults.cardColors(Color.White),
                        shape = RoundedCornerShape(200.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 9.dp), contentAlignment = Alignment.Center
                        ) {
                            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "back")
                        }
                    }
                    if (value != null) {
                        Text(
                            text = value,
                            fontWeight = FontWeight.ExtraBold,
                            fontFamily = FontFamily.Serif,
                            fontSize = 28.sp,
                            modifier = Modifier.padding(start = 15.dp)
                        )
                    }
                }

                val myQuoteList = getQuoteList().filter {
                    it.value == value.toString()
                }
                val quoteList = myQuoteList[0]
                quoteList.listValue?.let { list ->
                    LazyColumn {
                        items(list) { item ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 15.dp, top = 15.dp, end = 15.dp)
                                    .clickable {
                                        navHostController?.navigate(ShayariRoutingItems.finalShayriScreen.route + "/$item")
                                    },
                                shape = RoundedCornerShape(20.dp),
                                colors = CardDefaults.cardColors(containerColor = Color.Black),
                                border = BorderStroke(width = 2.dp, color = Color.White)
                            )
                            {
                                Text(
                                    text = item,
                                    color = Color.White,
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(30.dp),
                                    textAlign = TextAlign.Center,
                                    style = TextStyle(
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Medium
                                    )
                                )
                            }
                        }

                    }

                }

            }
        }
    }
}

//@Composable
//@Preview
//fun PreviewI() {
//    ShayariListItem(title = "Love")
//}