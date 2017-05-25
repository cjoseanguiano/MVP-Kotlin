package com.devix.www.mvpkotlin.Views.main

import com.devix.www.mvpkotlin.Model.Data
import com.devix.www.mvpkotlin.Views.base.View

/**
 * Created by carlosjoseanguiano on 24/05/17.
 */

interface MainView : View {
    fun onShowFragment(data: Data)
}