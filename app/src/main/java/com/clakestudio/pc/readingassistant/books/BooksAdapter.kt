package com.clakestudio.pc.readingassistant.books

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clakestudio.pc.readingassistant.R
import com.clakestudio.pc.readingassistant.data.Book

class BooksAdapter(
        private var books: List<Book>,
        private val booksViewModel: BooksViewModel
) : RecyclerView.Adapter<BooksViewHolder>() {

    /**
     * Currently booksViewModel is not needed right now but, later when integration with
     * certain CardViews will be implemented, we will be able to easily communicate with booksViewModel
     * and for example open another activity
     * */

    class ViewHolder(val bookItemView: View) : RecyclerView.ViewHolder(bookItemView)

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BooksViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.book, parent, false) as View
        return BooksViewHolder(view)
    }

    override fun onBindViewHolder(holder: BooksViewHolder?, position: Int) {
        /**
         * holder!! ??
         * */

        holder!!.bind(books[position])

    }

    override fun getItemCount(): Int {
        return books.size
    }

    fun setBooksList(books: ArrayList<Book>) {
        this.books = books
        notifyDataSetChanged()
    }

}