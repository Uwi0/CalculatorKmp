package viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.koin.core.component.KoinComponent

open class CalculatorViewModel: ViewModel(), KoinComponent {
    
    val uiState: StateFlow<String> get() = _uiState.asStateFlow()
    private val _uiState: MutableStateFlow<String> = MutableStateFlow("0")
    
    private var firstOperand: Double? = null
    private var secondOperand: Double? = null
    private var operation: String? = null

    fun onButtonPress(button: String) {
        when (button) {
            "C" -> clear()
            "±" -> toggleSign()
            "%" -> applyPercentage()
            "÷", "×", "-", "+" -> setOperation(button)
            "=" -> calculateResult()
            else -> appendDigit(button)
        }
    }

    private fun clear() {
        _uiState.update { "0"}
        firstOperand = null
        secondOperand = null
        operation = null
    }

    private fun toggleSign() {
        _uiState.update{
            (uiState.value.toDoubleOrNull()?.times(-1)).toString()
        }
    }

    private fun applyPercentage() {
        _uiState.update{  (_uiState.value.toDoubleOrNull()?.div(100)).toString()}
    }

    private fun setOperation(op: String) {
        firstOperand = uiState.value.toDoubleOrNull()
        operation = op
        _uiState.update { "0" }
    }

    private fun calculateResult() {
        secondOperand = uiState.value.toDoubleOrNull()
        if (firstOperand != null && secondOperand != null && operation != null) {
            val result = when (operation) {
                "÷" -> firstOperand!! / secondOperand!!
                "×" -> firstOperand!! * secondOperand!!
                "-" -> firstOperand!! - secondOperand!!
                "+" -> firstOperand!! + secondOperand!!
                else -> return
            }
            _uiState.update { result.toString() }
            firstOperand = null
            secondOperand = null
            operation = null
        }
    }

    private fun appendDigit(digit: String) {
        if (uiState.value == "0" && digit != ".") {
            _uiState.update { digit }
        } else {
            _uiState.update { it + digit }
        }
    }
}

