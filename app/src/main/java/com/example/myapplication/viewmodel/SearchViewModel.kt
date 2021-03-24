package com.example.myapplication.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.load.resource.gif.GifBitmapProvider
import com.example.myapplication.common.CompanyInfoDst
import com.example.myapplication.repository.CompanyRepo
import com.example.myapplication.repository.LocalRepo
import com.example.myapplication.util.CompanyMapper
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class SearchViewModel(private var companyRepo: CompanyRepo, private var localRepo: LocalRepo):ViewModel() {

    private lateinit var disposableGainers: Disposable
    var gainersList: MutableLiveData<List<CompanyInfoDst>> = MutableLiveData()
    private var mapper : CompanyMapper = CompanyMapper()

    init{
        loadData()
    }


    private fun loadData() {
        disposableGainers=companyRepo.getGainersCompany()
                .subscribeOn(Schedulers.io())
                .flatMapIterable {s->s}
                .map{s->mapper.map(s)}
                .toList()
                .subscribe({ v -> gainersList.postValue(v)},
                        { error -> Log.d("SearchViewModel", "Error in downloading: " + error.message) })
    }

    fun clear(){
        disposableGainers.dispose()
    }
}