package com.example.myapplication.repository

import com.example.myapplication.common.CompanyInfoSrc
import io.reactivex.Flowable

interface CompanyRepo {

    fun getCompanyInfo(symbol:String): Flowable<CompanyInfoSrc>
    fun getPopularCompany(): Flowable<List<CompanyInfoSrc>>
}