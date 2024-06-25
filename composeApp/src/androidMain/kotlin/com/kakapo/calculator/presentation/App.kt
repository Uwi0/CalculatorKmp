import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
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
    val configuration = LocalConfiguration.current
    val uiState by viewModel.uiState.collectAsState()
    val screenWidth = (configuration.screenWidthDp - 5 * 12) / 4

    Column(
        modifier = Modifier.fillMaxSize().padding(bottom = 24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val buttons = Buttons()

        Spacer(Modifier.weight(1f))
        Text(modifier = Modifier.align(Alignment.End).padding(end = 12.dp), text = uiState, style = MaterialTheme.typography.h3)
        Spacer(modifier = Modifier.size(12.dp))
        buttons.buttons.forEach { column ->
            CalculatorButtonRow(screenWidth.dp,column) {
                viewModel.onButtonPress(it)
            }
        }
    }
}

@Composable
private fun CalculatorButtonRow(size: Dp,buttons: List<String>, onClick: (String) -> Unit) {
    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        buttons.forEach { title ->
            CalculatorButton(size, title, onClick)
        }
    }
}

@Composable
private fun CalculatorButton(
    size: Dp,
    title: String,
    onClick: (String) -> Unit
) {
    Button(
        modifier = Modifier.size(size = size),
        shape = RoundedCornerShape(size = size / 4),
        onClick = { onClick.invoke(title) },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFFC9830))
    ) {
        Text(title, color = Color.White, style = MaterialTheme.typography.h4)
    }
}