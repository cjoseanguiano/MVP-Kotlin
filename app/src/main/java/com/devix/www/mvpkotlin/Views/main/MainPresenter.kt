package com.devix.www.mvpkotlin.Views.main

import com.devix.www.mvpkotlin.Model.Data
import com.devix.www.mvpkotlin.Views.base.Presenter


/**
 * Created by carlosjoseanguiano on 24/05/17.
 */

class MainPresenter : Presenter<MainView> {

    private var mView: MainView? = null

    override fun onAttach(view: MainView) {
        mView = view;
    }

    override fun onDetach() {
        mView = null
    }

    fun showFragment() {
        val data: Data = Data("Hola MVP with Kotlin")
        mView?.onShowFragment(data)
    }
}