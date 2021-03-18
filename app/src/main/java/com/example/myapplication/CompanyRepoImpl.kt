package com.example.myapplication

import com.example.myapplication.api.IEXCloudApi
import io.reactivex.Flowable
import retrofit2.Call

class CompanyRepoImpl(private val api: IEXCloudApi) : CompanyRepo {

    private val API_KEY = "pk_e429838e00054002ace614e8e4d032d1"

    override fun getCompanyInfo(symbol: String): Flowable<CompanyInfoSrc> {
        return api.getCompanyInfo(symbol, API_KEY)
    }

    override fun getPopularCompany(): Flowable<List<CompanyInfoSrc>> {
        return api.getPopularCompany(API_KEY)
    }
}