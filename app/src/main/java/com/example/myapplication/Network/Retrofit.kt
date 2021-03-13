package com.example.myapplication.Network

import com.example.myapplication.api.FinHubApi

object Retrofit{

    private val BASE_URL = "https://finnhub.io/api/v1"
    val finHubApi: FinHubApi
        get() = RetrofitClient.getClient(BASE_URL).create(FinHubApi::class.java)

}