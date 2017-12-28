package com.yaroslavtupalo.nasa_neows

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.yaroslavtupalo.nasa_neows.app.MainApplication
import com.yaroslavtupalo.nasa_neows.di.component.ActivityComponent
import com.yaroslavtupalo.nasa_neows.di.component.DaggerActivityComponent
import com.yaroslavtupalo.nasa_neows.fragment.AsteroidFragment
import com.yaroslavtupalo.nasa_neows.fragment.MainFragment

class MainActivity : AppCompatActivity() {

    private lateinit var components: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        components = DaggerActivityComponent.builder()
                .appComponent((application as MainApplication).components)
                .build()

        setContentView(R.layout.activity_main)

        initialFragment()
    }

    private fun initialFragment(){
        supportFragmentManager.beginTransaction()
                .replace(R.id.contentContainer, MainFragment())
                .commit()
    }

    private fun changeFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
                .replace(R.id.contentContainer, fragment)
                .addToBackStack(null)
                .commit()
    }

    fun onClickNameAsteroid(){
        changeFragment(AsteroidFragment())
    }
}
