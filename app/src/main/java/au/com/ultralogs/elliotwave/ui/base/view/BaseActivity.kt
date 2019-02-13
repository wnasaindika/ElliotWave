package au.com.ultralogs.elliotwave.ui.base.view

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import au.com.ultralogs.elliotwave.util.CommonUtils
import dagger.android.AndroidInjection

/*
* Generic class for all activities
* Implementing this class automatically inherit
*/
abstract class BaseActivity : AppCompatActivity(), MVPView, BaseFragment.CallBack {

    private var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDI()
    }

    override fun hideProgress() {
        progressDialog?.let { if (it.isShowing) it.cancel() }
    }

    override fun showProgress() {
        hideProgress()
        progressDialog = CommonUtils.showLoadingDialog(this)
    }

    private fun performDI() = AndroidInjection.inject(this)
}
