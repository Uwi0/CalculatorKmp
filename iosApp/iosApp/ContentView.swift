import SwiftUI
import Shared

struct ContentView: View {
    let buttons = Buttons()
    @StateObject private var viewModel = ObservableCalculatorViewModel()

    var body: some View {
        VStack(alignment: .trailing) {
            Spacer()
            Text(viewModel.state)
                .font(.largeTitle)
                .padding()
                .frame(maxWidth: .infinity, alignment: .trailing)
                .background(Color.black)
                .foregroundColor(.white)

            ForEach(buttons.buttons, id: \.self) { columns in
                HStack {
                    ForEach(columns, id: \.self) { rows in
                        CalculatorButton(buttonLable: rows) { title in
                            viewModel.updateState(newState: title)
                        }
                    }
                }
            }

        }
        .padding()
        .background(Color.black.edgesIgnoringSafeArea(.all))
    }
}


struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
