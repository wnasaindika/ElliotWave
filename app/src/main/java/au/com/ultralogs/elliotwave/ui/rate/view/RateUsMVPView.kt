package au.com.ultralogs.elliotwave.ui.rate.view

import au.com.ultralogs.elliotwave.ui.base.view.MVPView

interface RateUsMVPView : MVPView{
    fun dismissDialog()
    fun showRatingSubmissionSuccessMessage()
}