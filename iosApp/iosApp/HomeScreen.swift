//
//  HomeScreen.swift
//  iosApp
//
//  Created by Humberto Martin on 27/8/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct HomeScreen: View {
    @State private var state: HomeState
    
    private let viewModel: HomeViewModel
    private let onNext: () -> Void
    
    init(
        viewModel: HomeViewModel,
        onNext: @escaping () -> Void
    ) {
        self.viewModel = viewModel
        self.onNext = onNext
        self.state = viewModel.state.value as! HomeState
    }
    
    var body: some View {
        List {
            Text("Counter: \(state.counter)")
            Button("Next") { viewModel.onNextClicked() }
        }
        .onAppear {
            viewModel.state.collect(collector: Collector<HomeState> { state in
                self.state = state
                self.state.navigateToNext?.consume { _ in onNext() }
            }) { error in print("Error ocurred during state collection") }
        }
    }
}
