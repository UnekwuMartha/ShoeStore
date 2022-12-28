package com.udacity.shoestore

import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import kotlin.collections.ArrayList

class ShoesViewModel : ViewModel() {
    var shoe: Shoe? = null
    private var shoes = mutableListOf<Shoe>()
    private var _shoesList = MutableLiveData<List<Shoe>>()
    val shoesList: LiveData<List<Shoe>>
        get() = _shoesList

    fun addShoe() {
        shoe?.let { shoe ->
            shoes.add(shoe)
            _shoesList.value = shoes
        }
    }

    init {
        _shoesList.value = ArrayList()
    }

    fun resetShoe(){shoe = Shoe("", 0.0, "", "")}
}