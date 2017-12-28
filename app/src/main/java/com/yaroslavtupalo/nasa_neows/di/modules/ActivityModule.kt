package com.yaroslavtupalo.nasa_neows.di.modules

import android.app.Activity
import android.content.Context
import com.yaroslavtupalo.nasa_neows.di.ActivityContext
import com.yaroslavtupalo.nasa_neows.di.PerActivity
import dagger.Module
import dagger.Provides

/**
 * Created by Yaroslav on 22.12.2017.
 */
@Module
class ActivityModule(private val activity: Activity) {

    @PerActivity
    @Provides
    @ActivityContext
    fun provideContext(): Context = activity
}