import SwiftUI
import ComposeApp

@MainActor
class IOSharedViewModel: ObservableObject {
    private let sharedViewModel = SharedViewModel()

    // Published property for SwiftUI to observe
    @Published var state: String = ""

    init() {
        // Start observing immediately
        Task {
            for await newState in sharedViewModel.state {
                self.state = newState
            }
        }
    }

    func updateMessage() {
        sharedViewModel.updateMessage()
    }
}

struct NativeWelcomeScreen: View {
    @StateObject private var viewModel = IOSharedViewModel()

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

                Text(viewModel.state)
                    .font(.headline)
                    .padding()
                    .background(Color.blue)
                    .foregroundColor(.white)
                    .cornerRadius(10)
                    .onTapGesture { viewModel.updateMessage() }
            }
            .navigationTitle("Native Welcome")
        }
    }
}