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

    private lateinit var viewModel: BlankViewModel

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        viewModel = ViewModelProviders.of(activity as FragmentActivity).get(BlankViewModel::class.java)

    }
    companion object {
        fun newInstance() = BlankFragment01()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.blank_fragment, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        kotlin中可以直接使用布局文件中的控件id来操作该view，但是前提是在onViewCreated中使用。
        increase.setOnClickListener {
            viewModel.number++
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }


    override fun onResume() {
        super.onResume()
        number_tv.setText(viewModel.number.toString())
    }

}
