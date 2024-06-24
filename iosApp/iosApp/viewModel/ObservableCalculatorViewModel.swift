import SwiftUI
import Shared

class ObservableCalculatorViewModel: ObservableObject {
    private var viewModel: CalculatorSharedViewModel
    
    @Published var state: String = "0"
    
    init() {
        self.viewModel = CalculatorSharedViewModel()
        self.viewModel.observeState { [weak self] newState in 
            DispatchQueue.main.async {
                self?.state = newState
            }
        }
    }
    
    func updateState(newState: String) {
        viewModel.onClick(title: newState)
    }
}