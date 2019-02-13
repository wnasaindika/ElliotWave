package au.com.ultralogs.elliotwave.di.module


import android.app.Application
import android.content.Context
import au.com.ultralogs.elliotwave.data.network.ApiHeader
import au.com.ultralogs.elliotwave.data.network.ApiHelper
import au.com.ultralogs.elliotwave.data.network.AppApiHelper
import au.com.ultralogs.elliotwave.data.preferance.AppPreferanceHelper
import au.com.ultralogs.elliotwave.data.preferance.PreferenceHelper
import au.com.ultralogs.elliotwave.di.ApiKeyInfo
import au.com.ultralogs.elliotwave.di.PreferenceInfo
import au.com.ultralogs.elliotwave.util.AppConstants
import au.com.ultralogs.elliotwave.util.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

/*
* @Description
* This application module consist of all required objects such as api, shared preference, apps context etc
*/
@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    @Provides
    @Singleton
    internal fun provideProtectedApiHeader(@ApiKeyInfo apiKey: String, preferenceHelper: PreferenceHelper)
            : ApiHeader.ProtectedApiHeader = ApiHeader.ProtectedApiHeader(apiKey = apiKey,
            userId = preferenceHelper.getCurrentUserId(),
            accessToken = preferenceHelper.getAccessToken())


    @Provides
    @ApiKeyInfo
    internal fun provideApiKey(): String = AppConstants.API_KEY


    @Provides
    @PreferenceInfo
    internal fun provideprefFileName(): String = AppConstants.PREF_NAME

    @Provides
    @Singleton
    internal fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper = appApiHelper

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider = SchedulerProvider()

    @Provides
    @Singleton
    internal fun providePrefHelper(appPreferenceHelper: AppPreferanceHelper): PreferenceHelper = appPreferenceHelper

}