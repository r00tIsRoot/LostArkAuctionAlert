package com.isroot.lostarkauctionalert

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil

abstract class BaseActivity : AppCompatActivity() {
    protected var binding: Any? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayoutResource())
    }

    protected abstract fun getLayoutResource(): Int

//    fun closeDialog(baseDialog: BaseDialog?) {
//        if (baseDialog != null && baseDialog.isShowing()) baseDialog.dismiss()
//    }
//
//    fun closeDialog(baseDialogFragment: BaseDialogFragment?) {
//        if (baseDialogFragment != null && baseDialogFragment.getDialog() != null && baseDialogFragment.getDialog()
//                .isShowing()
//            && !baseDialogFragment.isRemoving()
//        ) {
//            baseDialogFragment.dismiss()
//        }
//    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}