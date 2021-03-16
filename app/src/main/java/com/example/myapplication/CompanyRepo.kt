package com.example.myapplication

import io.reactivex.Flowable

interface CompanyRepo {

    fun getCompanyInfo(symbol:String): Flowable<CompanyInfoSrc>
    fun getPopularCompany(): Flowable<List<CompanyInfoSrc>>
}