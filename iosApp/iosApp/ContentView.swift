import SwiftUI
import shared

private let WifiRoute = "wifi"

struct ContentView: View {
    @State private var route = [String]()
    
    var body: some View {
        NavigationStack(path: $route) {
            HomeScreen(
                viewModel: HomeViewModel(),
                onNext: { route.append(WifiRoute) }
            )
        }.navigationDestination(for: String.self) { destination in
            switch (destination) {
            case WifiRoute:
                WifiScreen()
            default:
                Text("None")
            }
        }
    }
}
