package com.yaroslavtupalo.nasa_neows.rx

import io.reactivex.ObservableTransformer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by Yaroslav on 22.12.2017.
 */
class RxThread @Inject constructor(@Named("mainThread") val mainSchedulers: Scheduler,
                                   @Named("ioThread") val ioScheduler: Scheduler) {

    fun <T> applyAsync(): ObservableTransformer<T,T> =
            ObservableTransformer { (
                    it.subscribeOn(ioScheduler).subscribeOn(mainSchedulers).observeOn(AndroidSchedulers.mainThread())
                    ) }
}