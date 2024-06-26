package com.example.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.fragment.databinding.Fragment2Binding

class Fragment2 : Fragment(R.layout.fragment2) {
    private val dataViewModel: DataViewModel by activityViewModels()
    private lateinit var binding: Fragment2Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment2Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataViewModel.messageForFragment2.observe(activity as LifecycleOwner, {
            binding.textView1.text = it
        })

        binding.button1.setOnClickListener {
            dataViewModel.messageForActivity.value = "Hello activity from fragment 2"
        }
        binding.button2.setOnClickListener {
            dataViewModel.messageForFragment1.value = "Hello from fragment 2"
        }
    }
}