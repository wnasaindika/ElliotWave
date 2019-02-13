package au.com.ultralogs.elliotwave.ui.base.intreractor

import au.com.ultralogs.elliotwave.data.network.ApiHelper
import au.com.ultralogs.elliotwave.data.preferance.PreferenceHelper

/* base presenter for background apps operations */
open class BaseInteractor() : MVPInteractor {

    protected lateinit var preferenceHelper: PreferenceHelper
    protected lateinit var apiHelper: ApiHelper

    constructor(preferenceHelper: PreferenceHelper, apiHelper: ApiHelper) : this() {
        this.preferenceHelper = preferenceHelper
        this.apiHelper = apiHelper
    }

    override fun isUserLoggedIn(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun performUserLogout() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}