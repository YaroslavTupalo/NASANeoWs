package com.yaroslavtupalo.nasa_neows.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.yaroslavtupalo.nasa_neows.utils.inflater
import com.yaroslavtupalo.nasa_neows.R
import com.yaroslavtupalo.nasa_neows.realm.CloseApproach
import io.realm.OrderedRealmCollection
import io.realm.RealmRecyclerViewAdapter
import kotlinx.android.synthetic.main.item_asteroid.view.*

/**
 * Created by Yaroslav on 26.12.2017.
 */
class AsteroidAdapter : RealmRecyclerViewAdapter<CloseApproach, AsteroidAdapter.MyAsteroidViewHolder> {

    constructor(data_: OrderedRealmCollection<CloseApproach>?): super(data_, true)

    constructor(data_: OrderedRealmCollection<CloseApproach>?, autoUpdate: Boolean): super(data_, autoUpdate)

    constructor(data_: OrderedRealmCollection<CloseApproach>?, autoUpdate: Boolean, updateOnModification: Boolean): super(data_, autoUpdate, updateOnModification)

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyAsteroidViewHolder {
        return MyAsteroidViewHolder(parent)
    }

    override fun onBindViewHolder(holder: MyAsteroidViewHolder?, position: Int) {

        holder as MyAsteroidViewHolder

        val item = getItem(position)

        item?.let { holder.bin(item) }
    }

    inner class MyAsteroidViewHolder(parent: ViewGroup?): RecyclerView.ViewHolder(
            parent?.inflater(R.layout.item_asteroid)
    ){
        private val close_approach_date = itemView.close_approach_date
        private val orbiting_body = itemView.orbiting_body
        private val speed = itemView.speed
        private val distance = itemView.distance

        fun bin(item: CloseApproach){

            close_approach_date.text = item.close_approach_date
            orbiting_body.text = item.orbiting_body
            speed.text = item.speed
            distance.text = item.distance
        }
    }
}