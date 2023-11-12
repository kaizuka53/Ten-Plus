import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun PlayScreen(
    modifier: Modifier = Modifier,
    onCheckButtonClicked: (Int) -> Unit
) {
    var userInput by remember { mutableStateOf(0) }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "与えられた数字を使って10を作ろう！")

        Spacer(modifier = Modifier.height(16.dp))

        BasicTextField(
            value = userInput.toString(),
            onValueChange = { newValue ->
                val parsedValue = newValue.toIntOrNull()
                if (parsedValue != null) {
                    userInput = parsedValue
                }
            },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                onCheckButtonClicked(userInput)
                result = "チェックボタンが押されました"
            }
        ) {
            Text("チェック")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = result)
    }
}

fun evaluateExpression(numbers: List<Int>, target: Int): Boolean {
    // 与えられた四つの数字を使って10を作る評価ロジックを実装
    // この部分をあなたのゲームのルールに合わせて実装してください
    // 例: バックトラッキング、全ての組み合わせの試行、等
    return false // 10を作れない場合はfalseを返す
}

@Preview
@Composable
fun GameScreenPreview() {
    PlayScreen(
        onCheckButtonClicked = { /*TODO*/ }
    )
}
