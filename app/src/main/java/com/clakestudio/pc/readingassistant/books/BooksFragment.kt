package com.clakestudio.pc.readingassistant.books

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clakestudio.pc.readingassistant.R
import com.clakestudio.pc.readingassistant.databinding.FragmentBooksBinding
import com.clakestudio.pc.readingassistant.util.setUpSnackbar

class BooksFragment : Fragment() {

    private lateinit var viewDataBinding: FragmentBooksBinding
    private lateinit var booksAdapter: BooksAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewDataBinding = FragmentBooksBinding.inflate(inflater, container, false).apply {
            viewmodel = (activity as BooksActivity).obtainViewModel()
        }

        return viewDataBinding.root
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = viewDataBinding.viewmodel
        if (viewModel != null) {
            booksAdapter = BooksAdapter(ArrayList(0), viewModel)
            viewDataBinding.rvBooks.apply {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                viewDataBinding.rvBooks.adapter = booksAdapter
            }
        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewDataBinding.viewmodel?.let {
            view?.setUpSnackbar(this, it.snackbarMessage, Snackbar.LENGTH_LONG)
        }
        setUpFab()
    }

    override fun onResume() {
        super.onResume()
        viewDataBinding.viewmodel?.start()
    }

    private fun setUpFab() {

        activity.findViewById<FloatingActionButton>(R.id.fab_addBook).run {
            setOnClickListener {
                viewDataBinding.viewmodel?.addNewBook()
            }
        }

    }

    companion object {
        @JvmStatic
        fun newInstance() =
                BooksFragment().apply {
                }
    }
}
