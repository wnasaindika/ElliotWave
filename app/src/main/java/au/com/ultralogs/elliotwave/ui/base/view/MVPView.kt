package au.com.ultralogs.elliotwave.ui.base.view

interface MVPView {
    //abstract fun showLoading()
    //abstract fun hideLoading()

    fun loadError(e: Throwable)
    fun loadError(msg: String)
    fun showProgress()
    fun hideProgress()
}