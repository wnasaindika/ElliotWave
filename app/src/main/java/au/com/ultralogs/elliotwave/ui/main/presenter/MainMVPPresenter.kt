package au.com.ultralogs.elliotwave.ui.main.presenter

import au.com.ultralogs.elliotwave.ui.base.presenter.MVPPresenter
import au.com.ultralogs.elliotwave.ui.main.interactor.MainMVPInteractor
import au.com.ultralogs.elliotwave.ui.main.view.MainMVPView

interface MainMVPPresenter<V : MainMVPView, I : MainMVPInteractor> : MVPPresenter<V, I> {
    fun onDrawerOptionAboutClick() : Unit?
    fun onDrawerOptionRateUsClick(): Unit?
}