import SwiftUI

struct CalculatorButton: View {
    let buttonLable: String
    let action: (String) -> Void

    var body: some View {
        let buttonSize: CGFloat = widthForButton(title: buttonLable)
        Button(
            action: { action(buttonLable) },
            label: {
                Text(buttonLable)
                    .font(.title)
                    .frame(width: buttonSize, height: 80)
                    .background(buttonColor(buttonLable))
                    .foregroundStyle(.white)
                    .cornerRadius(buttonSize)
            }
        )
    }
    
    private func widthForButton(title: String) -> CGFloat {
        title == "0" ? 170 : 80
    }

    private func buttonColor(_ key: String) -> Color {
        let lightGray = Color(hex: "#D4D4D2") ?? .gray
        let darkLiver = Color(hex: "#505050") ?? .gray
        let vividGamboge = Color(hex: "#FF9500") ?? .gray

        let buttonColors: [String: Color] = [
            "C": lightGray, "±": lightGray, "%": lightGray, "/": vividGamboge,
            "*": vividGamboge, "-": vividGamboge, "+": vividGamboge, "=": vividGamboge,
            "0": darkLiver, "1": darkLiver, "2": darkLiver, "3": darkLiver,
            "4": darkLiver, "5": darkLiver, "6": darkLiver, "7": darkLiver,
            "8": darkLiver, "9": darkLiver, ".": darkLiver
        ]

        return buttonColors[key] ?? .gray
    }
}

