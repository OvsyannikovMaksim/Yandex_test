package com.example.myapplication.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.myapplication.api.Retrofit
import com.example.myapplication.common.CompanyInfoDst
import com.example.myapplication.databinding.FragmentSearchBinding
import com.example.myapplication.db.DataBase
import com.example.myapplication.repository.CompanyRepoImpl
import com.example.myapplication.repository.LocalRepoImpl
import com.example.myapplication.viewmodel.SearchViewModel
import com.example.myapplication.viewmodel.SearchViewModelFactory

class SearchFragment: Fragment() {

    private var binding: FragmentSearchBinding?=null
    private lateinit var searchViewModel: SearchViewModel
    private lateinit var searchViewModelFactory: SearchViewModelFactory


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding= FragmentSearchBinding.inflate(inflater)
        val companyRepo = CompanyRepoImpl(Retrofit.finHubApi)
        val dataBase = DataBase.getDataBase(this.context!!)!!
        val localDao=dataBase.localDao()
        val localRepo = LocalRepoImpl(localDao)
        searchViewModelFactory= SearchViewModelFactory(companyRepo, localRepo)
        return binding!!.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchViewModel =  ViewModelProvider(this, searchViewModelFactory).get(SearchViewModel::class.java)
        val mLayout= StaggeredGridLayoutManager(2,LinearLayoutManager.HORIZONTAL)
        val gainers : LiveData<List<CompanyInfoDst>> = searchViewModel.gainersList
        val onlyNameAdapterGainers=CompanyOnlyNameAdapter()
        gainers.observe(viewLifecycleOwner, { res ->
            Log.d("SearchFragment", "Result of downloading $res")
            onlyNameAdapterGainers.submitList(res)
            binding?.gainersRecycler?.adapter = onlyNameAdapterGainers
        })
        binding?.gainersRecycler?.layoutManager=mLayout
    }
}