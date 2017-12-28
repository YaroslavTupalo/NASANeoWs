package com.yaroslavtupalo.nasa_neows.di.component

import com.yaroslavtupalo.nasa_neows.MainActivity
import com.yaroslavtupalo.nasa_neows.di.modules.AndroidModule
import com.yaroslavtupalo.nasa_neows.di.modules.ApplicationModule
import com.yaroslavtupalo.nasa_neows.di.modules.HttpModule
import com.yaroslavtupalo.nasa_neows.di.modules.RxThreadModule
import com.yaroslavtupalo.nasa_neows.fragment.AsteroidFragment
import com.yaroslavtupalo.nasa_neows.fragment.MainFragment
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Yaroslav on 22.12.2017.
 */
@Singleton
@Component(modules = arrayOf(HttpModule::class,
        ApplicationModule::class, AndroidModule::class,
        RxThreadModule::class))
interface AppComponent {

    fun inject(fragment:MainActivity)

    fun inject(fragment: MainFragment)

    fun inject(fragment: AsteroidFragment)
}