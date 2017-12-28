package com.yaroslavtupalo.nasa_neows.di.modules

import android.support.customtabs.CustomTabsIntent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Yaroslav on 22.12.2017.
 */
@Module
class AndroidModule {

    @Provides
    @Singleton
    fun provideCustomTabsBuilder(): CustomTabsIntent.Builder = CustomTabsIntent.Builder()

    @Provides
    @Singleton
    fun provideCustomTabsIntent(builder: CustomTabsIntent.Builder): CustomTabsIntent = builder.build()
}