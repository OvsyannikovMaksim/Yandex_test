package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class StockViewModel( var companyRepo:CompanyRepo ): ViewModel() {

    lateinit var disposableStocks: Disposable
    lateinit var res: MutableLiveData<List<CompanyInfoSrc>>


    init{
        loadData()
    }


    private fun loadData(){
       disposableStocks=companyRepo.getPopularCompany()
               .subscribeOn(Schedulers.io())
               .subscribe{v->res.postValue(v)}


    }

    fun clear(){
        disposableStocks.dispose()
    }
}