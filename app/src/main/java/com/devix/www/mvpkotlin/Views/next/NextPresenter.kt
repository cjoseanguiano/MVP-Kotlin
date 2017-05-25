package com.devix.www.mvpkotlin.Views.next

import com.devix.www.mvpkotlin.Views.base.Presenter

/**
 * Created by carlosjoseanguiano on 24/05/17.
 */

class NextPresenter : Presenter<NextView> {
    private var mView: NextView? = null

    override fun onAttach(view: NextView) {
        mView = view
    }

    override fun onDetach() {
        TODO("not implemented")
        mView = null
    }

    fun showText(text: String) {
        mView?.onShowResult(text)
    }
}