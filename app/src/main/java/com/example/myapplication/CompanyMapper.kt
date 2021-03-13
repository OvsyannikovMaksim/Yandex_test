package com.example.myapplication

class CompanyMapper : Mapper<CompanyInfoSrc, CompanyInfoDst> {

    override fun map(data: CompanyInfoSrc) =
        CompanyInfoDst(data.name,data.ticker, data.logo, data.c, data.o-data.c,
            (data.o-data.c)*100/data.c)
}