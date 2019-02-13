package au.com.ultralogs.elliotwave.ui.main.view

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import au.com.ultralogs.elliotwave.R
import au.com.ultralogs.elliotwave.ui.about.AboutFragment
import au.com.ultralogs.elliotwave.ui.base.intreractor.SwapDataSample
import au.com.ultralogs.elliotwave.ui.base.view.BaseActivity
import au.com.ultralogs.elliotwave.ui.main.interactor.MainMVPInteractor
import au.com.ultralogs.elliotwave.ui.main.presenter.MainMVPPresenter
import au.com.ultralogs.elliotwave.ui.rate.view.RateUsDialog
import au.com.ultralogs.elliotwave.util.ScreenUtils
import au.com.ultralogs.elliotwave.util.extention.addFragment
import au.com.ultralogs.elliotwave.util.extention.removeFragment
import com.mindorks.placeholderview.SwipeDecor
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_navigation.*
import javax.inject.Inject

/*
Main activity that perform all major functions
All network views and other apps operations available via well manage dependency injections
*/
class MainActivity : BaseActivity(), MainMVPView, NavigationView.OnNavigationItemSelectedListener,
        HasSupportFragmentInjector {

    @Inject
    internal lateinit var presenter: MainMVPPresenter<MainMVPView, MainMVPInteractor>
    @Inject
    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpDrawerMenu()
        setupCardContainerView()
        addSomething()
        presenter.onAttached(this)
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    override fun loadError(e: Throwable) {
    }

    override fun loadError(msg: String) {
    }

    override fun onFragmentAttached() {
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        }
        val fragment = supportFragmentManager.findFragmentByTag(AboutFragment.TAG)
        fragment?.let { onFragmentDetached(AboutFragment.TAG) } ?: super.onBackPressed()
    }

    override fun onFragmentDetached(tag: String) {
        supportFragmentManager?.removeFragment(tag = tag)
        unlockDrawer()

    }

    override fun openAboutFragment() {
        lockDrawer()
        supportFragmentManager.addFragment(R.id.cl_root_view, AboutFragment.newInstance(), AboutFragment.TAG)
    }

    override fun openRateUsDialog() = RateUsDialog.newInstance().let {
        it?.show(supportFragmentManager)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentDispatchingAndroidInjector

    //generating Swap views
    private fun setupCardContainerView() {
        val screenWidth = ScreenUtils.getScreenWidth(this)
        val screenHeight = ScreenUtils.getScreenHeight(this)
        swipe!!.builder
                .setDisplayViewCount(3)
                .setHeightSwipeDistFactor(10f)
                .setWidthSwipeDistFactor(5f)
                .setSwipeDecor(SwipeDecor()
                        .setViewWidth((0.90 * screenWidth).toInt())
                        .setViewHeight((0.75 * screenHeight).toInt())
                        .setPaddingTop(20)
                        .setSwipeRotationAngle(10)
                        .setRelativeScale(0.01f))
        swipe.addItemRemoveListener { count ->
            if (count == 0) {
                addSomething()
            }
        }
    }

    override fun addSomething() {
        for (i in 0..10) {
            swipe!!.addView(SwapCardView(this,SwapDataSample("Data" + i)))
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.navItemAbout -> {
                presenter.onDrawerOptionAboutClick()
            }
            R.id.navItemRateUs -> {
                presenter.onDrawerOptionRateUsClick()
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun setUpDrawerMenu() {
        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(
                this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)

    }

    override fun lockDrawer() = drawerLayout?.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)

    override fun unlockDrawer() = drawerLayout?.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
}