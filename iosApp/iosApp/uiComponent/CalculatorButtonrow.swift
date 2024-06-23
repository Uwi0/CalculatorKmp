import SwiftUI

struct CalculatorButtonRow: View {

    let buttons: [String]
    let action: (String) -> Void
    let buttonSize = (UIScreen.main.bounds.width - 5 * 12) / 4

    var body: some View {
        HStack(spacing: 12) {
            ForEach(buttons, id: \.self) { buttonLable in
                Button(
                    action: { action(buttonLable) },
                    label: {
                        Text(buttonLable)
                            .font(.title)
                            .frame(width: buttonSize, height: buttonSize)
                            .background(Color.orange)
                            .foregroundStyle(.white)
                            .cornerRadius(buttonSize / 4)
                    }
                )
            }
        }
    }
}