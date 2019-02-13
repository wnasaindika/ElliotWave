package au.com.ultralogs.elliotwave.di.module

import au.com.ultralogs.elliotwave.ui.main.interactor.MainInteractor
import au.com.ultralogs.elliotwave.ui.main.interactor.MainMVPInteractor
import au.com.ultralogs.elliotwave.ui.main.presenter.MainMVPPresenter
import au.com.ultralogs.elliotwave.ui.main.presenter.MainPresenter
import au.com.ultralogs.elliotwave.ui.main.view.MainMVPView
import dagger.Module
import dagger.Provides

/*
*@Description
* MainActivity Module which provide main interactor and main presenter
*/
@Module
class MainActivityModule {
    @Provides
    internal fun provideMainInteractor(mainInteractor: MainInteractor): MainMVPInteractor = mainInteractor

    @Provides
    internal fun provideMainPresenter(mainPresenter: MainPresenter<MainMVPView, MainMVPInteractor>)
            : MainMVPPresenter<MainMVPView, MainMVPInteractor> = mainPresenter
}