//
//  ObservableHomeState.swift
//  iosApp
//
//  Created by Humberto Martin on 12/9/22.
//  Copyright © 2022 Madapp. All rights reserved.
//

import shared

class ObservableHomeState : ObservableObject {
    @Published var value: HomeState
    
    init(value: HomeState) {
        self.value = value
    }
}

extension HomeState {
    func wrapAsObservable() -> ObservableHomeState {
        return ObservableHomeState(value: self)
    }
}


