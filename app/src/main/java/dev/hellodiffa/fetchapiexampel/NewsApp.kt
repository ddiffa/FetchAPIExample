package dev.hellodiffa.fetchapiexampel

import android.app.Application
import dev.hellodiffa.fetchapiexampel.remote.ApiService
import dev.hellodiffa.fetchapiexampel.remote.NetworkConfig

class NewsApp : Application() {

    companion object{
        lateinit var api : ApiService
    }

    override fun onCreate() {
        super.onCreate()

        api = NetworkConfig.getRetrofit().create(ApiService::class.java)
    }
}