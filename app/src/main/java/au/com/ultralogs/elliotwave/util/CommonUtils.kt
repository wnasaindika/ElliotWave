package au.com.ultralogs.elliotwave.util

import android.app.ProgressDialog
import android.content.Context
import au.com.ultralogs.elliotwave.R
//common utilities goes here
object CommonUtils {
    fun showLoadingDialog(context: Context?): ProgressDialog {
        val progressDialog = ProgressDialog(context)
        progressDialog.let {
            it.show()
            //it.window?.setBackgroundDrawable(Color.TRANSPARENT.to)
            it.setContentView(R.layout.progress_dialog)
            it.isIndeterminate = true
            it.setCancelable(false)
            it.setCanceledOnTouchOutside(false)
            return it
        }
    }
}