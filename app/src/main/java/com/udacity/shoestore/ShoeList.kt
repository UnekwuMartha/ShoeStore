package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.udacity.shoestore.R
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeItemBinding

class ShoeList : Fragment() {
    private val viewModel: ShoesViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)

        observe(inflater, container)
        navigate()

        return binding.root
    }

    private fun observe(inflater: LayoutInflater, container: ViewGroup?) {
        viewModel.shoesList.observe(viewLifecycleOwner) { shoesList ->
            for (shoe in shoesList) {
                val shoeItem: ShoeItemBinding =
                    DataBindingUtil.inflate(inflater, R.layout.shoe_item, container, false)
                shoeItem.shoe = shoe
                binding.shoeListLinearLayout.addView(shoeItem.root)
            }
        }
        setHasOptionsMenu(true)
    }

    private fun navigate() {
        viewModel.resetShoe()
        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(ShoeListDirections.actionShoeListToShoeDetail())
        }
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) : Boolean {
        return when (item.itemId) {
            R.id.menu -> {
                findNavController().navigate(ShoeListDirections.actionShoeListToLogin())
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}