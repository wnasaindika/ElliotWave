package au.com.ultralogs.elliotwave.ui.rate.interactor

import au.com.ultralogs.elliotwave.data.network.ApiHelper
import au.com.ultralogs.elliotwave.data.preferance.PreferenceHelper
import au.com.ultralogs.elliotwave.ui.base.intreractor.BaseInteractor
import javax.inject.Inject

class RateUsInteractor @Inject internal constructor(apiHelper: ApiHelper, preferenceHelper: PreferenceHelper) : BaseInteractor(apiHelper = apiHelper, preferenceHelper = preferenceHelper), RateUsMVPInterator {

    override fun submitRating() {}
}