package com.okawa.composepoc.di

import com.okawa.composepoc.App
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ActivityModule::class,
        AndroidInjectionModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {

    fun inject(App: App)

}