package com.example.myapplication.repository

import com.example.myapplication.common.CompanyInfoSrc
import com.example.myapplication.api.IEXCloudApi
import io.reactivex.Flowable

class CompanyRepoImpl(private val api: IEXCloudApi) : CompanyRepo {

    private val API_KEY = "sk_0949065ff216429480ccb4bb61510c12"

    override fun getCompanyInfo(ticker: String): Flowable<CompanyInfoSrc> {
        return api.getCompanyInfo(ticker, API_KEY)
    }

    override fun getPopularCompany(): Flowable<List<CompanyInfoSrc>> {
        return api.getPopularCompany(API_KEY)
    }
}