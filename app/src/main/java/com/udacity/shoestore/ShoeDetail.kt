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

        //declare and initialize binding object to use shoe detail binding, and inflate the correct layout
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)

        //set fragment lifecycle owner
        binding.lifecycleOwner = this

        //set view model to get data from
        binding.shoesViewModel = viewModel

        //set save button to navigate to correct fragment and implement addShoe method
        binding.save.setOnClickListener {
            viewModel.addShoe()
            findNavController().navigate(ShoeDetailDirections.actionShoeDetailToShoeList())
        }

        //set cancel button to navigate to correct fragment
        binding.cancel.setOnClickListener {
            findNavController().navigate(ShoeDetailDirections.actionShoeDetailToShoeList())
        }
        return binding.root
    }

}