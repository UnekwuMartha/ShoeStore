package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import kotlin.collections.ArrayList

//view model class
class ShoesViewModel : ViewModel() {
    //null check on object shoe of type Shoe
    var shoe: Shoe? = null

    //create shoes variable to hold list of shoes
    private var shoes = mutableListOf<Shoe>()

    //shoe list to add new shoes
    private var _shoesList = MutableLiveData<List<Shoe>>()
    val shoesList: LiveData<List<Shoe>>
        get() = _shoesList

    //add shoe function to add new shoes to shoelist
    fun addShoe() {
        shoe?.let { shoe ->
            shoes.add(shoe)
            _shoesList.value = shoes
        }
    }

    //set shoe object to empty
    fun resetShoe() {
        shoe = Shoe("", 0.0, "", "")
    }
}