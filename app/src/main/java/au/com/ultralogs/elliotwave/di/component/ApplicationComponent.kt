package au.com.ultralogs.elliotwave.di.component


import android.app.Application
import au.com.ultralogs.elliotwave.ElliotWave
import au.com.ultralogs.elliotwave.di.Builder.ActivityBuilder
import au.com.ultralogs.elliotwave.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/*
one singleton component for whole application that manage whole elliot wave application lifecycle
 */
@Singleton
@Component(modules = [(AndroidSupportInjectionModule::class),(AppModule::class),(ActivityBuilder::class)])
interface ApplicationComponent {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: ElliotWave)
}