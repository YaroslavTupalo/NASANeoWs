package com.yaroslavtupalo.nasa_neows.realm

import io.realm.RealmList
import io.realm.RealmObject

/**
 * Created by Yaroslav on 27.12.2017.
 */

open class CloseApproachManager(var closeApproach: RealmList<CloseApproach> = RealmList()): RealmObject()