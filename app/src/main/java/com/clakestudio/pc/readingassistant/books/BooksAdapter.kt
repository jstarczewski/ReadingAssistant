package com.clakestudio.pc.readingassistant.books

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.clakestudio.pc.readingassistant.data.Book
import com.clakestudio.pc.readingassistant.databinding.BookBinding

class BooksAdapter(private var books: ArrayList<Book>,
                   private val booksViewModel: BooksViewModel
) : RecyclerView.Adapter<BooksAdapter.ViewHolder>() {


    /**
     * Currently booksViewModel is not needed right now but, later when integration with
     * certain CardViews will be implemented, we will be able to easily communicate with booksViewModel
     * and for example open another activity
     * */

    class ViewHolder(private val binding: BookBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(title: String, author: String, note: String) {
            binding.tvTitle.text = title
            binding.tvAuthor.text = author
            binding.tvNote.text = note
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BooksAdapter.ViewHolder {

        val binding: BookBinding

        val inflater = LayoutInflater.from(parent!!.context)

        binding = BookBinding.inflate(inflater, parent, false)


        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BooksAdapter.ViewHolder, position: Int) = holder.bind(books[position].title, books[position].author, books[position].note)

    override fun getItemCount(): Int {
        return books.size
    }

    fun replaceData(books: ArrayList<Book>) = setBooks(books)

    private fun setBooks(books: ArrayList<Book>) {
        this.books = books
        notifyDataSetChanged()
    }

}