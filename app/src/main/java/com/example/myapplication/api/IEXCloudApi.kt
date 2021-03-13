package com.example.myapplication.api

import com.example.myapplication.CompanyInfoSrc
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IEXCloudApi {

    @GET("stock/{symbol}/quote")
    fun getCompanyInfo(@Query("symbol") smbl: String,
                       @Query("token") api_token: String): Call<CompanyInfoSrc>

    @GET("stock/market/list/mostactive")
    fun getPopularCompany(@Query("token") api_token: String): Call<List<CompanyInfoSrc>>
}