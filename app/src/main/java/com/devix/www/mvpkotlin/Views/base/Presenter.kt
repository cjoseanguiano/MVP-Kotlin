package com.devix.www.mvpkotlin.Views.base

/**
 * Created by carlosjoseanguiano on 24/05/17.
 */
interface Presenter<in T : View> {

    fun onAttach(view: T)
    fun onDetach()
}