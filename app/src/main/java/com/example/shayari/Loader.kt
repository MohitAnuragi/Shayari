package com.example.shayari

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun Loader() {
    val degree = produceState(initialValue = 0) {
        while (true) {
            delay(800)
            value = (value + 8) % 360
        }
    }
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize(),
        content = {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    imageVector = Icons.Filled.Refresh, contentDescription = "Refresh",
                    modifier = Modifier
                        .size(60.dp)
                        .rotate(degree.value.toFloat())
                )
                Text(text = "Loading...")
            }
        }


    )

}
@Composable
@Preview
fun DefaultPr(){
    Loader()
}

