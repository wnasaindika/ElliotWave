package au.com.ultralogs.elliotwave.ui.rate.presenter

import au.com.ultralogs.elliotwave.ui.base.presenter.BasePresenter
import au.com.ultralogs.elliotwave.ui.rate.interactor.RateUsMVPInterator
import au.com.ultralogs.elliotwave.ui.rate.view.RateUsMVPView
import au.com.ultralogs.elliotwave.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject
/*

*/
class RateUsPresenter<V : RateUsMVPView, I : RateUsMVPInterator> @Inject internal constructor(interator: I, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interator, schedulerProvider = schedulerProvider, compositeDisposable = compositeDisposable), RateUsMVPPresenter<V, I> {

    override fun onLaterOptionClicked() = getView()?.let { it.dismissDialog() }

    override fun onSubmitOptionClicked() = interactor?.let {
        it.submitRating()
        getView()?.let {
            it.showRatingSubmissionSuccessMessage()
            it.dismissDialog()
        }
    }
}