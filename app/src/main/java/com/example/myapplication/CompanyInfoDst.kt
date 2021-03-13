package com.example.myapplication

data class CompanyInfoDst(val name: String, val ticker: String, val logo: String,
                          val cur_price: Double, val price_change: Double,
                          val price_change_percent: Double)