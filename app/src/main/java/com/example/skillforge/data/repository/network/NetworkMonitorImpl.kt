package com.example.skillforge.data.repository.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.skillforge.domain.model.NetworkStatus
import com.example.skillforge.domain.repository.network.NetworkMonitor
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class NetworkMonitorImpl(
    private val context: Context
): NetworkMonitor {

    private val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager


    override fun observeNetwork(): Flow<NetworkStatus> = callbackFlow {

        val activeNetwork = connectivityManager.activeNetwork
        val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork)

        if (capabilities != null &&
            capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        ) {
            trySend(NetworkStatus.Available)
        } else {
            trySend(NetworkStatus.Lost)
        }

        val callback = object : ConnectivityManager.NetworkCallback() {

            override fun onAvailable(network: Network) {
                trySend(NetworkStatus.Available)
            }

            override fun onLost(network: Network) {
                trySend(NetworkStatus.Lost)
            }

            override fun onUnavailable() {
                trySend(NetworkStatus.Unavailable)
            }

            override fun onLosing(network: Network, maxMsToLive: Int) {
                trySend(NetworkStatus.Losing)
            }
        }

        connectivityManager.registerDefaultNetworkCallback(callback)

        awaitClose {
            connectivityManager.unregisterNetworkCallback(callback)
        }
    }
}