package au.com.ultralogs.elliotwave.ui.main.presenter

import au.com.ultralogs.elliotwave.ui.base.presenter.BasePresenter
import au.com.ultralogs.elliotwave.ui.main.interactor.MainMVPInteractor
import au.com.ultralogs.elliotwave.ui.main.view.MainMVPView
import au.com.ultralogs.elliotwave.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainPresenter<V : MainMVPView, I : MainMVPInteractor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), MainMVPPresenter<V, I> {
    override fun onAttached(view: V?) {
        super.onAttached(view)
        //getSampleData()
    }

    override fun onDrawerOptionRateUsClick() = getView()?.openRateUsDialog()
    override fun onDrawerOptionAboutClick() = getView()?.openAboutFragment()

    private fun getSampleData() = interactor.let {
        getView()?.let {
            it.addSomething()
        }
    }
}