package com.yaroslavtupalo.nasa_neows.presenter

import com.yaroslavtupalo.nasa_neows.api.NASAapi
import com.yaroslavtupalo.nasa_neows.model.moshi.Example
import com.yaroslavtupalo.nasa_neows.rx.RxThread
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by Yaroslav on 22.12.2017.
 */
class AsteroidPresenter @Inject constructor(private val api: NASAapi,
                                            private val rxThread: RxThread) {

    private lateinit var view: View
    private val subscription = CompositeDisposable()

    interface View{
        fun loading()
        fun getAsteroidsInfoSuccess(asteroidsInfo: Example)
        fun getAsteroidsInfoError(message: String?)
        fun getAsteroidsInfoComplete()
    }

    fun injectView(view: View){
        this.view = view
    }
    fun getAsteroid(asteroid_id: String, api_key: String = "2Vxe35k5xaHe61qLtgPd5buYpVhKCjqtc0mMTFYv"){

    view.loading()
    subscription.add(api.getAsteroid(asteroid_id, api_key)
            .compose(rxThread.applyAsync())
            .doOnTerminate { view.getAsteroidsInfoComplete() }
            .subscribe({
                view.getAsteroidsInfoSuccess(it)
            }){
                view.getAsteroidsInfoError(it.message)
            })
}

    fun onStop(){
        subscription.clear()
    }
}