package com.example.myapplication

import com.example.myapplication.api.IEXCloudApi
import retrofit2.Call

class CompanyRepoImpl(_api : IEXCloudApi) : CompanyRepo {

    private val API_KEY = ""
    private val api: IEXCloudApi = _api

    override fun getCompanyInfo(symbol: String): Call<CompanyInfoSrc> {
        return api.getCompanyInfo(symbol, API_KEY)
    }

    override fun getPopularCompany(): Call<List<CompanyInfoSrc>> {
        return api.getPopularCompany(API_KEY)
    }
}