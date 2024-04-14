package com.example.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataViewModel: ViewModel() {
    val messageForActivity: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val messageForFragment1: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val messageForFragment2: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}