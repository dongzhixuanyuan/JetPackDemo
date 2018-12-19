package com.ld.navigation


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_home.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn01.setOnClickListener {
            findNavController().navigate(R.id.action_home_dest_to_fragment_01)
        }
        btn02.setOnClickListener {
            findNavController().navigate(R.id.action_home_dest_to_fragment_02)
        }
        btn03.setOnClickListener {
            findNavController().navigate(R.id.action_home_dest_to_fragment_03)
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)


    }
}
