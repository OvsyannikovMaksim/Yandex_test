package com.example.myapplication.ui

import android.content.Context
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
import com.example.myapplication.IListener
import com.example.myapplication.api.Retrofit
import com.example.myapplication.common.CompanyInfoDst
import com.example.myapplication.databinding.FragmentStocksBinding
import com.example.myapplication.db.DataBase
import com.example.myapplication.repository.CompanyRepoImpl
import com.example.myapplication.repository.LocalRepoImpl
import com.example.myapplication.viewmodel.StockViewModel
import com.example.myapplication.viewmodel.StockViewModelFactory


class StocksFragment: Fragment() {

    private var binding: FragmentStocksBinding?=null
    private lateinit var stockViewModel: StockViewModel
    private lateinit var stockViewModelFactory: StockViewModelFactory
    var mListener: IListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (requireActivity() is IListener) {
            mListener = requireActivity() as IListener
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding= FragmentStocksBinding.inflate(inflater)
        val companyRepo = CompanyRepoImpl(Retrofit.finHubApi)
        val dataBase = DataBase.getDataBase(this.context!!)!!
        val favCompDao=dataBase.favoriteCompanyDao()
        val localRepo = LocalRepoImpl(favCompDao)
        stockViewModelFactory= StockViewModelFactory(companyRepo, localRepo)
        return binding!!.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mLayout= GridLayoutManager(activity, 1,
                LinearLayoutManager.VERTICAL, false)
        stockViewModel =  ViewModelProvider(this, stockViewModelFactory).get(StockViewModel::class.java)
        val companies : LiveData<List<CompanyInfoDst>> = stockViewModel.companyList
        val companyAdapter = CompanyAdapter(ClickChecker())
        companies.observe(viewLifecycleOwner, { res ->
            Log.d("TAG", "" + res)
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


    inner class ClickChecker : IListener{
        override fun pressButtonFavorite(bool: Boolean, ticker: String) {
            stockViewModel.pressButtonFavorite(bool, ticker)
        }

    }
}