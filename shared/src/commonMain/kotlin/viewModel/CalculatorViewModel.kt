package viewModel

import androidx.lifecycle.ViewModel
import io.github.aakira.napier.Napier
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.koin.core.component.KoinComponent

open class CalculatorViewModel: ViewModel(), KoinComponent {
    
    val uiState: StateFlow<String> get() = _uiState.asStateFlow()
    private val _uiState: MutableStateFlow<String> = MutableStateFlow("0")
    
    private var currentExpression = ""
    private var number1: String = ""
    private var number2: String = ""

    fun onClicked(button: String) {
        if(button.isOperator()){
            currentExpression = button
        } else if(button != "="){
            _uiState.update { button }
            if (number1 == "") {
                number1 = button
            } else {
                number2 = button
            }
        } else {
            val result = calculateNumber()
            _uiState.update { "$result" }
        }
    }


    private fun String.isOperator(): Boolean {
        return this in listOf("+", "-", "×", "÷")
    }

    fun calculateNumber(): Int {
        val converttedNumber1 = number1.toInt()
        val convertedNumber2 = number2.toInt()
        return when(currentExpression) {
            "+" -> converttedNumber1 + convertedNumber2
            "-" -> converttedNumber1 - convertedNumber2
            "×" -> converttedNumber1 * convertedNumber2
            "÷" -> converttedNumber1 / convertedNumber2
            else -> error("Unsupported operator")
        }
    }
}

