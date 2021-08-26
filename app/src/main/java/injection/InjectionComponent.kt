package com.testdevlab.notesapp.injection

import com.testdevlab.notesapp.ui.MainViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [InjectionModule::class])
interface InjectionComponent {

    fun inject(target: MainViewModel)

}