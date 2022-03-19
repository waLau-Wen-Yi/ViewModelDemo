package com.example.viewmodeldemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Student(): ViewModel() {
    /*
    var id:String = "W1234"
    var name:String = "Ah Beng"
    */
    var id = MutableLiveData<Int>()
    var name = MutableLiveData<String>()
    var subject = MutableLiveData<Int>()
}