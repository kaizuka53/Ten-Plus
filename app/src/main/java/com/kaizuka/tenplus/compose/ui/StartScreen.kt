package com.kaizuka.tenplus.compose.ui

import PlayScreen
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kaizuka.tenplus.R
import com.kaizuka.tenplus.ui.theme.TenPlusTheme

enum class StartScreen() {
    Start,
    Play,
    Result,
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TenPlusApp() {
    val navigationController = rememberNavController()


    NavHost(
        navController = navigationController,
        startDestination = StartScreen.Start.name,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(StartScreen.Start.name) {
            SelectButtons(
                onStartSelected = {
                    navigationController.navigate(StartScreen.Play.name)
                },
                onSettingsSelected = {

                }
            )
        }

        composable(StartScreen.Play.name) {
            PlayScreen(onCheckButtonClicked = {
                navigationController.navigate(StartScreen.Result.name)
            })
        }
        composable(StartScreen.Result.name) {
            ResultScreen(
                currentAnswer = 10,
                onRetryButtonClicked = {
                    navigationController.popBackStack(StartScreen.Play.name, inclusive = false)
                }
            )
        }

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
private fun SelectButtons(
    modifier: Modifier = Modifier,
    onStartSelected: () -> Unit,
    onSettingsSelected: () -> Unit
) {
    TenPlusTheme() {


        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextView()
            StartButton(onStartSelected = onStartSelected)
            SettingsButton(onSettingsSelected = onSettingsSelected)
        }
    }
}

@Composable
private fun StartButton(
    modifier: Modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center),
    onStartSelected: () -> Unit
) {
    Button(onClick = { onStartSelected() }) {
        Text(text = stringResource(R.string.start))
    }
}

@Composable
private fun SettingsButton(
    modifier: Modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center),
    onSettingsSelected: () -> Unit
) {
    Button(onClick = { onSettingsSelected() }) {
        Text(stringResource(R.string.select_settings))
    }
}