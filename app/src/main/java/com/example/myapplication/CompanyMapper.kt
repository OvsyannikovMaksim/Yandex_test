package com.example.myapplication

class CompanyMapper : Mapper<CompanyInfoSrc, CompanyInfoDst> {

    private val url = "https://storage.googleapis.com/iex/api/logos/"
    private val ex = ".png"

    override fun map(data: CompanyInfoSrc) =
        CompanyInfoDst(data.companyName, data.symbol, url+data.symbol+ex, data.latestPrice,
            data.change, data.changePercent)
}