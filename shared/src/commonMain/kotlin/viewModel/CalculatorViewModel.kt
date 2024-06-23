package viewModel

import androidx.lifecycle.ViewModel
import io.github.aakira.napier.Napier
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.koin.core.component.KoinComponent

open class CalculatorViewModel: ViewModel(), KoinComponent {
    
    val uiState: StateFlow<String> get() = _uiState.asStateFlow()
    private val _uiState: MutableStateFlow<String> = MutableStateFlow("")
    
    fun onClicked(button: String) {
        Napier.d("onclicked button $button")
    }
    
}

