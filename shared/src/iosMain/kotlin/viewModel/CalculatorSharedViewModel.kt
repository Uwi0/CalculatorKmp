package viewModel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class CalculatorSharedViewModel {
    private val viewModel = CalculatorViewModel()
    private val scope: CoroutineScope = MainScope()
    
    val state: String get() = viewModel.uiState.value
    
    fun onClick(title: String) {
        viewModel.onClicked(title)
    }
    
    fun observeState(onStateChange: (String) -> Unit){
        scope.launch {
            viewModel.uiState.collect { onStateChange(it) }
        }
    }
}