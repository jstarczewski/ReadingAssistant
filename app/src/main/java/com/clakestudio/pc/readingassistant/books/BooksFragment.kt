package com.clakestudio.pc.readingassistant.books

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.clakestudio.pc.readingassistant.R
import com.clakestudio.pc.readingassistant.databinding.FragmentBooksBinding
import kotlinx.android.synthetic.main.fragment_books.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [BooksFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [BooksFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class BooksFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private lateinit var viewDataBinding: FragmentBooksBinding
    private lateinit var booksAdapter: BooksAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        viewDataBinding = FragmentBooksBinding.inflate(inflater, container, false).apply {
            viewmodel = (activity as BooksActivity).obtainViewModel()
        }

        /*
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = booksAdapter

        }*/



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



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment BooksFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
                BooksFragment().apply {
                }
    }
}
