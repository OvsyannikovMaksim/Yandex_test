package com.example.myapplication

import retrofit2.Call

interface CompanyRepo {

    fun getCompanyInfo(symbol:String): Call<CompanyInfoSrc>
    fun getPopularCompany():Call<List<CompanyInfoSrc>>
}