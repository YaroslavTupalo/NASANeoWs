package com.yaroslavtupalo.nasa_neows.app

import android.app.Application
import com.yaroslavtupalo.nasa_neows.di.component.AppComponent
import com.yaroslavtupalo.nasa_neows.di.component.DaggerAppComponent
import com.yaroslavtupalo.nasa_neows.di.modules.AndroidModule
import com.yaroslavtupalo.nasa_neows.di.modules.ApplicationModule
import com.yaroslavtupalo.nasa_neows.di.modules.HttpModule
import io.realm.Realm

/**
 * Created by Yaroslav on 22.12.2017.
 */
class MainApplication: Application() {

    lateinit var components: AppComponent

    override fun onCreate() {
        super.onCreate()

        // Initialize Realm. Should only be done once when the application starts.
        Realm.init(this)

        components = DaggerAppComponent.builder()
                .applicationModule(ApplicationModule(this))
                .androidModule(AndroidModule())
                .httpModule(HttpModule())
                .build()
    }
}