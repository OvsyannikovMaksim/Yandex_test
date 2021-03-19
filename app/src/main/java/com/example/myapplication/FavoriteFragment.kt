package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentFavoriteBinding

class FavoriteFragment: Fragment() {

    private var binding: FragmentFavoriteBinding?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding= FragmentFavoriteBinding.inflate(inflater)
        return binding!!.root
    }
}