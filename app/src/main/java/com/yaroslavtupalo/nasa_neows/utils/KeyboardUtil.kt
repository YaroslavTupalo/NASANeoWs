package com.yaroslavtupalo.nasa_neows.utils

import android.view.View
import android.view.inputmethod.InputMethodManager
import javax.inject.Inject

/**
 * Created by Yaroslav on 22.12.2017.
 */
class KeyboardUtil @Inject constructor(private val inputMethodManager: InputMethodManager) {

    fun hideKeyboard(view: View){
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    }
}