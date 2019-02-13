package au.com.ultralogs.elliotwave.ui.rate.view

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import au.com.ultralogs.elliotwave.R
import au.com.ultralogs.elliotwave.ui.base.view.BaseDialogView
import au.com.ultralogs.elliotwave.ui.rate.interactor.RateUsMVPInterator
import au.com.ultralogs.elliotwave.ui.rate.presenter.RateUsMVPPresenter
import kotlinx.android.synthetic.main.dailog_rate.*
import javax.inject.Inject

/*
Rate us dialog for play store ratings
*/
class RateUsDialog : BaseDialogView(), RateUsMVPView {


    companion object {
        fun newInstance(): RateUsDialog? {
            return RateUsDialog()
        }

    }

    @Inject
    internal lateinit var presenter: RateUsMVPPresenter<RateUsMVPView, RateUsMVPInterator>

    private val TAG = "RateUsDialog"


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.dailog_rate, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onAttached(this)
        btnLater.setOnClickListener { presenter.onLaterOptionClicked() }
        btnSubmit.setOnClickListener { presenter.onSubmitOptionClicked() }
    }

    override fun onDestroyView() {
        presenter.onDetach()
        super.onDestroyView()
    }

    override fun dismissDialog() = super.dismissDialog(TAG)

    override fun showRatingSubmissionSuccessMessage() = Toast.makeText(context, getString(R.string.rating_submitted_successfully), Toast.LENGTH_LONG).show()

    internal fun show(fragmentManager: FragmentManager) = super.show(fragmentManager, TAG)
    override fun loadError(e: Throwable) {
    }

    override fun loadError(msg: String) {
    }
}