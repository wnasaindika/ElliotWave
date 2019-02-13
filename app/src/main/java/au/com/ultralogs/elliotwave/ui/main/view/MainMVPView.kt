package au.com.ultralogs.elliotwave.ui.main.view

import au.com.ultralogs.elliotwave.ui.base.view.MVPView

interface MainMVPView : MVPView {

    fun addSomething()
    fun openRateUsDialog(): Unit?
    fun openAboutFragment()
    fun lockDrawer(): Unit?
    fun unlockDrawer(): Unit?
}