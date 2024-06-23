import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.androidx.compose.koinViewModel
import viewModel.CalculatorViewModel

@Composable
@Preview
fun App() {
    MaterialTheme {
        CalculatorScreen()
    }
}

@Composable
private fun CalculatorScreen() {
    val viewModel = koinViewModel<CalculatorViewModel>()
    Column {
        val buttons = Buttons()
        buttons.buttons.forEach { column ->
            CalculatorButtonRow(column){
                viewModel.onClicked(it)
            }
        }
    }
}

@Composable
private fun CalculatorButtonRow(buttons: List<String>, onClick: (String) -> Unit) {
    Row{
        buttons.forEach { title ->
            CalculatorButton(title, onClick = onClick)
        }
    }
}

@Composable
private fun CalculatorButton(title: String, onClick: (String) -> Unit) {
    Button(onClick = {onClick.invoke(title)}) {
        Text(title)
    }
}