package com.yaroslavtupalo.nasa_neows.fragment


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.yaroslavtupalo.nasa_neows.R
import com.yaroslavtupalo.nasa_neows.adapter.AsteroidAdapter
import com.yaroslavtupalo.nasa_neows.app.MainApplication
import com.yaroslavtupalo.nasa_neows.realm.CloseApproachManager
import com.yaroslavtupalo.nasa_neows.utils.inflater
import io.realm.OrderedRealmCollection
import io.realm.Realm


/**
 * A simple [Fragment] subclass.
 */
class AsteroidFragment : Fragment() {

    private lateinit var realm: Realm

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        (activity?.application as MainApplication).components.inject(this)
        realm = Realm.getDefaultInstance()
    }

    private fun getDataFromRealm(realm: Realm): OrderedRealmCollection<CloseApproachManager>{

        return realm.where(CloseApproachManager::class.java).findAll()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rootView = container?.inflater(R.layout.fragment_asteroid)

        val rv: RecyclerView = rootView?.findViewById(R.id.recyclerViewAsteroid) as RecyclerView
        val lm = LinearLayoutManager(context)
        rv.layoutManager = lm
        rv.itemAnimator = DefaultItemAnimator()
        rv.adapter = AsteroidAdapter(getDataFromRealm(realm)[0].closeApproach, false, false)
        return rootView
    }

}// Required empty public constructor
