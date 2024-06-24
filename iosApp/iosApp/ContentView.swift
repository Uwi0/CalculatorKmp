import SwiftUI
import Shared

struct ContentView: View {
    let rows = Buttons()
    @StateObject private var viewModel = ObservableCalculatorViewModel()

    var body: some View {
        VStack(alignment: .trailing) {
            Spacer()
            Text(viewModel.state).font(.system(size: 80))
            ForEach(rows.buttons, id: \.self) { row in
                CalculatorButtonRow(buttons: row) { buttonTitle in
                    viewModel.updateState(newState: buttonTitle)
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
