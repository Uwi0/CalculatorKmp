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
                    .background(Color.orange)
                    .foregroundStyle(.white)
                    .cornerRadius(buttonSize)
            }
        )
    }
    
    private func widthForButton(title: String) -> CGFloat {
        title == "0" ? 170 : 80
    }
}

