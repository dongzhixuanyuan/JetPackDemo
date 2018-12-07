package com.ld.viewmodelwithlivedata

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.ld.viewmodelwithlivedata.R
import com.ld.viewmodelwithlivedata.R.id.increase
import kotlinx.android.synthetic.main.blank_fragment.*
import kotlinx.android.synthetic.main.blank_fragment.view.*


class BlankFragment01 : Fragment() {
    private lateinit var viewModel: BlankViewModel
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        viewModel = ViewModelProviders.of(activity as FragmentActivity).get(BlankViewModel::class.java)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        kotlin中可以直接使用布局文件中的控件id来操作该view，但是前提是在onViewCreated中使用。
        increase.setOnClickListener {
            if (viewModel.number.value == null) {
                viewModel.number.value=1
            }else{
                var value = viewModel.number.value
                viewModel.number.value = value?.inc()
            }
        }
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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }


    override fun onResume() {
        super.onResume()
        number_tv_01.setText(viewModel.score.value?.toString())
    }

}
