package com.isroot.lostarkauctionalert.main

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.isroot.lostarkauctionalert.BaseActivity
import com.isroot.lostarkauctionalert.R
import com.isroot.lostarkauctionalert.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpMVVM()
    }

    override fun getLayoutResource(): Int {
        return R.layout.activity_main
    }

    private fun setUpMVVM() {
        binding = binding as ActivityMainBinding
        viewModel = obtainViewModel()
        (binding as ActivityMainBinding).lifecycleOwner = this
        (binding as ActivityMainBinding).viewModel = viewModel

    }

    private fun obtainViewModel(): MainViewModel {
        val viewModelFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(
            application
        )
        return ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
    }
}