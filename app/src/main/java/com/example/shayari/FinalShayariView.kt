package com.example.shayari

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shayari.ui.theme.Pink80

@Composable
fun FinalShayriView(finalShayari: String) {
    Surface() {
        val context = LocalContext.current
        val clipboardManager: ClipboardManager = LocalClipboardManager.current
        var liked by remember {
            mutableStateOf(false)
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Pink80)
                .padding(top = 35.dp),
            contentAlignment = Alignment.Center
        ) {
            Column() {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    shape = RoundedCornerShape(15.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.Black),
                    border = BorderStroke(width = 3.dp, color = Color.White)
                ) {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(40.dp),
                            text = finalShayari,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Medium)
                        )
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Card(
                        modifier = Modifier
                            .padding(10.dp)
                            .size(50.dp, 42.dp)
                            .clickable {
                               liked = !liked
                            },
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        shape = RoundedCornerShape(100.dp)
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = if(liked)
                                {
                                    Icons.Filled.Favorite
                                }
                                else
                                {
                                    Icons.Outlined.FavoriteBorder
                                }, contentDescription = "Like", tint = Color.Red
                            )
                        }
                    }
                    Card(
                        modifier = Modifier
                            .padding(10.dp)
                            .size(50.dp, 42.dp)
                            .clickable {
                                val shareIntent = Intent(Intent.ACTION_SEND).apply {
                                    type = "text/plain"
                                    putExtra(Intent.EXTRA_TEXT, finalShayari)
                                }
                                context.startActivity(Intent.createChooser(shareIntent, null))
                            },
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        shape = RoundedCornerShape(100.dp)
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(imageVector = Icons.Default.Share, contentDescription = "copy")

                        }
                    }

                    Card(
                        modifier = Modifier
                            .padding(10.dp)
                            .size(50.dp, 42.dp)
                            .clickable {
                                clipboardManager.setText(
                                    androidx.compose.ui.text.AnnotatedString(
                                        finalShayari.toString()
                                    )
                                )
                                Toast
                                    .makeText(
                                        context,
                                        "Text Copied Successfully",
                                        Toast.LENGTH_SHORT
                                    )
                                    .show()
                            },
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        shape = RoundedCornerShape(100.dp)
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(imageVector = Icons.Default.CheckCircle, contentDescription = "share")

                        }
                    }
                }
            }
        }

    }
}

@Composable
@Preview
fun Preview() {
    FinalShayriView(
        finalShayari = "csfgcs s fhshfbhs sfghs bdywoiedhw fwhfin sfvyw;iohns cwylpown"

    )
}