package com.clakestudio.pc.readingassistant.books

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clakestudio.pc.readingassistant.R
import com.clakestudio.pc.readingassistant.data.Book
import kotlinx.android.synthetic.main.book.view.*

class BooksAdapter(
        private var books: List<Book>,
        private val booksViewModel: BooksViewModel
) : RecyclerView.Adapter<BooksAdapter.ViewHolder>() {

    class ViewHolder(val bookItemView: View) : RecyclerView.ViewHolder(bookItemView)


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BooksAdapter.ViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.book, parent, false) as View
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        /**
         * holder!! ??
         * */
        holder!!.bookItemView.tvTitle.text = books[position].title
        holder.bookItemView.tvAuthor.text = books[position].author
        holder.bookItemView.tvNote.text = books[position].note
    }

    override fun getItemCount(): Int {
        return books.size
    }


}