package au.com.ultralogs.elliotwave.ui.base.presenter

import au.com.ultralogs.elliotwave.ui.base.intreractor.MVPInteractor
import au.com.ultralogs.elliotwave.ui.base.view.MVPView

interface MVPPresenter<V : MVPView, I : MVPInteractor> {
    fun onAttached(view: V?)
    fun onDetach()
    fun getView(): V?
}