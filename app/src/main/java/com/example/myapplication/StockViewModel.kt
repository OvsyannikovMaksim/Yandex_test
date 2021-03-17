package com.example.myapplication

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class StockViewModel(private var companyRepo:CompanyRepo): ViewModel() {

    private lateinit var disposableStocks: Disposable
    var res: MutableLiveData<List<CompanyInfoDst>> = MutableLiveData()
    private var mapper : CompanyMapper = CompanyMapper()


    init{
        loadData()
    }


    private fun loadData(){

        disposableStocks=companyRepo.getPopularCompany()
            .subscribeOn(Schedulers.io())
            .flatMapIterable{s -> s}
            .map{x->mapper.map(x)}
            .toList()
            .subscribe({v->res.postValue(v)},
                {error-> Log.d("StockViewModel","Error in downloading: "+error.message)})

    }

    fun clear(){
        disposableStocks.dispose()
    }
}