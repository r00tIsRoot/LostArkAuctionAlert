package com.isroot.lostarkauctionalert

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.isroot.lostarkauctionalert.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
        return ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
    }
}