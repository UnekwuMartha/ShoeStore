package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding

class ShoeDetail : Fragment() {
    private val viewModel: ShoesViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)

        binding.lifecycleOwner = this
        binding.shoesViewModel = viewModel

        binding.save.setOnClickListener {
            viewModel.addShoe()
            findNavController().navigate(shoeDetailDirections.actionShoeDetailToShoeList())
        }
        binding.cancel.setOnClickListener {
            findNavController().navigate(shoeDetailDirections.actionShoeDetailToShoeList())
        }
        return binding.root
    }

}

    private fun setView() {
        TODO("Not yet implemented")
    }
