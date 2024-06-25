import SwiftUI
import Shared

struct ContentView: View {
    let buttons = Buttons()
    @StateObject private var viewModel = ObservableCalculatorViewModel()
    private let screenWidth = UIScreen.main.bounds.width - 5 * 12

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
