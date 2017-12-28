package com.yaroslavtupalo.nasa_neows.di.modules

import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by Yaroslav on 22.12.2017.
 */
@Module
class RxThreadModule {

    @Singleton
    @Provides
    @Named("mainThread")
    fun provideAndroidSchedulers() = AndroidSchedulers.mainThread()

    @Provides
    @Singleton
    @Named("ioThread")
    fun provideSchedulersIO() = Schedulers.io()
}