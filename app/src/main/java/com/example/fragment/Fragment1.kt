package com.example.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.fragment.databinding.Fragment1Binding

class Fragment1 : Fragment(R.layout.fragment1) {
    private val dataViewModel: DataViewModel by activityViewModels()
    private lateinit var binding: Fragment1Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment1Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataViewModel.messageForFragment1.observe(activity as LifecycleOwner, {
            binding.textView1.text = it
        })
        binding.button1.setOnClickListener {
            dataViewModel.messageForActivity.value = "Hello activity from fragment 1"
        }
        binding.button2.setOnClickListener {
            dataViewModel.messageForFragment2.value = "Hello from fragment 1"
        }
    }
}