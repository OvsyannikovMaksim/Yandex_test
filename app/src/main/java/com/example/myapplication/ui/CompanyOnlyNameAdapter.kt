package com.example.myapplication.ui

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.IListener
import com.example.myapplication.R
import com.example.myapplication.common.CompanyInfoDst
import com.example.myapplication.databinding.NameItemBinding
import com.example.myapplication.databinding.StockItemBinding

//private var mListener: IListener,
class CompanyOnlyNameAdapter() :
        ListAdapter<CompanyInfoDst, CompanyOnlyNameAdapter.CompanyVH>(DiffCallback){

    private lateinit var binding: NameItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompanyVH {

        val inflater : LayoutInflater = LayoutInflater.from(parent.context)
        binding = NameItemBinding.inflate(inflater,parent, false)
        return CompanyVH(binding)

    }

    override fun onBindViewHolder(holder: CompanyVH, position: Int) {
        holder.bind(currentList[position])
    }




    class CompanyVH (private var itemBinding: NameItemBinding):
            RecyclerView.ViewHolder(itemBinding.root){

        fun bind(companyInfo: CompanyInfoDst){
            itemBinding.companyNameNameItem.text=companyInfo.name
        }

    }



    object DiffCallback : DiffUtil.ItemCallback<CompanyInfoDst>(){
        override fun areItemsTheSame(oldItem: CompanyInfoDst, newItem: CompanyInfoDst): Boolean {
            if(oldItem.name == newItem.name){
                return true
            }
            return false
        }

        override fun areContentsTheSame(oldItem: CompanyInfoDst, newItem: CompanyInfoDst): Boolean {
            if(oldItem.name == newItem.name){
                return true
            }
            return false
        }

    }

}