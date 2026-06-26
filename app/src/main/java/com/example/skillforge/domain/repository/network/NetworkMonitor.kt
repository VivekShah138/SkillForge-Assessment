package com.example.skillforge.domain.repository.network

import com.example.skillforge.domain.model.NetworkStatus
import kotlinx.coroutines.flow.Flow

interface NetworkMonitor {
    fun observeNetwork(): Flow<NetworkStatus>
}