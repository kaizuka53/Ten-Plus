package com.kaizuka.tenplus.compose.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun ResultScreen(
    currentAnswer: Int,
    onRetryButtonClicked: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val userInput by remember { mutableStateOf(0) }
        Text(text = "結果！")

        Spacer(modifier = Modifier.height(16.dp))

        if (currentAnswer == 10) {
            Text(text = "正解！")
        } else {
            Text(text = "不正解！")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                onRetryButtonClicked()
            }
        ) {
            Text("reTry")
        }

    }
}