package com.clakestudio.pc.readingassistant.books

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clakestudio.pc.readingassistant.data.Book
import com.clakestudio.pc.readingassistant.databinding.BookBinding
import kotlinx.android.synthetic.main.book.view.*

class BooksAdapter(private var books: ArrayList<Book>,
                   private val booksViewModel: BooksViewModel
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    /**
     * Currently booksViewModel is not needed right now but, later when integration with
     * certain CardViews will be implemented, we will be able to easily communicate with booksViewModel
     * and for example open another activity
     * */

    class ViewHolder(bookItemView: View) : RecyclerView.ViewHolder(bookItemView) {

        var title = bookItemView.tvTitle
        val tvAuthor = bookItemView.tvAuthor
        val tvNote = bookItemView.tvNote

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {

        val binding: BookBinding

        val inflater = LayoutInflater.from(parent!!.context)

        binding = BookBinding.inflate(inflater, parent, false)

        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        /**
         * holder!! ??
         * */
        holder!!.itemView.tvTitle.text = books[position].title
        holder.itemView.tvAuthor.text = books[position].author
        holder.itemView.tvNote.text = books[position].note

    }

    override fun getItemCount(): Int {
        return books.size
    }

    fun replaceData(books: ArrayList<Book>) = setBooks(books)

    private fun setBooks(books: ArrayList<Book>) {
        this.books = books
        notifyDataSetChanged()
    }

}