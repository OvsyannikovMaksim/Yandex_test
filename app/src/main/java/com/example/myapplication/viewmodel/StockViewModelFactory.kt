package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.repository.CompanyRepo

class StockViewModelFactory(private val companyRepo: CompanyRepo) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StockViewModel::class.java)) {
            return StockViewModel(companyRepo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }


}