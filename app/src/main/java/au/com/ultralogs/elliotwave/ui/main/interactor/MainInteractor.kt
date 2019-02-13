package au.com.ultralogs.elliotwave.ui.main.interactor

import au.com.ultralogs.elliotwave.data.network.ApiHelper
import au.com.ultralogs.elliotwave.data.preferance.PreferenceHelper
import au.com.ultralogs.elliotwave.ui.base.intreractor.BaseInteractor
import javax.inject.Inject


class MainInteractor @Inject  internal constructor(preferenceHelper: PreferenceHelper, apiHelper: ApiHelper) : BaseInteractor(preferenceHelper = preferenceHelper, apiHelper = apiHelper), MainMVPInteractor {

    override fun getSomething() {

    }

}