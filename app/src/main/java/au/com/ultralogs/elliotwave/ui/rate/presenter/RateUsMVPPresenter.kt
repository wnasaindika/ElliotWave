package au.com.ultralogs.elliotwave.ui.rate.presenter

import au.com.ultralogs.elliotwave.ui.base.presenter.MVPPresenter
import au.com.ultralogs.elliotwave.ui.rate.interactor.RateUsMVPInterator
import au.com.ultralogs.elliotwave.ui.rate.view.RateUsMVPView

interface RateUsMVPPresenter <V : RateUsMVPView, I : RateUsMVPInterator> : MVPPresenter<V, I>{
    fun onLaterOptionClicked() : Unit?
    fun onSubmitOptionClicked() : Unit?
}