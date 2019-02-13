package au.com.ultralogs.elliotwave.ui.base.presenter

import au.com.ultralogs.elliotwave.ui.base.intreractor.MVPInteractor
import au.com.ultralogs.elliotwave.ui.base.view.MVPView
import au.com.ultralogs.elliotwave.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

/* base presenter which carries views and other apps operations */
open class BasePresenter<V : MVPView, I : MVPInteractor> internal constructor(protected var interactor: I?, protected val schedulerProvider: SchedulerProvider, protected val compositeDisposable: CompositeDisposable) : MVPPresenter<V, I> {


    private var view1: V? = null
    private val isViewAttached: Boolean get() = view1 != null

    override fun onAttached(view: V?) {
        this.view1 = view
    }

    override fun onDetach() {
        compositeDisposable.dispose()
        view1 = null
        interactor = null
    }

    override fun getView(): V? = view1
}