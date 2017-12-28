package com.yaroslavtupalo.nasa_neows.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Yaroslav on 22.12.2017.
 */
fun ViewGroup.inflater(layoutId: Int): View {
    return LayoutInflater.from(context).inflate(layoutId, this, false)
}