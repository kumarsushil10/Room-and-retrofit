package com.kmrsushil.myapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.kmrsushil.myapp.R
import com.kmrsushil.myapp.databinding.FragmentDetailBinding
import com.kmrsushil.myapp.model.MyDataModelItem


class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val args:DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.titleTv.text = args.myData.title
        binding.detailTv.text = args.myData.body


    }

}