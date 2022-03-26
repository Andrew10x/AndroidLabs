package com.andrew10x.lab1kotlin2
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataModel: ViewModel() {

    val messageForChooseTrainFragment: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val messageForResOutputFragment: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}

