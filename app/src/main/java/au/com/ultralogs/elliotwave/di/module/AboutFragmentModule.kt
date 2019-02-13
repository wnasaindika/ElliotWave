package au.com.ultralogs.elliotwave.di.module

import au.com.ultralogs.elliotwave.ui.about.AboutFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AboutFragmentModule {
    //provide about fragment
    @ContributesAndroidInjector
    abstract internal fun provideAboutFragment(): AboutFragment

}