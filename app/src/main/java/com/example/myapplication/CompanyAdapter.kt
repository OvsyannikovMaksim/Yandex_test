package com.example.myapplication

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.StockItemBinding

//private var mListener: IListener,
class CompanyAdapter(var mData: List<CompanyInfoDst>) :
        ListAdapter<CompanyInfoDst, CompanyAdapter.CompanyVH>(DiffCallback){

    private lateinit var binding: StockItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompanyVH {

        val inflater : LayoutInflater = LayoutInflater.from(parent.context)
        binding = StockItemBinding.inflate(inflater,parent, false)
        return CompanyVH(binding)

    }

    override fun onBindViewHolder(holder: CompanyVH, position: Int) {
        holder.bind(mData[position])
    }




    class CompanyVH (private var itemBinding: StockItemBinding):
        RecyclerView.ViewHolder(itemBinding.root){

        fun bind(companyInfo: CompanyInfoDst){
            Glide.with(itemView.context).load(Uri.parse(companyInfo.logo)).into(itemBinding.companyPic)
            itemBinding.companyName.text=companyInfo.name
            itemBinding.companyPrice.text=companyInfo.curPrice.toString()
            itemBinding.companyTicker.text=companyInfo.ticker
            itemBinding.companyPriceChange.text=companyInfo.priceChange.toString()
            itemBinding.companyPriceChangePercent.text=companyInfo.priceChangePercent.toString()
            if(companyInfo.priceChange>0.0){

                itemBinding.companyPriceChange.setTextColor(ContextCompat.getColor(itemView.context, R.color.green))
                itemBinding.companyPriceChangePercent.setTextColor(ContextCompat.getColor(itemView.context, R.color.green))

            }
            else{

                itemBinding.companyPriceChange.setTextColor(ContextCompat.getColor(itemView.context, R.color.red))
                itemBinding.companyPriceChangePercent.setTextColor(ContextCompat.getColor(itemView.context, R.color.red))

            }
        }
    }



    object DiffCallback : DiffUtil.ItemCallback<CompanyInfoDst>(){
        override fun areItemsTheSame(oldItem: CompanyInfoDst, newItem: CompanyInfoDst): Boolean {
            if(oldItem.name == newItem.name && oldItem.ticker == newItem.ticker){
                return true
            }
            return false
        }

        override fun areContentsTheSame(oldItem: CompanyInfoDst, newItem: CompanyInfoDst): Boolean {
            if(oldItem.curPrice==newItem.curPrice && oldItem.priceChange==newItem.priceChange &&
                oldItem.priceChangePercent==newItem.priceChangePercent ){
                return true
            }
            return false
        }

    }
}