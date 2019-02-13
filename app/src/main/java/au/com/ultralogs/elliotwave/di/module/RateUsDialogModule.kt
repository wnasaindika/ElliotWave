package au.com.ultralogs.elliotwave.di.module

import au.com.ultralogs.elliotwave.ui.rate.view.RateUsDialog
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class RateUsDialogModule{

    //provide rate fragment with dialog
    @ContributesAndroidInjector(modules = [RateUsFragmentModule::class])
    internal abstract fun provideRateUsFragment() : RateUsDialog
}