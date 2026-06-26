package com.example.skillforge.domain.usecase.local

import com.example.skillforge.domain.model.NetworkStatus
import com.example.skillforge.domain.repository.network.NetworkMonitor
import kotlinx.coroutines.flow.Flow

class NetworkMonitorLocalUseCase(
    private val networkMonitor: NetworkMonitor
) {
    operator fun invoke(): Flow<NetworkStatus>{
        return networkMonitor.observeNetwork()
    }
}