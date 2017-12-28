package com.yaroslavtupalo.nasa_neows.fragment


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.yaroslavtupalo.nasa_neows.MainActivity

import com.yaroslavtupalo.nasa_neows.R
import com.yaroslavtupalo.nasa_neows.app.MainApplication
import com.yaroslavtupalo.nasa_neows.model.moshi.Example
import com.yaroslavtupalo.nasa_neows.presenter.AsteroidPresenter
import com.yaroslavtupalo.nasa_neows.realm.CloseApproach
import com.yaroslavtupalo.nasa_neows.realm.CloseApproachManager
import com.yaroslavtupalo.nasa_neows.utils.KeyboardUtil
import io.realm.Realm
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment(), AsteroidPresenter.View {

    @Inject lateinit var keyboard: KeyboardUtil

    @Inject lateinit var presenter: AsteroidPresenter

    private lateinit var realm: Realm

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        (activity?.application as MainApplication).components.inject(this)
        realm = Realm.getDefaultInstance()
    }

    override fun loading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun getAsteroidsInfoSuccess(asteroidsInfo: Example) {

        loadImage()

        val listUFO = asteroidsInfo.closeApproachData
        listUFO?.let {
            realm.use {
                it.executeTransactionAsync(Realm.Transaction {
                    realm: Realm? ->
                    realm?.deleteAll()
                    val closeApproachManager = realm?.createObject(CloseApproachManager::class.java)
                    for ((index) in listUFO.withIndex()){
                        val closeApproach = CloseApproach()
                        closeApproach?.close_approach_date = listUFO[index].closeApproachDate
                        closeApproach?.distance = listUFO[index].missDistance.kilometers + " km."
                        closeApproach?.orbiting_body = listUFO[index].orbitingBody
                        closeApproach?.speed = listUFO[index].relativeVelocity.kilometersPerSecond + " km./s."
                        closeApproachManager?.closeApproach?.add(closeApproach)
                    }
                }, Realm.Transaction.OnSuccess {
                    tvName.apply {
                        isClickable = true
                        text = "Name: " + asteroidsInfo.name + "; "
                        setOnClickListener { (activity as MainActivity).onClickNameAsteroid() }
                    }
                })
            }
        }
    }

    private fun loadImage(){
        Glide.with(this).load("https://api.nasa.gov/images/apod.jpg").diskCacheStrategy(DiskCacheStrategy.RESULT).into(ivAsteroid)
    }

    override fun getAsteroidsInfoError(message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    override fun getAsteroidsInfoComplete() {
        progressBar.visibility = View.GONE
        keyboard.hideKeyboard(asteroid_id)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        presenter.injectView(this)

        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onResume() {
        super.onResume()

        rootLayout.setOnClickListener(View.OnClickListener {
            keyboard.hideKeyboard(asteroid_id)
        })

        btnLoad.setOnClickListener(View.OnClickListener {
            presenter.getAsteroid(asteroid_id.text.toString())
        })
    }

    override fun onStop() {
        super.onStop()

        presenter.onStop()
    }
}
