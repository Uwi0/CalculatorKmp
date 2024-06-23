import SwiftUI
import Shared

struct ContentView: View {
    let rows = Buttons()

    @State private var displayText: String = "0"

    var body: some View {
        VStack(alignment: .trailing) {
            Spacer()
            Text(displayText).font(.system(size: 80))
            ForEach(rows.buttons, id: \.self) { row in
                CalculatorButtonRow(buttons: row) { buttonTitle in

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
