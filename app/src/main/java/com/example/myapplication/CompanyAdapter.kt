package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView


val diffCallback = object : DiffUtil.ItemCallback<CompanyInfoDst>() {
    override fun areItemsTheSame(oldItem: CompanyInfoDst, newItem: CompanyInfoDst): Boolean {
        TODO("Not yet implemented")
    }

    override fun areContentsTheSame(oldItem: CompanyInfoDst, newItem: CompanyInfoDst): Boolean {
        TODO("Not yet implemented")
    }
}


class CompanyAdapter : ListAdapter<CompanyInfoDst, CompanyVH>(diffCallback){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompanyVH {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CompanyVH, position: Int) {
        TODO("Not yet implemented")
    }

}

class CompanyVH (itemView: View): RecyclerView.ViewHolder(itemView){


}
