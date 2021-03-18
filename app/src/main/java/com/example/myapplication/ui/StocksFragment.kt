package com.example.myapplication.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.*
import com.example.myapplication.databinding.FragmentStocksBinding
import com.example.myapplication.network.Retrofit

class StocksFragment: Fragment() {

    private var binding: FragmentStocksBinding?=null
    private lateinit var stockViewModel: StockViewModel
    private lateinit var stockViewModelFactory: StockViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding= FragmentStocksBinding.inflate(inflater)
        val repo = CompanyRepoImpl(Retrofit.finHubApi)
        stockViewModelFactory=StockViewModelFactory(repo)
        return binding!!.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mLayout= GridLayoutManager(activity, 1,
            LinearLayoutManager.VERTICAL,false)
        stockViewModel =  ViewModelProvider(this, stockViewModelFactory).get(StockViewModel::class.java)
        val companies : LiveData<List<CompanyInfoDst>> = stockViewModel.res
        val companyAdapter = CompanyAdapter()
        companies.observe(viewLifecycleOwner, {res->
            Log.d("TAG", ""+res)
            companyAdapter.submitList(res)
            binding?.stocksRecyclerView?.adapter = companyAdapter
        })
        binding?.stocksRecyclerView?.layoutManager=mLayout
    }




    override fun onDestroyView() {
        super.onDestroyView()
        binding=null
        stockViewModel.clear()
    }


}