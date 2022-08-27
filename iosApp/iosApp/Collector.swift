//
//  Collector.swift
//  iosApp
//
//  Created by Humberto Martin on 27/8/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import shared

class Collector<T> : Kotlinx_coroutines_coreFlowCollector {
  let block:(T) -> Void

  init(block: @escaping (T) -> Void) {
    self.block = block
  }

  func emit(value: Any?) async throws {
    if let parsed = value as? T {
      block(parsed)
    }
  }
}
