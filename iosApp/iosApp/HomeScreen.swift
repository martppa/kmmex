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
    @ObservedObject private var state: ObservableHomeState
    
    private let viewModel: HomeViewModel
    private let onNext: () -> Void
    
    init(
        viewModel: HomeViewModel,
        onNext: @escaping () -> Void
    ) {
        self.viewModel = viewModel
        self.onNext = onNext
        self.state = viewModel.observableState()
        observeState()
    }
    
    private func observeState() {
        viewModel.state.collect(
            collector: Collector<HomeState> { state in onStateReceived(state: state) }
        ) { error in
            print("Error ocurred during state collection")
        }
    }
    
    private func onStateReceived(state: HomeState) {
        self.state.value = state
        self.state.value.navigateToNext?.consume { _ in onNext() }
    }
    
    var body: some View {
        List {
            Text("Counter: \(state.value.counter)")
            Button("Next") { viewModel.onNextClicked() }
        }
    }
}

extension HomeViewModel {
    func observableState() -> ObservableHomeState {
        return (state.value as! HomeState).wrapAsObservable()
    }
}
