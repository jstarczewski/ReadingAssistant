package com.clakestudio.pc.readingassistant.books

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clakestudio.pc.readingassistant.databinding.FragmentBooksBinding

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

    override fun onResume() {
        super.onResume()
        viewDataBinding.viewmodel?.start()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
                BooksFragment().apply {
                }
    }
}
