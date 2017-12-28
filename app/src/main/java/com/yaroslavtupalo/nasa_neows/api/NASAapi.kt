package com.yaroslavtupalo.nasa_neows.api

import com.yaroslavtupalo.nasa_neows.model.moshi.Example
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Yaroslav on 22.12.2017.
 */
interface NASAapi {

    @GET("/neo/rest/v1/neo/{asteroid_id}")
    fun getAsteroid(@Path("asteroid_id") asteroid_id: String,
                    @Query("api_key") api_key: String): Observable<Example>
}