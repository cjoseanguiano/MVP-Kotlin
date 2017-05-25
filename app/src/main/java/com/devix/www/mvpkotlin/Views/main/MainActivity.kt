package com.devix.www.mvpkotlin.Views.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.view.View
import com.devix.www.mvpkotlin.Model.Data
import com.devix.www.mvpkotlin.R
import com.devix.www.mvpkotlin.Views.next.NextFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initPresenter()
        onAttach()
    }

    override fun onAttach() {
        presenter.onAttach(this)
        initToolbar()
        addButtonListener()
    }

    private fun addButtonListener() {
        btn_main.setOnClickListener { view ->
            btn_main.visibility = View.GONE
            presenter.showFragment()
        }
    }

    private fun initToolbar() {
        toolbar_main.title = title
        setSupportActionBar(toolbar_main)
    }

    override fun onDetach() {
        presenter.onDetach()
    }

    override fun onShowFragment(data: Data) {

        val bundle: Bundle = Bundle()
        bundle.putString("data", data.text)

        val tag: String = NextFragment::class.java.simpleName
        val fragment: Fragment = NextFragment().newInstance()
        fragment.arguments = bundle
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_main, fragment, tag)
        fragmentTransaction.commit()

    }

    override fun onDestroy() {
        onDetach()
        super.onDestroy()
    }

    private fun initPresenter() {
        presenter = MainPresenter()
    }
}
