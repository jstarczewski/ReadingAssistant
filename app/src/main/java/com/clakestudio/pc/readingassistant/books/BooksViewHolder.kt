package com.clakestudio.pc.readingassistant.books

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.clakestudio.pc.readingassistant.R.id.*
import com.clakestudio.pc.readingassistant.data.Book

class BooksViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    // TO-DO reimplement to delete inspections

    private val title: TextView = tvTitle as TextView
    private val author: TextView = tvAuthor as TextView
    private val note: TextView = tvNote as TextView
    fun bind(book: Book) {

        title.text = book.title
        author.text = book.author
        note.text = book.note

    }


}