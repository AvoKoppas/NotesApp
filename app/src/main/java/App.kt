package com.testdevlab

import android.app.Application
import com.testdevlab.notesapp.BuildConfig
import com.testdevlab.notesapp.common.LineNumberDebugThree
import com.testdevlab.notesapp.injection.DaggerInjectionComponent
import com.testdevlab.notesapp.injection.InjectionComponent
import com.testdevlab.notesapp.injection.InjectionModule
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(LineNumberDebugThree())
        }
        Timber.d("App created")
        component = DaggerInjectionComponent
            .builder()
            .injectionModule(InjectionModule(this))
            .build()
    }

    companion object {
        lateinit var component: InjectionComponent
            private set
    }
}