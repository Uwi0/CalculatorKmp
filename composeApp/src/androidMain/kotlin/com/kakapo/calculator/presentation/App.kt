import androidx.compose.foundation.background
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
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize().padding(bottom = 24.dp).background(Color.Black),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val buttons = Buttons()
        Spacer(Modifier.weight(1f))
        Text(modifier = Modifier.align(Alignment.End).padding(end = 12.dp), text = uiState, style = MaterialTheme.typography.h3, color = Color.White)
        Spacer(modifier = Modifier.size(12.dp))
        buttons.buttons.forEach { column ->
            CalculatorButtonRow(column) {
                viewModel.onButtonPress(it)
            }
        }
    }
}

@Composable
private fun CalculatorButtonRow(buttons: List<String>, onClick: (String) -> Unit) {
    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        buttons.forEach { title ->
            CalculatorButton(title, onClick)
        }
    }
}

@Composable
private fun CalculatorButton(
    title: String,
    onClick: (String) -> Unit
) {
    val buttonSize = if(title == "0") 170.dp else 80.dp
    Button(
        modifier = Modifier.size(width = buttonSize, height = 80.dp),
        shape = RoundedCornerShape(180.dp),
        onClick = { onClick.invoke(title) },
        colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor(title))
    ) {
        Text(title, color = Color.White, style = MaterialTheme.typography.h4)
    }
}

fun buttonColor(key: String): Color {
    val LightGray = Color(0xFFD4D4D2)
    val DarkLiver = Color(0xFF505050)
    val VividGamboge = Color(0xFFFF9500)
    val buttonColors = mapOf(
        "C" to LightGray, "±" to LightGray, "%" to LightGray, "÷" to VividGamboge,
        "×" to VividGamboge, "-" to VividGamboge, "+" to VividGamboge, "=" to VividGamboge,
        "0" to DarkLiver, "1" to DarkLiver, "2" to DarkLiver, "3" to DarkLiver,
        "4" to DarkLiver, "5" to DarkLiver, "6" to DarkLiver, "7" to DarkLiver,
        "8" to DarkLiver, "9" to DarkLiver, "." to DarkLiver
    )

    return buttonColors[key] ?: Color.Gray
}