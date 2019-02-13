package au.com.ultralogs.elliotwave.ui.base.intreractor

interface MVPInteractor {
    fun isUserLoggedIn(): Boolean
    fun performUserLogout()
}