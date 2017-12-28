package com.yaroslavtupalo.nasa_neows.di.component

import com.yaroslavtupalo.nasa_neows.di.PerActivity
import com.yaroslavtupalo.nasa_neows.di.modules.ActivityModule
import dagger.Component

/**
 * Created by Yaroslav on 22.12.2017.
 */
@PerActivity
@Component(dependencies = arrayOf(AppComponent::class),
        modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
}