package com.kaizuka.tenplus.compose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.kaizuka.tenplus.ui.theme.TenPlusTheme
import com.kaizuka.tenplus.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun StartScreen() {
    TenPlusTheme {
        SelectButtons()
    }
}

@Preview
@Composable
private fun TextView(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.app_name),
        modifier = modifier
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
private fun SelectButtons(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextView()
        StartButton()
        SettingsButton()

    }
}


@Preview
@Composable
private fun StartButton(
    modifier: Modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
) {
    Button(onClick = { { /*TODO*/ } }) {
        Text(text = stringResource(R.string.start))
    }
}

@Preview
@Composable
private fun SettingsButton(
    modifier: Modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
) {
    Button(onClick = { { /*TODO*/ } }) {
        Text(stringResource(R.string.select_settings))
    }
}