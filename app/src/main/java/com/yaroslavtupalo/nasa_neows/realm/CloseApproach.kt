package com.yaroslavtupalo.nasa_neows.realm

import io.realm.RealmObject

/**
 * Created by Yaroslav on 26.12.2017.
 */

open class CloseApproach(var close_approach_date: String? = null,
                    var orbiting_body: String? = null,
                    var speed: String? = null,
                    var distance: String? = null): RealmObject()