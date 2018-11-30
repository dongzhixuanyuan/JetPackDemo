package com.ld.jetpackdemo

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.blank_fragment.*


class BlankFragment01 : Fragment() {


    companion object {
        fun newInstance() = BlankFragment01()
    }

    private lateinit var viewModel: BlankViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.blank_fragment, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        increase.setOnClickListener {
            viewModel.number++
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        viewModel = ViewModelProviders.of(activity as FragmentActivity).get(BlankViewModel::class.java)

    }

    override fun onResume() {
        super.onResume()
        number_tv.setText(viewModel.number.toString())
    }

}
