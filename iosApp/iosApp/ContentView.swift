import SwiftUI
import Shared

struct ContentView: View {
    let rows = Buttons()

    @StateObject var viewModelStoreOwner = SharedViewModelStoreOwner<CalculatorViewModel>()
    @State private var displayText: String = "0"
    @State private var viewModel = CalculatorViewModel()

    var body: some View {
        VStack {
            Text(viewModel.uiState.value).font(.system(size: 80))
            Spacer(minLength: 24)
            ForEach(rows.buttons, id: \.self) { row in
                CalculatorButtonRow(buttons: row) { buttonTitle in
                    viewModel.onClicked(button: buttonTitle)
                }
            }

        }.padding()
    }
}


struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
