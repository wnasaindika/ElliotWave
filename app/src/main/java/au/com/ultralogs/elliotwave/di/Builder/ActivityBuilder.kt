package au.com.ultralogs.elliotwave.di.Builder

import au.com.ultralogs.elliotwave.di.module.AboutFragmentModule
import au.com.ultralogs.elliotwave.di.module.MainActivityModule
import au.com.ultralogs.elliotwave.di.module.RateUsDialogModule
import au.com.ultralogs.elliotwave.ui.main.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


//all activities to wrap in one module
@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [(MainActivityModule::class),(RateUsDialogModule::class), (AboutFragmentModule::class)])
    abstract fun bindMainActivity(): MainActivity
}