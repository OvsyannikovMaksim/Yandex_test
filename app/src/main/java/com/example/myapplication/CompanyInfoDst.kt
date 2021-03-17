package com.example.myapplication

data class CompanyInfoDst(val name: String, val ticker: String, val logo: String,
                          val curPrice: Double, val priceChange: Double,
                          val priceChangePercent: Double)