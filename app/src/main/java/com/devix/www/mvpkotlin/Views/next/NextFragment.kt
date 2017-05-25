package com.devix.www.mvpkotlin.Views.next

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.devix.www.mvpkotlin.R
import kotlinx.android.synthetic.main.fragment_next.*


class NextFragment : Fragment(), NextView {

    lateinit var presenter: NextPresenter

    fun newInstance(): NextFragment {
        return NextFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initPresenter()
        onAttach()
    }

    private fun initPresenter() {
        presenter = NextPresenter()
    }

    override fun onAttach() {
        presenter.onAttach(this)
        setText()
    }

    override fun onDetach() {
        presenter.onDetach()
        super.onDetach()
    }

    private fun setText() {
        val bundle: Bundle = arguments
        val text: String = bundle.getString("data")
        presenter.showText(text)
    }

    override fun onShowResult(text: String) {
        tv_next.text = text
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater?.inflate(R.layout.fragment_next, container, false)
    }

    override fun onDestroyView() {
        onDetach()
        super.onDestroyView()
    }
}
