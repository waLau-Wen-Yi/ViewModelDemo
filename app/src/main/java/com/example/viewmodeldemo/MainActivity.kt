package com.example.viewmodeldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodeldemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val student = ViewModelProvider(this).get(Student::class.java)
        student.id.observe(this, Observer { newValue ->
            binding.tvStudId.text = newValue.toString()
        }) //set owner to "ViewLifeCycleOwner" if it applied on fragment

        student.name.observe(this, Observer { newValue ->
            binding.tvStudName.text = newValue
        }) //set owner to "ViewLifeCycleOwner" if it applied on fragment

        student.subject.observe(this, Observer { newValue ->
            binding.tvSubject.text = newValue.toString()
        }) //set owner to "ViewLifeCycleOwner" if it applied on fragment

        /*
        binding.btnOk.setOnClickListener {
            binding.tvStudId.text = student.id
            binding.tvStudName.text = student.name
        }
        */

        binding.btnSet.setOnClickListener {
            student.id.value = 12345
            student.name.value = "Ah Yes"
            student.subject.value = 0
        }

        binding.btnIncrease.setOnClickListener {
            student.subject.value = student.subject.value?.plus(1)
            //student.subject.value = student.subject.value!! + 1
        }
    }
}