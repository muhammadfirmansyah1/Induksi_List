package com.example.listlanguange

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.airbnb.lottie.model.content.ShapeTrimPath
import com.example.listlanguange.model.CustomeObject

class RecycleViewModel : ViewModel(){
    private var _customDialog = MutableLiveData<List<CustomeObject>>()
    val customDialog : LiveData<List<CustomeObject>>
        get() = _customDialog

    init {
        _customDialog.value = emptyList()
    }

    fun initList( list : List<CustomeObject>){
        _customDialog.value = list
    }

    fun increment(name : String, desc : String, link : String) {
        val newList = _customDialog.value!!.toMutableList()
        newList.add(CustomeObject(name,desc,link))
        _customDialog.value = newList
        Log.e("test", _customDialog.value.toString())
    }
}