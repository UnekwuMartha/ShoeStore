package com.udacity.shoestore

import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import kotlin.collections.ArrayList

class ShoesViewModel : ViewModel(), Observable {
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
        shoe = Shoe("", 0.0, "", "")
        _shoesList.value = ArrayList()
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("Not yet implemented")
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("Not yet implemented")
    }
}