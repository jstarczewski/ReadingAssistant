package com.clakestudio.pc.readingassistant.addeditbook


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.clakestudio.pc.readingassistant.R


class AddEditBookFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_edit_book, container, false)
    }


    companion object {
        @JvmStatic
        fun newInstance() = AddEditBookFragment()
    }
}
