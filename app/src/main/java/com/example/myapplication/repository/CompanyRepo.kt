package com.example.myapplication.repository

import com.example.myapplication.common.CompanyInfoSrc
import io.reactivex.Flowable

interface CompanyRepo {

    fun getCompanyInfo(ticker:String): Flowable<CompanyInfoSrc>
    fun getPopularCompany(): Flowable<List<CompanyInfoSrc>>
    fun getGainersCompany(): Flowable<List<CompanyInfoSrc>>
    fun doSearch(fragment:String): Flowable<List<CompanyInfoSrc>>
}