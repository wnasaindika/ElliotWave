package au.com.ultralogs.elliotwave.di.module

import au.com.ultralogs.elliotwave.ui.rate.interactor.RateUsInteractor
import au.com.ultralogs.elliotwave.ui.rate.interactor.RateUsMVPInterator
import au.com.ultralogs.elliotwave.ui.rate.presenter.RateUsMVPPresenter
import au.com.ultralogs.elliotwave.ui.rate.presenter.RateUsPresenter
import au.com.ultralogs.elliotwave.ui.rate.view.RateUsMVPView
import dagger.Module
import dagger.Provides
/*
this module provide rate us interactor and presenter
 */
@Module
class RateUsFragmentModule {

    @Provides
    internal fun provideRateUsInteractor(interactor: RateUsInteractor): RateUsMVPInterator = interactor

    @Provides
    internal fun provideRateUsPresenter(presenter: RateUsPresenter<RateUsMVPView, RateUsMVPInterator>)
            : RateUsMVPPresenter<RateUsMVPView, RateUsMVPInterator> = presenter
}