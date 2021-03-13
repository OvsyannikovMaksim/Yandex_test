package com.example.myapplication.api

import com.example.myapplication.CompanyInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FinHubApi {

    @GET("/stock/profile2")
    fun getCompanyInfo(@Query("symbol") smbl: String,
                       @Query("token") api_token: String): Call<CompanyInfo>

    @GET("/quote")
    fun getCompanyQuoteInfo(@Query("symbol") smbl: String,
                            @Query("token") api_token: String): Call<CompanyInfo>
}