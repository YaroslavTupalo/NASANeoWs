package com.yaroslavtupalo.nasa_neows.di.modules

import android.app.Application
import android.content.Context
import android.view.inputmethod.InputMethodManager
import com.yaroslavtupalo.nasa_neows.di.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Yaroslav on 22.12.2017.
 */
@Module
class ApplicationModule(private val application: Application) {

    @Provides
    @Singleton
    @ApplicationContext
    fun provideContext(): Application = this.application

    @Provides
    @Singleton
    fun provideInputMethod() = application.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
}