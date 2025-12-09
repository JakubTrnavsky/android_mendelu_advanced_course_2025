
import SwiftUI
import ComposeApp

struct NativeWelcomeScreen: View {
    var body: some View {
        NavigationView {
            VStack {
                NavigationLink(destination: ContentView()) {
                    Text("Go to KMP Compose Screen")
                        .font(.headline)
                        .padding()
                        .background(Color.blue)
                        .foregroundColor(.white)
                        .cornerRadius(10)
                }

            }
            .navigationTitle("Native Welcome")
        }
    }
}
